import java.util.LinkedList;

public class Tienda {
	private int id_tienda;
	private String direccion;
	private String duenio;
	private Coleccion_ofertas ofertas;
	private String[][] horario = new String[2][7]; // Primera fila maniana, segunda fila tarde
	private LinkedList<Opinion> opiniones;
	

	public Tienda(int id, String dir, String due){
		id_tienda = id;
		direccion = dir;
		duenio = due;
		ofertas = new Coleccion_ofertas();
		opiniones = new LinkedList<Opinion>();
	}
	
	public void anadirOferta(String producto, double desc, double precio, String descrip, Coleccion_categoria categ) {
		Oferta of= new Oferta(producto, desc, id_tienda, precio, descrip, categ);
		ofertas.aniadirOferta(of);
	}
	
	public void quitarOferta(Oferta of){
		ofertas.quitarOferta(of);
	}
	
	public void mostrarOfertas(){
		int aux = ofertas.size();
		for(int i=0; i<aux; i++) {
			System.out.println(ofertas.get(i));
		}
	}

	public int getId_tienda() {
		return id_tienda;
	}

	public String getDireccion() {
		return direccion;
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
			System.out.println("Id:" + aux.id + ". Tienda: " + aux.nombre + ". Escrito por: " + aux.usuario + ". Mensaje: "
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
