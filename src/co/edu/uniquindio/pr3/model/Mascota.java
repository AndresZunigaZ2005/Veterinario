package co.edu.uniquindio.pr3.model;

import java.util.Objects;
import java.util.UUID;

import javafx.scene.image.Image;

public class Mascota {

	private UUID idMascota;
	private String nombre;
	private int edad;
	private String raza;
	private Sexo sexo;
	private Tipo tipo;

	/**
	 *
	 * @param nombre
	 * @param edad
	 * @param raza
	 * @param sexo
	 * @param tipo
	 */
	public Mascota(String nombre, int edad, String raza, Sexo sexo, Tipo tipo) {
		super();
		this.idMascota = UUID.randomUUID();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.sexo = sexo;
		this.tipo = tipo;
	}

	public UUID getIdMascota() {
		return idMascota;
	}


	public void setIdMascota(UUID idMascota) {
		this.idMascota = idMascota;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre, raza, sexo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre) && Objects.equals(raza, other.raza)
				&& sexo == other.sexo && tipo == other.tipo;
	}
	
}
