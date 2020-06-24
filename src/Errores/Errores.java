package Errores;

import java.io.Serializable;

public class Errores extends Exception implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1336359169297105195L;

	public Errores(String s) {
		super(s);
	}	
}
