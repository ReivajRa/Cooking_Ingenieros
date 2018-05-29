package CheapDeal;
import java.util.*;

public class Tienda {
	private static int id=1;
	private int id_tienda;
	private String nombre;
	private String direccion;
	private String duenio;
	private HashSet<Oferta> ofertas;
	private String[][] horario = new String[2][7]; // Primera fila maniana, segunda fila tarde
	private HashSet<Opinion> opiniones;
	

	public Tienda(String nom, String dir, String due){
		id_tienda = id;
		nombre = nom;
		direccion = dir;
		duenio = due;
		ofertas = new HashSet<Oferta>();
		opiniones = new HashSet<Opinion>();
		Tienda.id++;
		
	}
	
	public void anadirOferta(String producto, double desc, double precio, String descrip, HashSet<Categorias> categ) {
		Oferta of= new Oferta(producto, desc, this , precio, descrip, categ);
		ofertas.add(of);
	}
	
	public void quitarOferta(Oferta of){
		ofertas.remove(of);
	}
	
	public void verOfertas(){
		for(Oferta o: ofertas) {
			System.out.println(o.toString());
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
	
	public void mostrarOpiniones() {
		for(Opinion o: opiniones) {
			System.out.println(o.toString());
		}
	}

	public static int getId() {
		return id;
	}

	public HashSet<Oferta> getOfertas() {
		return ofertas;
	}

	public HashSet<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOfertas(HashSet<Oferta> ofertas) {
		this.ofertas = ofertas;
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

	public void setOpiniones(HashSet<Opinion> opiniones) {
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

	public String toString() {
		return "Tienda [id_tienda=" + id_tienda + ", nombre=" + nombre + ", direccion=" + direccion + ", duenio="
				+ duenio + ", horario=" + Arrays.toString(horario) + "]";
	}
	
	

}
