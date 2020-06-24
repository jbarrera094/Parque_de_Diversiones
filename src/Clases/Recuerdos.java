package Clases;

import java.io.Serializable;

public class Recuerdos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5364072697518231562L;
	protected String nombre;
	protected double precio;
	protected int cantidad;
	
	public Recuerdos(String nombre, double precio2, int cantidad) {
		super();
		this.nombre = nombre;
		this.precio = precio2;
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
