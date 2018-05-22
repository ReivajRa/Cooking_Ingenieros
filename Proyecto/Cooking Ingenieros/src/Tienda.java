import java.util.LinkedList;

public class Tienda {
	private int id_tienda;
	private String direccion;
	private String duenio;
	private Coleccion_ofertas ofertas;
	private String[][] horario = new String[2][7]; // Primera fila maÃ±ana, segunda fila tyarde
	//private Coleccion_opinion opiniones;
	
	public Tienda(int id, String dir, String due){
		id_tienda = id;
		direccion = dir;
		duenio = due;
		ofertas = new Coleccion_ofertas();
	}
	
	public void anadirOferta(String producto, double desc, double precio, String descrip, LinkedList<String> categ) {
		Oferta of= new Oferta(producto, desc, id_tienda, precio, descrip, categ);
		ofertas.añadirOferta(of);
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

	public void setId_tienda(int id_tienda) {
		this.id_tienda = id_tienda;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}

}
