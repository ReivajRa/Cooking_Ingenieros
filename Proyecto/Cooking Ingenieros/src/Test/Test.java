package Test;

import CheapDeal.*;



import org.mockito.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import org.hamcrest.*;
import org.hamcrest.collection.IsMapContaining;


public class Test {
	
	Cliente usuario;
	Opinion opinion;
	Map<Integer,Opinion> opiniones;
	Oferta oferta;
	Map<Integer,Oferta> ofertas;
	Tienda tienda;
	Map<Integer,Tienda> tiendas;
	HashSet<Categorias> cat = new HashSet<Categorias>();
	
	
	@Before 
	
	public void setUp(){
		usuario = new Cliente("Paco","1234","paco@mail");
		//opinion = new Opinion(usuario, "Es una farsa",1.0, oferta, tienda);
		opiniones = new TreeMap<>();
		cat.add(Categorias.VERDURAS_HORTALIZAS);
		oferta = new Oferta("Patatas", 15.0, tienda, 5.0, "Kilos de patatas ",cat);
		cat.removeAll(cat);
		ofertas = new TreeMap<>();
		tienda = new Tienda("Verduras Petra", "Av velazquez", "Petra");
		tiendas = new TreeMap<>();
		
	  
	}
	

	@After
	public void tearDown() {
		
		usuario = null;
		opinion = null;
		opiniones=null;
		cat=null;
		oferta=null;
		tienda=null;
		tiendas=null;
		
	}

	
	
	@org.junit.Test
	public void testDespuesdeAniadirUnaOpEstaEnLaColeccion()
	{
		int id;
		id = oferta.aniadirOp(usuario, "Es una farsa", 1);
		
		assertNotNull("Deberia existir la opinion",oferta.getOpiniones().get(id));
		
	}

	
	
	@org.junit.Test
	public void testDespuesdeAniadirUnaOfEstaEnLaColeccion()
	{
		int id;
		cat.add(Categorias.VERDURAS_HORTALIZAS);
		id = tienda.anadirOferta("Patatas", 15.0, 5.0, "Kilos de patatas ",cat);
		cat.removeAll(cat);
		
		assertNotNull("Deberia existir la oferta",tienda.getOfertas().get(id));
		//Falta modificar el return de anadirOferta de la misma manera que aniadirOp de la clase Oferta.
			
	}
	@org.junit.Test
	public void testDespuesDeEliminarUnaOpNoEstaEnLaColeccion()
	{
		int id;
		id = oferta.aniadirOp(usuario, "Es una farsa", 1);
		oferta.eliminarOp(id);
		
		assertNull("No deberia de existir la opinion",oferta.getOpiniones().get(id));
	}
	@org.junit.Test
	public void testDespuesDeEliminarUnaOfNoEstaEnLaColeccion()
	{
		int id;
		cat.add(Categorias.VERDURAS_HORTALIZAS);
		id = tienda.anadirOferta("Patatas", 15.0, 5.0, "Kilos de patatas ",cat);
		cat.removeAll(cat);
		tienda.quitarOferta(id);
		
		assertNull("No deberia de existir la oferta",tienda.getOfertas().get(id));
	}
	
	
	
	
	
	
	
	
	
	
}
