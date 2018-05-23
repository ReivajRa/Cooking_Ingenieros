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
		for(Oferta o: Ofertas) {
			
		}
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
			if(o.getCodigoQR()!= (Integer) null) {
				System.out.println("CodigoQR: " + o.getCodigoQR()+ ".");
			}
			if(o.getFoto() != null) {
				System.out.println("Foto: " + o.getFoto()+ ".");
			}
			
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
	
	public void getOpiniones() {
		for(int i=0; i<opiniones.size(); i++) {
			System.out.println(opiniones.get(i).mostrarOp());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duenio == null) ? 0 : duenio.hashCode());
		result = prime * result + id_tienda;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tienda other = (Tienda) obj;
		if (duenio == null) {
			if (other.duenio != null)
				return false;
		} else if (!duenio.equals(other.duenio))
			return false;
		if (id_tienda != other.id_tienda)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
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
