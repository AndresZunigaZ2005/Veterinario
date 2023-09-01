package co.edu.uniquindio.pr3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
		this.listaMascotas = new ArrayList<>();
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
		return "Cliente [cedula=" + cedula + ", direccion=" + direccion + "]";
	}

	
    @Override
	public int hashCode() {
		return Objects.hash(cedula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cedula, other.cedula);
	}

	/*
     ///////////////////////////////////////////
     */
	public boolean buscarMascotaRepetida(Mascota mascotaNueva) {
		for (Mascota mascota : listaMascotas) {
			if(mascota.getIdMascota().equals(mascotaNueva.getIdMascota())) {
				return true;
			}
		}
		return false;
	}
}
