package Clases;

import java.io.Serializable;
import java.util.Arrays;

import Errores.Errores;
import Errores.noencontrado;

public class Tienda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8797289586068052725L;
	protected boolean estado;
	protected String nombre;
	protected Recuerdos[]recuerdos;
	protected Premio[]premios;
	protected Comida[]comidas;
	protected String admin;
	protected String clave;
	protected double ventasdiariasrecuerdos;
	protected double ventasdiariascomidas;
	//dejamos la clase tienda, una clase a la cual solo puede entrar el administrador,
	//por eso pedimos el admin y la clave como parametros obligados.
	public Tienda(boolean estado, String nombre, String admin, String clave) {
		this.recuerdos=new Recuerdos[0];
		this.comidas=new Comida[0];
		this.premios=new Premio[0];
		this.estado = estado;
		this.nombre = nombre;
		this.admin = admin;
		this.clave = clave;
		this.ventasdiariascomidas=0;
		this.ventasdiariasrecuerdos=0;
	}
	//********Métodos de Vender****************
	public boolean VenderRecuerdos(int Cantidad,String Nombre,Visitante cliente)throws noencontrado, Errores {
		if(Nombre!=null) {
			Recuerdos r=buscarRecuerdo(Nombre);
			if(Cantidad<r.getCantidad()) {
				if((r.getPrecio()*Cantidad)>(cliente.getDinero())) {
					throw new Errores("El monto de esta compra excede su saldo disponible");
				}else {
					cliente.setDinero(cliente.getDinero()-(Cantidad*r.getPrecio()));
					ventasdiariasrecuerdos+=r.getPrecio()*Cantidad;
					r.setCantidad(r.getCantidad()-Cantidad);
					return true;
				}
				
			}else {
				throw new Errores("La cantidad solicitada es superior a la disponible");
			}

		}else {
			throw new  noencontrado();
		}
	}
	public boolean VenderComida(int Cantidad,String Nombre,Visitante cliente) throws Errores, noencontrado {
		if(Nombre!=null) {
			Comida r=buscarComida(Nombre);
			if(Cantidad<r.getCantidad()) {
				if((Cantidad*r.getPrecio())>cliente.getDinero()) {
					throw new Errores("El monto de esta compra excede su saldo disponible");
				}else {
					cliente.setDinero(cliente.getDinero()-(Cantidad*r.getPrecio()));
					ventasdiariascomidas+=r.getPrecio()*Cantidad;
					r.setCantidad(r.getCantidad()-Cantidad);
					return true;
				}				
			}else {
				throw new Errores("La cantidad solicitada es superior a la disponible");
			}

		}else {
			throw new  noencontrado();
		}
	}
	public boolean EntregarPremios(int Cantidad,String Nombre,Visitante cliente) throws Errores, noencontrado {
		if(Nombre!=null) {
			Premio r=buscarPremio(Nombre);
			if(Cantidad<r.getCantidad()) {
				if((r.getValorpuntos()*Cantidad)>cliente.getPuntos()) {
					throw new Errores("La cantidad de puntos que tienes actulamente no es suficiente para realizar esta compra"); 
				}else {
					cliente.setPuntos(cliente.getPuntos()-(Cantidad*r.getValorpuntos()));
					r.setCantidad(r.getCantidad()-Cantidad);
					return true;
				}
			}else {
				throw new Errores("La cantidad solicitada es superior a la disponible");
			}

		}else {
			throw new  noencontrado();
		}
	}
	
	//*************Métodos de Buscar************
	public Recuerdos buscarRecuerdo(String nombre2) {
		int i=-1;
		while(++i<recuerdos.length && recuerdos[i].getNombre().compareTo(nombre2)!=0);
		return (i<recuerdos.length)? recuerdos[i]:null;
	}
	public Comida buscarComida(String nombre2) {
		int i=-1;
		while(++i<comidas.length && comidas[i].getNombre().compareTo(nombre2)!=0);
		return (i<comidas.length)? comidas[i]:null;
	}
	public Premio buscarPremio(String nombre2) {
		int i=-1;
		while(++i<premios.length && premios[i].getNombre().compareTo(nombre2)!=0);
		return (i<premios.length)? premios[i]:null;
	}
	
	//--------------------------------------------------------------------
		//------------todo lo relacionado con agregar productos---------------
		//--------------------------------------------------------------------
		public void AgregarRecuerdo(String nombre, double precio, int cant)throws Errores {
			if(buscarRecuerdo(nombre)==null) {
				Recuerdos nuevoRecuerdo = new Recuerdos(nombre, precio, cant);
				recuerdos= Arrays.copyOf(recuerdos,recuerdos.length+1);
				recuerdos[recuerdos.length-1]=nuevoRecuerdo;
			}else {
				throw new Errores("Este recuerdo ya existe");
			}
			
		}
		public void AgregarComida(String nombre, double precio, int cant)throws Errores{
			if(buscarComida(nombre)==null) {
				Comida nuevaComida=new Comida(nombre, precio, cant);
				comidas= Arrays.copyOf(comidas,comidas.length+1);
				comidas[comidas.length-1]=nuevaComida;
			}else {
				throw new Errores("Esta comida ya existe");
			}			
		}		
		public void AgregarPremio(String nombre, int precio, int cant) throws Errores {
			if(buscarPremio(nombre)==null) {
				Premio NuevoPremio=new Premio(nombre, precio, cant);
				premios= Arrays.copyOf(premios,premios.length+1);
				premios[recuerdos.length-1]=NuevoPremio;
			}else {
				throw new Errores("Este premio ya eciste");
			}
			
		}

		//--------------------------------------------------------------------
		//-------todo lo relacionado con inventarios y disponibilidad---------
		//--------------------------------------------------------------------
		/*public void ConsultarInventarioPremios(){
			for(int i=0;i<premios.length;i++) {
				System.out.println("El premio: "+premios[i].getNombre()+", tiene una cantidad disponible de: "+premios[i].getCantidad() );
			}
		}
		public void ConsultarInventarioComida(){
			for(int i=0;i<comidas.length;i++) {
				System.out.println("La comida: "+comidas[i].getNombre()+", tiene una cantidad disponible de: "+comidas[i].getCantidad() );
			}	
		}
		public void ConsultarInventarioRecuerdos(){
			for(int i=0;i<recuerdos.length;i++) {
				System.out.println("El recuerdo: "+recuerdos[i].getNombre()+", tiene una cantidad disponible de: "+recuerdos[i].getCantidad() );
			}
		}*/
		//--------------------------------------------------------------------
		//-----------------todo lo relacionado con ventas---------------------
		//--------------------------------------------------------------------
		public double[] CalcularVentasDiarias() {
			double[] r=new double[2];
			r[0]=ventasdiariasrecuerdos;
			r[1]=ventasdiariascomidas;
//			System.out.println("Se han vendido recuerdos por un valor de: "+ventasdiariasrecuerdos);
//			System.out.println("Se han vendido comidas por un valor de: "+ventasdiariascomidas);
			return r;
		}
		/*public boolean VenderRecuerdos(int Cantidad,String Nombre,Visitante cliente) {
			int i=0,posicion=-1;
			boolean venta;
			
			for (i=0; i<recuerdos.length;i++) {//Para buscar el recuerdo es mejor utilizar un While(y es mejor hacerlo en otro metodo)
				if (Nombre.contentEquals(recuerdos[i].getNombre())) {
					if (recuerdos[i].getCantidad()>=Cantidad) {
						posicion=i;
					}
				}
			}
			if(posicion==-1) {//Para esto es mejor utilizar condicionales
				System.out.println("El recuerdo no se encuentra en nuestra base de datos, o no hay suficiente cantidad del mismo.");
				venta=false;
			}
			else {
				if(cliente.getDinero()<(Cantidad*(recuerdos[posicion].getPrecio()))) {
					System.out.println("El visitante no tiene dinero suficiente para realizar la compra.");
					venta=false;
				}
				else {
					recuerdos[posicion].setCantidad(recuerdos[posicion].getCantidad()-Cantidad);//re-escribimos al cantidad luego de la venta.
					cliente.setDinero(cliente.getDinero()-(Cantidad*(recuerdos[posicion].getPrecio())));//rescribimos el dinero del usuario.
					venta=true;
				}			
			}
			if (venta=true) {
				ventasdiariasrecuerdos=ventasdiariasrecuerdos+(Cantidad*(recuerdos[posicion].getPrecio()));
			}
			return venta;
		}
		public boolean VenderComida(int Cantidad,String Nombre,Visitante cliente) {
			int i=0,posicion=-1;
			boolean venta;
			for (i=0; i<comidas.length;i++) {
				if (Nombre.contentEquals(comidas[i].getNombre())) {//vemos que exista el producto.
					if (comidas[i].getCantidad()>=Cantidad) {//vemos si hay cantidad suficiente.
						posicion=i;
					}
				}
			}
			if(posicion==-1) {
				System.out.println("La comida no se encuentra en nuestra base de datos, o no hay suficiente cantidad de la misma.");
				venta=false;
			}
			else {
				if(cliente.getDinero()<(Cantidad*(comidas[posicion].getPrecio()))) {//vemos si el cliente tiene suficiente dinero.
					System.out.println("El visitante no tiene dinero suficiente para realizar la compra.");
					venta=false;
				}
				else {
					comidas[posicion].setCantidad(comidas[posicion].getCantidad()-Cantidad);//re-escribimos al cantidad luego de la venta.
					cliente.setDinero(cliente.getDinero()-(Cantidad*(comidas[posicion].getPrecio())));//rescribimos el dinero del usuario.
					venta=true;
				}			
			}
			if (venta=true) {
				ventasdiariascomidas=ventasdiariascomidas+(Cantidad*(comidas[posicion].getPrecio()));
			}
			return venta;
			
		}
		public boolean EntregarPremios(int Cantidad,String Nombre,Visitante cliente) {
			int i=0,posicion=-1;
			boolean venta;
			for (i=0; i<premios.length;i++) {
				if (Nombre.contentEquals(premios[i].getNombre())) {//vemos que exista el producto.
					if (premios[i].getCantidad()>=Cantidad) {//vemos si hay cantidad suficiente.
						posicion=i;
					}
				}
			}
			if(posicion==-1) {
				System.out.println("El premio no se encuentra en nuestra base de datos, o no hay suficiente cantidad del mismo.");
				venta=false;
			}
			else {
				if(cliente.getPuntos()<(Cantidad*(premios[posicion].getValorpuntos()))) {//vemos si el cliente tiene suficiente dinero.
					System.out.println("El visitante no tiene dinero suficiente para realizar la compra.");
					venta=false;
				}
				else {
					premios[posicion].setCantidad(premios[posicion].getCantidad()-Cantidad);//re-escribimos al cantidad luego de la venta.
					cliente.setPuntos(cliente.getPuntos()-(Cantidad*(premios[posicion].getValorpuntos())));//rescribimos el dinero del usuario.
					venta=true;
				}			
			}
			return venta;
		}
		/*El método "login" lo dejaré comentado, porq segun pensé la clase 
		 * solo el admin usará esta clase, y desde el mismo instante en que
		 * entra a la clase y usa el constructor, se toma como su login:
		 * 
		 * public void Login(String admin,String clave){
		 * 		
		 * }
		 */
		public String getAdmin() {
			return admin;
		}
		public boolean isEstado() {
			return estado;
		}
		public void setEstado(boolean estado) {
			this.estado = estado;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Recuerdos[] getRecuerdos() {
			return recuerdos;
		}
		public void setRecuerdos(Recuerdos[] recuerdos) {
			this.recuerdos = recuerdos;
		}
		public Premio[] getPremios() {
			return premios;
		}
		public void setPremios(Premio[] premios) {
			this.premios = premios;
		}
		public Comida[] getComidas() {
			return comidas;
		}
		public void setComidas(Comida[] comidas) {
			this.comidas = comidas;
		}
		public String getClave() {
			return clave;
		}
		public void setClave(String clave) {
			this.clave = clave;
		}
		

		
}
