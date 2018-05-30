import java.util.*;

public class Tienda {
	public static int id=1;
	int id_tienda;
	String nombre;
	String direccion;
	String duenio;
	HashSet<Oferta> ofertas;
	String[][] horario = new String[2][7]; // Primera fila maniana, segunda fila tarde
	LinkedList<Opinion> opiniones;
	

	public Tienda(String nom, String dir, String due){
		id_tienda = id;
		nombre = nom;
		direccion = dir;
		duenio = due;
		ofertas = new HashSet<Oferta>();
		opiniones = new LinkedList<Opinion>();
		Tienda.id++;
		
	}
	
	public void anadirOferta(String producto, double desc, double precio, String descrip, Categorias categ) {
		Oferta of= new Oferta(producto, desc, id_tienda, precio, descrip, categ);
		ofertas.add(of);
	}
	
	public void quitarOferta(Oferta of){
		ofertas.remove(of);
	}
	
	public void mostrarOfertas(){
		Iterator<Oferta> it = ofertas.iterator();
		for(Oferta o: ofertas) {
			System.out.println("ID oferta: " + o.getId_oferta() + ". Producto: " + o.getProducto() + ". Precio: " + o.getPrecio()
			+ ". Descuento: " + o.getDescuento() + ". Descripción: " + o.getDescripcion() + ". Categorias: " + o.getCategoria() + ".");
			/*if(o.getCodigoQR()!= (Integer) null) {
				System.out.println("CodigoQR: " + o.getCodigoQR()+ ".");
			}
			if(o.getFoto() != null) {
				System.out.println("Foto: " + o.getFoto()+ ".");
			}*/
			
		}
		
	}

	public int getId_tienda() {
		return id_tienda;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDuenio() {
		return duenio;
	}
	
	public String[][] getHorario() {
		return horario;
	}
	
	public void setId_tienda(int id_tienda) {
		this.id_tienda = id_tienda;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}
	
	public String getOpiniones() {
		for(int i=0; i<opiniones.size(); i++) {
			Opinion aux =opiniones.get(i);
			System.out.println("Id:" + aux.id + ". Tienda: " + nombre + ". Escrito por: " + aux.usuario + ". Mensaje: "
			+ 	aux.mensaje + ". Puntuaci�n: " + aux.puntuacion);
		}
		return "";
	}

	public void setOpiniones(LinkedList<Opinion> opiniones) {
		this.opiniones = opiniones;
	}

	public void setHorario(String[][] horario) {
		this.horario = horario;
	}
	
	public void aniadirOp(Opinion op) {
		opiniones.add(op);
	}
	
	public void eliminarOp(Opinion op) {
		opiniones.remove(op);
	}

}
