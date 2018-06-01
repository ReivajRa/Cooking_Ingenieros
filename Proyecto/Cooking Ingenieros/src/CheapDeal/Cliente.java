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

	public Cliente(String u, String c, String e)
	{
		id = aux;
		this.usuario = u.toUpperCase();
		this.contrasenia = c;
		this.email = e.toLowerCase();
		this.reputacion = 0.0;
		seguidores = new HashSet<Cliente>();
		seguidos = new HashSet<Cliente>();
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
		return "Cliente [id=" + id + "usuario=" + usuario + ", email=" + email + ", reputacion=" + reputacion + ", seguidores="
				+ seguidores.size() + ", seguidos=" + seguidos.size() + "]";
	}
}
