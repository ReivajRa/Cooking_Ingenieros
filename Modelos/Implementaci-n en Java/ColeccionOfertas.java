package prCheapDeal;

import java.util.*;

public class ColeccionOfertas {
	
	protected List<Oferta> ofertas;
	
	public ColeccionOfertas()
	{
		ofertas = new ArrayList<>();
	}
	private boolean encuentraOferta(Oferta o)
	{
		boolean ok = false;
		Iterator<Oferta> it = ofertas.iterator();
		while(it.hasNext())
		{
			if(o==it.next())
			{
				ok=true;
			}
		}
		return ok;
	
	}
	public void añadirOferta(Oferta o)
	{
		if(encuentraOferta(o)==true)
		{
			System.out.println("Ya existe esta oferta.");
		}
		else
		{
			ofertas.add(o);
		}
		
	}
	public void quitarOferta(Oferta o)
	{
		if(encuentraOferta(o)==true)
		{
			ofertas.remove(o);
		}
		else
		{
			System.out.println("No existe esta oferta.");
		}
	}
	public void modificaOferta(Oferta o, String s)
	{
		if(encuentraOferta(o)==true)
		{
			if(s=="Categoria")
			{
				o.modificarCategoria();
			}
			if(s=="Descuento")
			{
				o.modificarDescuento();
			}
			if(s=="Producto")
			{
				o.modificarProducto();
			}
			if(s=="Foto")
			{
				o.modificarFoto();
			}
			if(s=="Descripcion")
			{
				o.modificarDescripcion();
			}
			ofertas.add(o);
		}
		else
		{
			throw new NoSuchElementException();
		}
	}

}
