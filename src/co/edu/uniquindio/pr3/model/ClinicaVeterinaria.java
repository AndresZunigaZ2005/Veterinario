package co.edu.uniquindio.pr3.model;

import java.util.Arrays;
import java.util.List;

public class ClinicaVeterinaria {

	private String nombre;
	private Veterinario[] listaVeterinarios;
	private List<RegistroVeterinario> listaRegistroVeterinario;

	/**
	 *
	 * @param nombre
	 * @param listaVeterinarios
	 * @param listaRegistroVeterinario
	 */
	public ClinicaVeterinaria(String nombre, int cantVeterinarios,
			List<RegistroVeterinario> listaRegistroVeterinario) {
		super();
		this.nombre = nombre;
		this.listaVeterinarios = new Veterinario[cantVeterinarios];
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

}
