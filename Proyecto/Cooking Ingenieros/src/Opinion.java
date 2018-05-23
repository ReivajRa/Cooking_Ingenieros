
public class Opinion {
	public static int id=1;
	String mensaje;
	String usuario;
	int puntuacion;
	int id_opinion;
	
	public Opinion(String usu, String msj,int punt, int id_tienda){
		id_opinion = id;
		usuario = usu;
		mensaje = msj;
		puntuacion = punt;
		id++;
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
	
	
}
