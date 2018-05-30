package CheapDeal;
import java.util.*;

public class Empresa {
	private String usuario, contrasenia;
	private HashSet<Tienda> tienda;
	private String eMail;
	
	public Empresa(String usu, String contr, String mail) {
		usuario = usu;
		contrasenia = contr;
		eMail = mail;
		tienda = new HashSet<>();
	}
	
	public String getUsuario() {
		return usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public String geteMail() {
		return eMail;
	}

	public HashSet<Tienda> getTienda() {
		return tienda;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void addTienda(Tienda tnd) {
		tienda.add(tnd);
	}

	public String verTienda() {
		String aux = null ;
		for(Tienda o: tienda) {
			aux += "Nombre: "+ o.getNombre() + ", ID: " + o.getId_tienda() + ". ";
		}
		return aux;
	}

	public String toString() {
		return "Empresa [usuario=" + usuario + ", tiendas=" + verTienda() + ", eMail=" + eMail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
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
		Empresa other = (Empresa) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
