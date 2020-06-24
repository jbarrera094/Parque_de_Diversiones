package Clases;

import java.io.Serializable;

public class Premio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7242918728272198325L;
	protected String nombre;
	protected int valorpuntos;
	protected int cantidad;
	public Premio(String nombre, int valorpuntos, int cantidad) {
		super();
		this.nombre = nombre;
		this.valorpuntos = valorpuntos;
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getValorpuntos() {
		return valorpuntos;
	}
	public void setValorpuntos(int valorpuntos) {
		this.valorpuntos = valorpuntos;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
