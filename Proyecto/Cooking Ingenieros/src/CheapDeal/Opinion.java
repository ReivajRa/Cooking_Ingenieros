package CheapDeal;

public class Opinion {
	public static int id=1;
	String mensaje;
	String usuario;
	int puntuacion;
	int id_opinion;
	Oferta oferta;
	
	public Opinion(String usu, String msj,int punt, Oferta of){
		id_opinion = id;
		usuario = usu;
		mensaje = msj;
		puntuacion = punt;
		oferta = of;
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
	
	public int getId_opinion() {
		return id_opinion;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Opinion [id_opinion=" + id_opinion + ", usuario=" + usuario + ", mensaje=" + mensaje + ", puntuacion="
				+ puntuacion + ", oferta=" + oferta.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oferta == null) ? 0 : oferta.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Opinion other = (Opinion) obj;
		if (oferta == null) {
			if (other.oferta != null)
				return false;
		} else if (!oferta.equals(other.oferta))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}
