
public class Opinion {
	public static int id=1;
	String mensaje;
	String usuario;
	int puntuacion;
<<<<<<< HEAD
	int id_tienda;
	int aux = 1;
	
	public Opinion(String usu, String msj,int punt, int id_tienda){
		id = aux;
		usuario = usu;
		mensaje = msj;
		puntuacion = punt;
		this.id_tienda = id_tienda;
		aux++;
=======
	int id_opinion;
	
	public Opinion(String usu, String msj,int punt, int id_tienda){
		id_opinion = id;
		usuario = usu;
		mensaje = msj;
		puntuacion = punt;
		id++;
>>>>>>> 87c5f0e3de0094b42a3b3df12a776d745093ebe2
	}

	public String getMensaje() {
		return mensaje;
	}
	
	public int getId() {
		return id_opinion;
	}

	public String getUsuario() {
		return usuario;
	}

	public int getPuntuacion() {
		return puntuacion;
	}
	
	public String mostrarOp() {
		return "Id:" + id + ". Escrito por: " + usuario + ". Mensaje: "
				+ 	mensaje + ". Puntuacion: " + puntuacion + ".";
	}
	
	
}
