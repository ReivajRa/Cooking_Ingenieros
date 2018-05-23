
public class Opinion {
	int id;
	String mensaje;
	String usuario;
	int puntuacion;
	int id_tienda;
	int aux = 1;
	
	public Opinion(String usu, String msj,int punt, int id_tienda){
		id = aux;
		usuario = usu;
		mensaje = msj;
		puntuacion = punt;
		this.id_tienda = id_tienda;
		aux++;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	public int getId() {
		return id;
	}

	public int getId_tienda() {
		return id_tienda;
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
