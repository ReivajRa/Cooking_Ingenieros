

import java.util.*;


public class Cliente {
	
	private String usuario;
	private String contrasenia;
	private String email;
	private double reputacion;
	private List<String> seguidores;
	private List<String> seguidos;

	public Cliente(String u, String c, String e)
	{
		this.usuario = u;
		this.contrasenia = c;
		this.email = e;
		this.reputacion = 0.0;
		seguidores = new LinkedList<String>();
		seguidos = new LinkedList<String>();
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
	public List<String> getSeguidores()
	{
		return this.seguidores;
	}
	public List<String> getSeguidos()
	{
		return this.seguidos;
	}
	public void seguirUsuario(Cliente cl)
	{
		cl.seguidores.add(this.usuario);
		this.seguidos.add(cl.usuario);
	}
	
	public void verPerfil()
	{
		System.out.println("Nombre de usuario: "+this.usuario+"; E-mail de contacto: "+this.email+"; Reputación: "+this.reputacion
				+"; Seguidores: "+this.seguidores.size()+"; Seguidos: "+this.seguidos.size()+" .");
	}
	
	public void DejarSeguirUsuario(Cliente cl)
	{
		
		this.seguidos.remove(cl.usuario);
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setContraseña(String contraseña) {
		this.contrasenia = contraseña;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String verOferta(Oferta of) {
		return of.verOferta();
	}
	
	
}
