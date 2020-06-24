package Clases;

import java.io.Serializable;

public class Comida implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 779707427328405387L;
	protected String nombre;
	protected double precio;
	protected int cantidad;
	
	public Comida(String nombre, double precio2, int cantidad) {
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
