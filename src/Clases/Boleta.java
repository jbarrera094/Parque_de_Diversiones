package Clases;

import java.io.Serializable;

public class Boleta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6431090351451655784L;
	private double precio;
	private Categoria categoria;
	private Visitante visitante;
	private String id;
	
	public Boleta(String id,double precio, Categoria categoria,Visitante v) {
		super();
		this.id=id;
		this.precio = precio;
		this.categoria = categoria;
		this.visitante=v;
	}
	
	public Boleta(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Visitante getVisitante() {
		return visitante;
	}
	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}
}
