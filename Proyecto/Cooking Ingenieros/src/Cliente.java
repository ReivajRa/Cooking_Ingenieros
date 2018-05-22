

import java.util.*;


public class Cliente {
	
	private String usuario;
	private String contrase�a;
	private String email;
	private double reputacion;
	private List<String> seguidores;
	private List<String> seguidos;

	public Cliente(String u, String c, String e)
	{
		this.usuario = u;
		this.contrase�a = c;
		this.email = e;
		this.reputacion = 0.0;
		seguidores = new LinkedList<String>();
		seguidos = new LinkedList<String>();
	}
	public String getUsuario()
	{
		return this.usuario;
	}
	public String getContrase�a()
	{
		return this.contrase�a;
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
		System.out.println("Nombre de usuario: "+this.usuario+"; E-mail de contacto: "+this.email+"; Reputaci�n: "+this.reputacion
				+"; Seguidores: "+this.seguidores.size()+"; Seguidos: "+this.seguidos.size()+" .");
	}
	public void compartirOferta()
	{
		// pendiente de hacer, primero debe crearse la clase Oferta.

	}
	public void DejarSeguirUsuario(Cliente cl)
	{
		
		this.seguidos.remove(cl.usuario);
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String verOferta(Oferta of) {
		return of.verOferta();
	}
	
	
	//VER OFERTA??
	
}
