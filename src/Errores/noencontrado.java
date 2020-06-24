package Errores;
import java.io.Serializable;

public class noencontrado extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5587776141462181465L;

	public noencontrado() {
		super("No se encontro lo que buscaba");
	}	
}