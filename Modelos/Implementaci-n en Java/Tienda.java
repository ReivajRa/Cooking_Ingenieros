
public class Tienda {
	private int id_tienda;
	private String direccion;
	private String dueño;
	private Coleccion_oferta ofertas;
	private String[][] horario = new String[2][7]; // Primera fila mañana, segunda fila tyarde
	private Coleccion_opinion opiniones;
	
	public Tienda(int id, String dir, String due){
		id_tienda = id;
		direccion = dir;
		dueño = due;
	}
	
	public void añadirOferta(int id, String producto, int desc, int precio, String descrip, 

}
