
import java.util.*;

public class Coleccion_ofertas {
	
	protected List<Oferta> ofertas;
	
	public Coleccion_ofertas()
	{
		ofertas = new ArrayList<Oferta>();
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
	public void aniadirOferta(Oferta o)
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
	public int size() {
		return ofertas.size();
	}
	public String get(int x) {
		return ofertas.get(x).verOferta();
	}

}
