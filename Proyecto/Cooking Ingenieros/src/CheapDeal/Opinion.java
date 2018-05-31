package CheapDeal;

public class Opinion {
	public static int id=1;
	private String mensaje;
	private Cliente usuario;
	private double puntuacion;
	private int id_opinion;
	private Oferta oferta;
	private Tienda tienda;
	
	public Opinion(Cliente usu, String msj,double punt, Oferta of, Tienda tnd){
		id_opinion = id;
		usuario = usu;
		mensaje = msj;
		puntuacion = punt;
		oferta = of;
		tienda = tnd;
		id++;
	}
	
	public int getId() {
		return id_opinion;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	public Cliente getUsuario() {
		return usuario;
	}

	public double getPuntuacion() {
		return puntuacion;
	}
	
	public int getId_opinion() {
		return id_opinion;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	@Override
	public String toString() {
		return "Opinion [id_opinion=" + id_opinion + ", usuario=" + usuario.getUsuario() + ", mensaje=" + mensaje + ", puntuacion="
				+ puntuacion + ", oferta=" + oferta.getProducto() + ", tienda=" + tienda.getNombre() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oferta == null) ? 0 : oferta.hashCode());
		result = prime * result + ((tienda == null) ? 0 : tienda.hashCode());
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
		if (tienda == null) {
			if (other.tienda != null)
				return false;
		} else if (!tienda.equals(other.tienda))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}	
}

	
