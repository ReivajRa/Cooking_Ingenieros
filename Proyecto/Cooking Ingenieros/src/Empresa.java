import java.util.LinkedList;

public class Empresa {
	private String usuario, contrasenia;
	LinkedList<Tienda> tienda;
	private String eMail;
	
	public Empresa(String usu, String contr, String mail) {
		usuario = usu;
		contrasenia = contr;
		eMail = mail;
		tienda = new LinkedList<>();
	}
	
	public void addTienda(Tienda tnd) {
		tienda.add(tnd);
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

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

}
