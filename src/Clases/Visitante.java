package Clases;

import java.io.Serializable;

public class Visitante extends Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1389885061055354925L;
	private double estatura,dinero;
	private int puntos, edad;
	private Categoria c;
	
	public Visitante (String nombre, String id, double estatura, int edad,double dinero) {
		super(nombre, id);
		this.estatura=estatura;
		this.edad=edad;
		this.dinero=dinero;
		this.puntos=0;
		this.c=null;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Categoria getC() {
		return c;
	}

	public void setC(Categoria c) {
		this.c = c;
	}
	
	
}
