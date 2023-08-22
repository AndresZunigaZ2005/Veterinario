package co.edu.uniquindio.pr3.model;

import java.util.List;

public class Cliente extends Persona{

	private String cedula;
	private String direccion;
	private List<Mascota> listaMascotas;

	/**
	 *
	 * @param nombre
	 * @param telefono
	 * @param correo
	 * @param cedula
	 * @param direccion
	 * @param listaMascotas
	 */
	public Cliente(String nombre, String telefono, String correo, String cedula, String direccion,
			List<Mascota> listaMascotas) {
		super(nombre, telefono, correo);
		this.cedula = cedula;
		this.direccion = direccion;
		this.listaMascotas = listaMascotas;
	}

	/**
	 *
	 * @param nombre
	 * @param telefono
	 * @param correo
	 * @param cedula
	 * @param direccion
	 */

	public Cliente(String nombre, String telefono, String correo, String cedula, String direccion) {
		super(nombre, telefono, correo);
		this.cedula = cedula;
		this.direccion = direccion;

	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Mascota> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<Mascota> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}

	@Override
	public String toString() {
		return "Cliente [nombre: "+getNombre()+", telefono: "+getTelefono()+", corrreo: "+getCorreo()+", cedula=" + cedula + ", direccion=" + direccion + ", listaMascotas=" + listaMascotas + "]";
	}


}
