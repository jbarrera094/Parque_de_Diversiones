package Clases;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -127957109930614747L;
	private boolean estado;
	private double pagoDiario;
	
	public Empleado(String nombre, String id, double pagoDiario) {
		//revisar si si puede ser el pago recibido por parámetero
		super(nombre, id);
		this.pagoDiario=pagoDiario;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public double getPagoDiario() {
		return pagoDiario;
	}

	public void setPagoDiario(double pagoDiario) {
		this.pagoDiario = pagoDiario;
	}
	
	public double salario(int dias) {
		return pagoDiario*dias;
	}

}
