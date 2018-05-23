package prCheapDeal;

import java.util.Scanner;

public class Oferta {
	
	private int id_oferta;
	private String producto;
	private double descuento;
	private String tienda;
	private double precio;
	private String foto;
	private String descripcion;
	private int codigoQR;
	private String categoria;
	
	public Oferta(String p, double d, String t, double pr, String f, String des, String cat)
	{
		this.id_oferta= (int)Math.random();
		this.producto = p;
		this.descuento = d;
		this.tienda = t;
		this.precio = pr;
		this.foto = f;
		this.descripcion = des;
		this.codigoQR= (int)Math.random();
		this.categoria = cat;
	}

	public int getId_oferta() {
		return this.id_oferta;
	}

	public String getProducto() {
		return this.producto;
	}

	public void modificarProducto()
	{
		try(Scanner sc = new Scanner(System.in))
		{
			while(sc.hasNext())
			{
				this.producto =  sc.next();
				
			}
			
		}
		
	}

	public double getDescuento() {
		return this.descuento;
	}

	public void modificarDescuento() {
		try(Scanner sc = new Scanner(System.in))
		{
			while(sc.hasNext())
			{
				this.descuento =  sc.nextInt();
				
			}
			
		}
	}

	public String getTienda() {
		return this.tienda;
	}

	public double getPrecio() {
		return this.precio;
	}

	public String getFoto() {
		return this.foto;
	}

	public void modificarFoto()
	{
		try(Scanner sc = new Scanner(System.in))
		{
			while(sc.hasNext())
			{
				this.foto = sc.next();
				
			}
			
		}
		
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void modificarDescripcion()
	{
		try(Scanner sc = new Scanner(System.in))
		{
			while(sc.hasNext())
			{
				this.descripcion = sc.next();
				
			}
			
		}
		
	}

	public int obtenerCodigoQR() {
		return this.codigoQR;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void modificarCategoria()
	{
		try(Scanner sc = new Scanner(System.in))
		{
			while(sc.hasNext())
			{
				this.categoria = sc.next();
				
			}
			
		}	
		
	}
	public boolean equals(Object o)
	{
		boolean res = o instanceof Oferta;
		Oferta of = res ? (Oferta)o: null;
		return res && this.id_oferta==of.id_oferta;
		
	}
	public int hashCode()
	{
		return this.id_oferta;
	}
	
	public String verOferta()
	{
		System.out.println("Id: "+this.getId_oferta()+"; Producto: "+this.getProducto()
		+"; Descuento: "+this.getDescuento()+"; Tienda: "+this.getTienda()
		+"; Precio: "+this.getPrecio()+"; Foto: "+this.getFoto()+"; Descripcion: "
		+this.getDescripcion()+"; CodigoQR: "+this.obtenerCodigoQR()+"; Categoria: "
		+this.getCategoria());
		return "";
	}

}
