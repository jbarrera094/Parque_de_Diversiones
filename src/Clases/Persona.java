package Clases;

import java.io.Serializable;

public abstract class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 973568458171354377L;
	protected String nombre, id;
	
	public Persona(String nombre, String id) {
		this.nombre=nombre;
		this.id=id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
