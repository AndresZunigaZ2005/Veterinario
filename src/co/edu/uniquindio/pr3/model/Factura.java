package co.edu.uniquindio.pr3.model;

import java.time.LocalDate;

public class Factura {

	private double precio;
	private LocalDate fechaFactura;
	private String atencion;
	private String observaciones;
	private Cliente cliente;

	/**
	 *
	 * @param precio
	 * @param fechaFactura
	 * @param atencion
	 * @param observaciones
	 * @param cliente
	 */
	public Factura(double precio, LocalDate fechaFactura, String atencion, String observaciones, Cliente cliente) {
		super();
		this.precio = precio;
		this.fechaFactura = fechaFactura;
		this.atencion = atencion;
		this.observaciones = observaciones;
		this.cliente = cliente;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDate getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(LocalDate fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public String getAtencion() {
		return atencion;
	}

	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Factura [precio=" + precio + ", fechaFactura=" + fechaFactura + ", atencion=" + atencion
				+ ", observaciones=" + observaciones + ", cliente=" + cliente + "]";
	}


}
