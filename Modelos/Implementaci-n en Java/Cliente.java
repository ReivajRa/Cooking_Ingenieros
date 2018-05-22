package prCheapDeal;

import java.util.*;

import javax.naming.NamingException;

public class Cliente {
	
	private String usuario;
	private String contraseña;
	private String email;
	private double reputacion;
	private List<String> seguidores;
	private List<String> seguidos;

	public Cliente(String u, String c, String e)
	{
		this.usuario = u;
		this.contraseña = c;
		this.email = e;
		this.reputacion = 0.0;
		seguidores = new LinkedList<>();
		seguidos = new LinkedList<>();
	}
	public String getUsuario()
	{
		return this.usuario;
	}
	public String getContraseña()
	{
		return this.contraseña;
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
	public void verOferta()
	{
		// pendiente de hacer, primero debe crearse la clase Oferta.
	}
	public void compartirOferta()
	{
		// pendiente de hacer, primero debe crearse la clase Oferta.

	}
	public void cambiarEmail()
	{
		try(Scanner sc = new Scanner(System.in))
		{
			while(sc.hasNext())
			{
				this.email = sc.next();
				
			}
			
		}
		
	}
	public void cambiarContraseña()
	{
		try(Scanner sc = new Scanner(System.in))
		{
			while(sc.hasNext())
			{
				this.contraseña = sc.next();
				
			}
			
		}
		
	}
	public void DejarSeguirUsuario(Cliente cl)
	{
		
		this.seguidos.remove(cl.usuario);
	}
	
}
