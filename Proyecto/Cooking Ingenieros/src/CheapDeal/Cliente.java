package CheapDeal;


import java.util.*;


public class Cliente {
	
	private int id;
	private String usuario;
	private String contrasenia;
	private String email;
	private double reputacion;
	private static int aux = 1;
	private HashSet<Cliente> seguidores;
	private HashSet<Cliente> seguidos;
	private double posX, posY;
	private HashSet<Opinion> opiniones;

	public Cliente(String u, String c, String e)
	{
		id = aux;
		this.usuario = u.toUpperCase();
		this.contrasenia = c;
		this.email = e.toLowerCase();
		this.reputacion = 0.0;
		seguidores = new HashSet<Cliente>();
		seguidos = new HashSet<Cliente>();
		opiniones = new HashSet<Opinion>();
		aux++;
	}
	public int getId() {
		return id;
	}
	public String getUsuario()
	{
		return this.usuario;
	}
	public String getContrasenia()
	{
		return this.contrasenia;
	}
	public HashSet<Opinion> getOpiniones() {
		return opiniones;
	}
	public String getEmail()
	{
		return this.email;
	}
	public double getReputacion()
	{
		return this.reputacion;
	}
	public HashSet<Cliente> getSeguidores()
	{
		return this.seguidores;
	}
	public HashSet<Cliente> getSeguidos()
	{
		return this.seguidos;
	}
	public double getPosX() {
		return posX;
	}
	
	public double getPosY() {
		return posY;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setReputacion(double reputacion) {
		this.reputacion = reputacion;
	}
	public void seguirUsuario(Cliente cl)
	{
		cl.seguidores.add(this);
		this.seguidos.add(cl);
	}
	public void dejarSeguir(Cliente cl)
	{
		cl.seguidores.remove(this);
		this.seguidos.remove(cl);
	}
	public String verSeguidores() {
		StringBuilder aux= new StringBuilder();
		for(Cliente o: seguidores) {
			aux.append("Nombre: " + o.usuario + ",");
		}
		return aux.toString();
	}
	
	public String verSeguidos() {
		StringBuilder aux = new StringBuilder();
		for(Cliente o: seguidores) {
			aux.append("Nombre: " + o.usuario + ",");
		}
		return aux.toString();
	}
	
	public void anadirOp(Opinion op) {
		opiniones.add(op);
	}
	
	public void eliminarOp(Opinion op) {
		opiniones.remove(op);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Cliente other = (Cliente) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", usuario=" + usuario + ", email=" + email + ", reputacion=" + reputacion + ", seguidores="
				+ seguidores.size() + ", seguidos=" + seguidos.size() + "]";
	}
	
	public void actualizarUbicacion() {
		if(id%2==0) {
			posY = -80.0;
			posX = 25.0;
		} else {
			posY = 52.0;
			posX = -38.62;
		}
	}
}
/*
 *  Cliente cliente9 = new Cliente("Alberto","fst_alberto","juanito@gmail.com");
 	Cliente cliente10 = new Cliente("Javi","fst_javi","pepeguapo@gmail.com");
 	Cliente cliente11 = new Cliente("Bonifacio","casaazul","juanito@gmail.com");
	Cliente cliente12 = new Cliente("Ctangana","billetes","pepeguapo@gmail.com");
	Tienda tienda7 = new Tienda("Pepapig", "Calle matadero 13", "Chicote", 49.1235, 32.00);
	Tienda tienda8 = new Tienda("Kiosko paco","Pesaito frito N 42", "Lucia Buenavista", 80.233, 10.00);
	clientes[7] = cliente9;
	clientes[8] = cliente10;
	clientes[9] = cliente11;
	clientes[10] = cliente12;
	tiendas.put(tienda7.getId_tienda(), tienda7);
	tiendas.put(tienda8.getId_tienda(), tienda8);
	
	cat.add(Categorias.CHARCUTERIA);
	aux = tienda7.anadirOferta("Bacon fresco", 8.99, 15.99, "El mejor bacon de todo Villanueva", cat);
	tienda7.getOfertas().get(aux).aniadirOp(cliente12, "Buenisimo para el bocadillo bacon queso 10/10 ", 10);
	cat.removeAll(cat);
	
	cat.add(Categorias.APERITIVOS);
	aux = tienda8.anadirOferta("Fresas", 2.50,5.00 , "Fresas con nata con chocolate y barquillos de nutella", cat);
	tienda8.getOfertas().get(aux).aniadirOp(cliente7, "Estan buenisimas, aunque un poco empalagosas", 6);
	cat.removeAll(cat);
	
	cat.add(Categorias.CHARCUTERIA);
    aux = tienda8.anadirOferta("Jamon Serrano", 79.00, 119.00, "Jamon serrano iberico de pata negra del Villanueva", cat);
    tienda8.getOfertas().get(aux).aniadirOp(cliente11, "Se funde en la boca", 9);
	cat.removeAll(cat);
	
	cat.add(Categorias.DULCE);
	    aux = tienda8.anadirOferta("Golosinas", 0.50, 120.00, "Golosinas de queso del himalaya", cat);
	    cat.removeAll(cat);
	
	cat.add(Categorias.ROPA);
	aux = tienda2.anadirOferta("Traje ", 119.00, 149.00, "Traje de punto gorgio armani de increible calite", cat);
	tienda2.getOfertas().get(aux).aniadirOp(cliente12, "Un traje muy bueno para irse de fiesta y perder la tarjeta de credito", 7);
	cat.removeAll(cat);
		
		*/
