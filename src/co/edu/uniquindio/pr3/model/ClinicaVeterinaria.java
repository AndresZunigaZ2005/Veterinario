package co.edu.uniquindio.pr3.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;

import co.edu.uniquindio.pr3.exceptions.ClienteException;
import co.edu.uniquindio.pr3.exceptions.RegistroVeterinarioException;

public class ClinicaVeterinaria {

	private String nombre;
	private Veterinario[] listaVeterinarios;
	private List<Cliente> listaClientes;
	private List<RegistroVeterinario> listaRegistroVeterinario;

	
	public ClinicaVeterinaria(String nombre) {
		this.nombre = nombre;
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
	 * Metodos CRUD mascotas
	 */
	public void crearMascota(Mascota nuevaMascota, String cedula) {
		//listaClientes
	}
	
	/**
	 * Metodos CRUD Clientes
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
				.anyMatch(x ->x.getCedula().equals(cedula));
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
	 * Metodos CRUD registroVeterinario
	 */
	public void aniadirRegistroVeterinario(RegistroVeterinario nuevoRegistroVeterinario) throws RegistroVeterinarioException{
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
	
    public void eliminarRegistrosAntiguos() {
        LocalDate fechaActual = LocalDate.now();
        Iterator<RegistroVeterinario> iterador = listaRegistroVeterinario.iterator();

        while (iterador.hasNext()) {
            RegistroVeterinario registro = iterador.next();
            LocalDate fechaRegistro = registro.getFecha(); 

            // Calcular la diferencia en años entre la fecha actual y la fecha del registro
            long añosDiferencia = fechaRegistro.until(fechaActual).getYears();

            if (añosDiferencia > 2) {
                iterador.remove(); // Eliminar el registro si tiene más de 2 años de antigüedad
            }
        }
    }
    
    public void actualizarRegistroVeterinario(RegistroVeterinario registroVeterinario,Estado estado) {
    	registroVeterinario.setEstado(estado);
    }
}
