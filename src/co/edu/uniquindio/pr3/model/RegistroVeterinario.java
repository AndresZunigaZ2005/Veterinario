package co.edu.uniquindio.pr3.model;

import java.time.LocalDate;

public class RegistroVeterinario {

	private LocalDate fecha;
	private String diagnostico;
	private String tratamiento;
	private Estado estado;
	private Veterinario veterinario;
	private Factura factura;
	private Mascota mascota;

	/**
	 *
	 * @param fecha
	 * @param diagnostico
	 * @param tratamiento
	 * @param estado
	 * @param veterinario
	 * @param factura
	 * @param mascota
	 */
	public RegistroVeterinario(LocalDate fecha, String diagnostico, String tratamiento, Estado estado,
			Veterinario veterinario, Factura factura, Mascota mascota) {
		super();
		this.fecha = fecha;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
		this.estado = estado;
		this.veterinario = veterinario;
		this.factura = factura;
		this.mascota = mascota;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	@Override
	public String toString() {
		return "RegistroVeterinario [fecha=" + fecha + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento
				+ ", estado=" + estado + ", veterinario=" + veterinario + ", factura=" + factura + ", mascota="
				+ mascota + "]";
	}

	//////////////////////////////////////////////////////////////////////////////////
	public void crearFactura(double precio, LocalDate fechaFactura, String atencion, String observaciones, Cliente cliente) {
		if(getEstado() == Estado.ATENDIDA) {
			Factura newFactura = new Factura(precio, fechaFactura, atencion, observaciones, cliente);
			setFactura(newFactura);
		}
	}
}
