package co.edu.uniquindio.pr3.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;

import co.edu.uniquindio.pr3.exceptions.ClienteException;
import co.edu.uniquindio.pr3.exceptions.MascotaException;
import co.edu.uniquindio.pr3.exceptions.RegistroVeterinarioException;

public class ClinicaVeterinaria {

	private String nombre;
	private Veterinario[] listaVeterinarios;
	private List<Cliente> listaClientes;
	private List<RegistroVeterinario> listaRegistroVeterinario;

	
	public ClinicaVeterinaria(String nombre) {
		this.nombre = nombre;
	}
	
	public ClinicaVeterinaria() {
		// TODO Auto-generated constructor stub
	}
	
	public ClinicaVeterinaria(String nombre, Veterinario[] listaVeterinarios, List<Cliente> listaClientes,
			List<RegistroVeterinario> listaRegistroVeterinario) {
		super();
		this.nombre = nombre;
		this.listaVeterinarios = listaVeterinarios;
		this.listaClientes = listaClientes;
		this.listaRegistroVeterinario = listaRegistroVeterinario;
	}


	/*
	 * Metodos set y get
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Veterinario[] getListaVeterinarios() {
		return listaVeterinarios;
	}

	public void setListaVeterinarios(Veterinario[] listaVeterinarios) {
		this.listaVeterinarios = listaVeterinarios;
	}
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<RegistroVeterinario> getListaRegistroVeterinario() {
		return listaRegistroVeterinario;
	}

	public void setListaRegistroVeterinario(List<RegistroVeterinario> listaRegistroVeterinario) {
		this.listaRegistroVeterinario = listaRegistroVeterinario;
	}
	

	@Override
	public String toString() {
		return "ClinicaVeterinaria [nombre=" + nombre + ", listaVeterinarios=" + Arrays.toString(listaVeterinarios)
				+ ", listaRegistroVeterinario=" + listaRegistroVeterinario + "]";
	}
	
	/**
	 * Metodos CRUD mascotas /////////////////////////////////////////////////////
	 */
	public void aniadirMascotaCliente(String nombre, int edad, String raza, Sexo sexo, 
			Tipo tipo, String cedula) throws MascotaException{
		Mascota nuevaMascota = new Mascota(nombre, edad, raza, sexo, tipo);
		Cliente cliente = obtenerCliente(cedula);
		if(cliente.buscarMascotaRepetida(nuevaMascota)) {
			throw new MascotaException("La mascota ya esta añadida en el cliente");
		}
		cliente.getListaMascotas().add(nuevaMascota);
	}
	
	public Mascota obtenerMascota(String identificacion, String cedula) {
		Cliente cliente = obtenerCliente(cedula);
		return cliente.getListaMascotas().stream()
				.filter(x ->x.getIdentificacion().equals(identificacion))
				.findFirst()
				.orElse(null);
	}
	
	public void actualizarMascota(String identificacion, String cedula,int edad) {
		Mascota mascota = obtenerMascota(identificacion, cedula);
		mascota.setEdad(edad);
	}
	
	
	/**
	 * Metodos CRUD Clientes  //////////////////////////////////////////////////////
	 */
	
	public void crearCliente(String nombre, String telefono, String correo, String cedula, String direccion) throws ClienteException{
		
		Cliente nuevoCliente = new Cliente(nombre, telefono, correo, cedula, direccion);
		if(verificarCliente(nuevoCliente.getCedula())) {
			throw new ClienteException("El cliente ya existe");
		}
		listaClientes.add(nuevoCliente);
		
	}
	
	public Cliente obtenerCliente(String cedula) {
		return listaClientes.stream()
				.filter(x ->x.getCedula().equals(cedula))
				.findFirst()
				.orElse(null);
	}	
	
	public boolean verificarCliente(String cedula) {
		return listaClientes.stream()
				.anyMatch(c ->c.getCedula().equals(cedula));
	}
	
	
	public void actualizarCliente(String nombre, String telefono, String correo, String cedula) {
		Cliente actualizarCliente = obtenerCliente(cedula);
		if(actualizarCliente != null) {
			actualizarCliente.setNombre(nombre);
			actualizarCliente.setTelefono(telefono);
			actualizarCliente.setCorreo(correo);
		}
	}
	
	/**
	 * Metodos CRUD registroVeterinario   ///////////////////////////////////////////////
	 */
	public void aniadirRegistroVeterinario(LocalDateTime fecha, String diagnostico, String tratamiento, Estado estado,
			Veterinario veterinario, Factura factura, Mascota mascota) throws RegistroVeterinarioException{
		RegistroVeterinario nuevoRegistroVeterinario = new RegistroVeterinario(fecha, diagnostico, tratamiento, estado, veterinario, factura, mascota);
		if(verificarRegistroVeterinario(nuevoRegistroVeterinario)) {
			throw new RegistroVeterinarioException("Error al hacer el registro, este registro ya existe");
		}
		listaRegistroVeterinario.add(nuevoRegistroVeterinario);
	}
	
	public RegistroVeterinario obtenerRegistroVeterinario(RegistroVeterinario nuevoRegistroVeterinario) throws RegistroVeterinarioException{
		return listaRegistroVeterinario.stream()
				.filter(x ->x.equals(nuevoRegistroVeterinario))
				.findFirst()
				.orElse(null);
	}
	
	public boolean verificarRegistroVeterinario(RegistroVeterinario nuevoRegistroVeterinario) {
		return listaRegistroVeterinario.stream()
				.anyMatch(x -> x.equals(nuevoRegistroVeterinario));
	}
	   
    public void actualizarRegistroVeterinario(RegistroVeterinario registroVeterinario,Estado estado) {
    	registroVeterinario.setEstado(estado);
    }
    
    /**
     * Metodos CRUD factura
     */
    public void crearFactura(double precio, LocalDate fechaFactura, String atencion, 
    		String observaciones,String cedula, RegistroVeterinario registroVeterinario) {
    	Cliente cliente = obtenerCliente(cedula);
		registroVeterinario.crearFactura(precio, fechaFactura, atencion, observaciones, cliente);		
    }
}
