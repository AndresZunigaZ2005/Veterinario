package co.edu.uniquindio.pr3.model;

public abstract class Persona {

	private String nombre;
	private String telefono;
	private String correo;

	/**
	 *
	 * @param nombre
	 * @param telefono
	 * @param correo
	 */
	public Persona(String nombre, String telefono, String correo) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + "]";
	}


}
