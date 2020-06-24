package Errores;

import java.io.Serializable;

public class ECamposVacios extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7482110198856395167L;

	public ECamposVacios() {
		// TODO Auto-generated constructor stub
		super("Todos los campos deben rellenarse");
	}

}
