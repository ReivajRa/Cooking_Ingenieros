package CheapDeal;

import java.util.*;
import java.util.Map;

public class Tienda implements Comparable<Tienda>{
	private static int id=1;
	private int id_tienda;
	private String nombre;
	private String direccion;
	private String duenio;
	private Map<Integer, Oferta> ofertas;
	private String[][] horario = new String[2][7]; // Primera fila maniana, segunda fila tarde
	private Map<Integer, Opinion> opiniones;
	private double puntuacion;
	private double posX, posY;
	private double distanciaAux;
	

	public Tienda(String nom, String dir, String due, double posY, double posX){
		id_tienda = id;
		nombre = nom.toUpperCase();
		direccion = dir;
		duenio = due.toUpperCase();
		ofertas = new TreeMap<Integer, Oferta>();
		opiniones = new TreeMap<Integer, Opinion>();
		Tienda.id++;
		puntuacion = 0;
		this.posX = posX;
		this.posY = posY;
		
	}
	
	public int getId_tienda() {
		return id_tienda;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public String getDuenio() {
		return duenio;
	}
	
	public Map<Integer, Oferta> getOfertas() {
		return ofertas;
	}

	public String[][] getHorario() {
		return horario;
	}
	
	public Map<Integer, Opinion> getOpiniones() {
		return opiniones;
	}
	
	public double getPuntuacion() {
		return puntuacion/opiniones.size();
	}
	
	public double getPosX() {
		return posX;
	}
	
	public double getPosY() {
		return posY;
	}
	
	public double getDistancia() {
		return distanciaAux;
	}

	public void setId_tienda(int id_tienda) {
		this.id_tienda = id_tienda;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}
	
	public void setOfertas(Map<Integer, Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public void setHorario(String[][] horario) {
		this.horario = horario;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public void setOpiniones(Map<Integer, Opinion> opiniones) {
		this.opiniones = opiniones;
	}

	public int anadirOferta(String producto, double desc, double precio, String descrip, HashSet<Categorias> categ) {
		Oferta of= new Oferta(producto, desc, this , precio, descrip, categ);
		if(!ofertas.containsKey(of.hashCode())) {
			ofertas.put(of.hashCode(), of);
			return of.hashCode();
		}
		System.err.println("La oferta ya existe");
		return -1;
	}

	public void quitarOferta(int id){
		ofertas.remove(id);
	}

	public void verOfertas(){
		Set<Map.Entry<Integer, Oferta>> set = ofertas.entrySet();
		for(Map.Entry<Integer, Oferta> o:set) {
			System.out.println("Id_Oferta: " + o.getKey() + ". Oferta: " + o.getValue().toString() + ".");
		}
	}

	public int aniadirOp(Cliente usu, String msj, int punt) {
		Opinion op = new Opinion(usu, msj, punt, this);
		if(!(opiniones.containsKey(op.getUsuario().getId()))) {
			puntuacion += op.getPuntuacion();
			opiniones.put(op.getUsuario().getId(), op);
			usu.anadirOp(op);
			return op.getUsuario().getId();
		}
		System.err.println("La opinion ya existe");
		return -1;
	}
	
	public void eliminarOp(Integer id) {
		puntuacion -= opiniones.get(id).getPuntuacion();
		opiniones.get(id).getUsuario().eliminarOp(opiniones.get(id));
		opiniones.remove(id);
	}

	public void mostrarOpiniones() {
		Set<Map.Entry<Integer, Opinion>> set = opiniones.entrySet();
		for(Map.Entry<Integer, Opinion> o: set) {
			System.out.println("Id_Opinion: " + o.getKey() + ". Opinion: " + o.getValue().toString() + ".");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((duenio == null) ? 0 : duenio.hashCode());
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
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (duenio == null) {
			if (other.duenio != null)
				return false;
		} else if (!duenio.equals(other.duenio))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public String toString() {
		return "Tienda [id_tienda=" + id_tienda + ", nombre=" + nombre + ", direccion=" + direccion + ", duenio="
				+ duenio + ", horario=" + Arrays.toString(horario) + "]";
	}
	
	public void actualizarDistancia(double Y, double X) {
		distanciaAux = Math.sqrt( Math.pow(Math.abs(posY - Y), 2) + Math.pow(Math.abs(posX - X), 2) );
	}

	
	public int compareTo(Tienda t) {
		if(distanciaAux < t.getDistancia()) return -1;
		if(distanciaAux > t.getDistancia()) return 1;
		return 0;
	}
	

}
