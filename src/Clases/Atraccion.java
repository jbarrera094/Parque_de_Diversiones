package Clases;

import java.io.Serializable;

public class Atraccion implements Serializable{
	
	//atributos
	private static final long serialVersionUID = -5121575697888380231L;
	private String nombre;
	private int limitePersonas;
	private boolean estado;
	private int puntosAtraccion;
	private double estaturaLimite;
	private int cont;
	private String categoriaRequerida;
	
	//constructor
	public Atraccion(String nombre, int limitePersonas,  int puntosAtraccion,
			double estaturaLimite, String categoriaRequerida) {
		super();
		this.nombre = nombre;
		this.limitePersonas = limitePersonas;
		this.estado = true;
		this.puntosAtraccion = puntosAtraccion;
		this.estaturaLimite = estaturaLimite;
		this.categoriaRequerida=categoriaRequerida;
		this.cont=0;
	}
	
	//getters & setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLimitePersonas() {
		return limitePersonas;
	}

	public void setLimitePersonas(int limitePersonas) {
		this.limitePersonas = limitePersonas;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getPuntosAtraccion() {
		return puntosAtraccion;
	}

	public void setPuntosAtraccion(int puntosAtraccion) {
		this.puntosAtraccion = puntosAtraccion;
	}

	public double getEstaturaLimite() {
		return estaturaLimite;
	}

	public void setEstaturaLimite(double estaturaLimite) {
		this.estaturaLimite = estaturaLimite;
	}
	public String getCategoriaRequerida() {
		return categoriaRequerida;
	}

	public void setCategoriaRequerida(String categoriaRequerida) {
		this.categoriaRequerida = categoriaRequerida;
	}
	
	//Verificar la entrada segun la estatura, la categoria y el limite de personas disponibles en la atraccion
	public boolean verificarEntrada(double estatura,String categoria) {		
		if(estatura>=estaturaLimite && cont<=limitePersonas ) {
			if(categoria.compareTo("Oro")==0 && (categoriaRequerida.compareTo("Oro")==0 || 
					categoriaRequerida.compareTo("Plata")==0 || categoriaRequerida.compareTo("Bronce")==0)) {
				cont++;
				return true;
			}else {
				if(categoria.compareTo("Plata")==0 && (categoriaRequerida.compareTo("Plata")==0 || 
						categoriaRequerida.compareTo("Bronce")==0)) {
					cont++;
					return true;
				}else {
					if(categoria.compareTo("Brone")==0 && categoriaRequerida.compareTo("Bronce")==0) {
						cont++;
						return true;
					}else {
						return false;
					}
				}
			}
		}else {
			return false;
		}
	}
	//Reducir el contador de las personas que han entrado
	public void bajarVisitante() {
		cont--;
	}
}
