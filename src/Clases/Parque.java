package Clases;

import java.io.Serializable;
import java.util.Arrays;

import Errores.Errores;
import Errores.noencontrado;


public class Parque implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7299235497143410160L;
	private String nombre;
	private Tienda [] tiendas;
	private Atraccion [] atracciones;
	private Boleta[] boletas;
	private Empleado[] empleados;
	private Visitante[] visitantes;
	private Categoria[] categorias;

	//CONSTRUCTOR

	public Parque(String nombre) {
		this.nombre = nombre;
		this.tiendas=new Tienda[0];
		this.atracciones=new Atraccion[0];
		this.boletas=new Boleta[0];
		this.categorias= new Categoria[3];
		categorias[0]=new Categoria("Oro");
		categorias[1]=new Categoria("Plata");
		categorias[2]=new Categoria("Bronce");
		this.empleados=new Empleado[0];
		this.visitantes=new Visitante[0];
	}		

	//METODOS

	public Parque() {		
	}

	public void asignarPuntos(String id,String maqui) {
		Visitante v=buscarVisitante(id);
		Atraccion a=buscaratraccion(maqui);
		v.setPuntos(v.getPuntos()+a.getPuntosAtraccion());

	}
	public void actualizarFichero() {
		Fichero_Parque p=new Fichero_Parque();
		p.WriteFileObjectpark("Backup.ej", this);
	}
	public Parque leerFihero() {
		Fichero_Parque p=new Fichero_Parque();
		return p.ReadFileObjectpark("Backup.ej");
	}
	
	public boolean addTienda(String nombre, String admin, String clave) {
		if(buscarTienda(nombre)==null) {
			Tienda n=new Tienda(true, nombre, admin, clave);
			tiendas=Arrays.copyOf(tiendas, tiendas.length+1);
			tiendas[tiendas.length-1]=n;
			return true;
		}else {
			return false;
		}
	}
	
	
	public Tienda buscarTienda(String nombre2) {
		int i=-1;
		while(++i<tiendas.length && tiendas[i].getAdmin().compareTo(nombre2)!=0);
		return (i<tiendas.length)? tiendas[i]:null;
	}

	public boolean addVisitante(String nombre,String cc,double estatura,double dinero,int edad) {
		if(buscarVisitante(nombre)==null) {
			Visitante n=new Visitante(nombre, cc, estatura, edad, dinero);
			visitantes=Arrays.copyOf(visitantes, visitantes.length+1);
			visitantes[visitantes.length-1]=n;
			return true;
		}else {
			System.out.println(("El visitante ya se encuentra registrado"));
			return false;
		}

	}

	public Visitante buscarVisitante(String id) {
		int i=-1;
		while(++i<visitantes.length && visitantes[i].getId().compareTo(id)!=0);
		return (i<visitantes.length)? visitantes[i]:null;
	}

	public boolean Addatraccion(String nombre, int limitePersonas,  int puntosAtraccion,
			double estaturaLimite, String categoriaRequerida) throws noencontrado, Errores {
		if(buscaratraccion(nombre)==null) {
			Atraccion a=new Atraccion(nombre, limitePersonas, puntosAtraccion, estaturaLimite, categoriaRequerida);
			atracciones=Arrays.copyOf(atracciones, atracciones.length+1);
			atracciones[atracciones.length-1]=a;
			return true;
			}else {
				System.out.println(("Esta atracción ya se encuentra registrada"));
				return false;
		}
	}

	public void Addboleta(Categoria categoria,Visitante v,double precio) {
		if (boletas==null) {
			Boleta[] boletas = new Boleta[1];
		}else {
			boletas= Arrays.copyOf(boletas, boletas.length+1);
		}
		boletas[boletas.length-1]= new Boleta(Integer.toString(boletas.length), precio, categoria,v);
	}

	public boolean Addempleado(String nombre, String id, double pagodiario) { 
		if (buscarEmpleado(nombre)==null) {
			Empleado e=new Empleado(nombre, id,pagodiario);
			empleados=Arrays.copyOf(empleados, empleados.length+1);
			empleados[empleados.length-1]=e;
			return true;
		}else {
			System.out.println(("El empleado ya se encuentra registrado"));
			return false;
		}
	}
	
	public Empleado buscarEmpleado(String id) {
		int i=-1;
		while(++i<empleados.length && empleados[i].getId().compareTo(id)!=0);
		return (i<empleados.length)? empleados[i]:null;
	}
	
	public boolean eliminarAtraccion(String nombre) throws noencontrado {
		if(buscarIndiceAtraccion(nombre)<0) {
			throw new noencontrado();
		}else {
			int i=buscarIndiceAtraccion(nombre);
			for (int j = i; j < atracciones.length-1; j++) {
				atracciones[j]=atracciones[j+1];
			}
			atracciones=Arrays.copyOf(atracciones, atracciones.length-1);
			return true;
		}
	}
	private int buscarIndiceAtraccion(String nombre2) {
		int i=-1;
		while(++i<atracciones.length && atracciones[i].getNombre().compareTo(nombre2)!=0);
		return (i<atracciones.length)? i:-1;
	}

	public boolean eliminarBoleta(String id) throws noencontrado {
		if(buscarIndiceBoleta(id)<0) {
			throw new noencontrado();
		}else {
			int i=buscarIndiceBoleta(id);
			for (int j = i; j < boletas.length-1; j++) {
				boletas[j]=boletas[j+1];
			}
			boletas=Arrays.copyOf(boletas, boletas.length-1);
			return true;
		}
	}

	private int buscarIndiceBoleta(String id) {
		int i=-1;
		while(++i<boletas.length &&boletas[i].getId().compareTo(id)!=0);
		return (i<boletas.length)? i:-1;
	}

	/*public void eliminarpersonas(String id) throws noencontrado { //este se podria hacer juntando los vectores de visitante y empleado
		int l1=visitantes.length;
		int l2=empleados.length;
		int l= l1+l2;
		Persona personas[]= new Persona[l];
		Arrays.fill(personas, null);
		System.arraycopy(visitantes, 0, personas, 0, personas.length-1);
		System.arraycopy(empleados, 0, personas, visitantes.length, personas.length-1);

		for (int i=0; i<visitantes.length;i++) {
			if (id== visitantes[i].getId()) {
				visitantes[i]=null;
				visitantes= Arrays.copyOf(visitantes,visitantes.length-1);
			}else {
				throw new noencontrado();
			}
		}

		for (int j=0; j<empleados.length;j++) {
			if (id== empleados[j].getId()) {
				empleados[j]=null;
				empleados= Arrays.copyOf(empleados, empleados.length-1);
			}else {
				throw new noencontrado();
			}
		}
	}*///Bueno Maria, acá si no te entendi porque segun tu comentario dijiste que ibas a guntar las dos y luego lo eliminabas y luego te diste cuenta
	//de que de ese modo no te sirve entonces hay si lo haces del modo que si es que es por cada uno de los arreglos.
	public boolean eliminarPersona(String id)throws noencontrado {
		if(buscarIndVisitante(id)<0) {
			if(buscarIndEmpleado(id)<0) {
				throw new noencontrado();
			}else {
				int i=buscarIndEmpleado(id);
				for (int j = i; j < empleados.length-1; j++) {
					empleados[j]=empleados[j+1];
				}
				empleados=Arrays.copyOf(empleados, empleados.length-1);
				return true;
			}
		}else {
			int i=buscarIndVisitante(id);
			for (int j = i; j < visitantes.length-1; j++) {
				visitantes[j]=visitantes[j+1];
			}
			visitantes=Arrays.copyOf(visitantes, visitantes.length-1);
			return true;
		}
	}

	//BUSCAR (tengo dudas con el de buscar boleta) R/esta melo

	private int buscarIndEmpleado(String id) {
		int i=-1;
		while(++i<empleados.length &&empleados[i].getId().compareTo(id)!=0);
		return (i<empleados.length)? i:-1;
	}

	private int buscarIndVisitante(String id) {
		int i=-1;
		while(++i<visitantes.length &&visitantes[i].getId().compareTo(id)!=0);
		return (i<visitantes.length)? i:-1;
	}

	public Atraccion buscaratraccion(String nombre) {
		int i=0;
		while (i<atracciones.length && atracciones[i].getNombre().compareTo(nombre)!=0) {
			i++;
		}
		if (i<atracciones.length) {
			return atracciones[i];

		}else {
			return null;
		}
	}

	public Boleta buscarboleta(String codigo) throws noencontrado {
		int i=0;
		while (i<boletas.length && boletas[i].getId().compareTo(codigo)!=0) {
			i++;
		}
		if (i==boletas.length) {
			throw new noencontrado();

		}else {
			return boletas[i];
		}
	}



	//GETS Y SETS
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tienda[] getTiendas() {
		return tiendas;
	}
	public void setTiendas(Tienda[] tiendas) {
		this.tiendas = tiendas;
	}
	public Atraccion[] getAtracciones() {
		return atracciones;
	}
	public void setAtracciones(Atraccion[] atracciones) {
		this.atracciones = atracciones;
	}
	public Boleta[] getBoletas() {
		return boletas;
	}
	public void setBoletas(Boleta[] boletas) {
		this.boletas = boletas;
	}
	public Empleado[] getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Empleado[] empleados) {
		this.empleados = empleados;
	}
	public Visitante[] getVisitantes() {
		return visitantes;
	}
	public void setVisitantes(Visitante[] visitantes) {
		this.visitantes = visitantes;
	}
	public Categoria[] getCategorias() {
		return categorias;
	}
	public void setCategorias(Categoria[] categorias) {
		this.categorias = categorias;
	}

	public static void main(String[] args) {
//		Parque p=new Parque("EEE");
//		try {		
//			p.Addatraccion("La mota", 4, 1, 1.25, "ORO");
//			p.addVisitante("Juan", "0554", 2, 200, 30);
//			//Categoria c=new Categoria("ORO", p.getAtracciones());
//			p.Addboleta(c, p.getVisitantes()[0], 150);
//			p.Addempleado("YACK", "575", 6852);
//			p.addTienda(true, "PEPE", "admin", "admin");
//			
//			System.out.println(p.getAtracciones()[0].getNombre());
//			System.out.println(p.getBoletas()[0].getVisitante().getNombre());
//			System.out.println(p.getTiendas()[0].getNombre());
//			p.eliminarAtraccion("La mota");
//			System.out.println(p.getAtracciones().length);
//			//System.out.println(p.getAtracciones()[0]);
//			
//			
//		} catch (noencontrado | Errores e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
////		}
//		Parque p=new Parque();
//		System.out.println(p.leerFihero().getVisitantes()[0].getEdad());
	}

}