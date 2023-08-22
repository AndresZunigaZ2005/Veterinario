package co.edu.uniquindio.pr3.model;

public class Mascota {

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
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.sexo = sexo;
		this.tipo = tipo;
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
		return "Mascota [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", sexo=" + sexo + ", tipo=" + tipo
				+ "]";
	}

}
