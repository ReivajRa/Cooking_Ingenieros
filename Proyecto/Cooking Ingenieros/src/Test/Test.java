package Test;

import CheapDeal.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;



public class Test {
	
	Map<Integer, Opinion> opiniones;
	Opinion opinion1;
	Opinion opinion2;
	Map<Integer, Oferta> ofertas;
	Oferta oferta1;
	Oferta oferta2;
	Map<Integer, Tienda> tiendas;
	Tienda tienda1;
	Tienda tienda2;
	HashSet<Categorias> cat = new HashSet<Categorias>();
	
	
	@Before 
	
	public void setUp(){
	  opinion2 = new Opinion("Usuario2", "Me ha encantado",2.5, oferta1, tienda1);
	  opiniones = new TreeMap<Integer, Opinion>();
	  opiniones.put((int) opinion2.getPuntuacion(), opinion2);
	  cat.add(Categorias.CONSERVAS);
	  oferta1 = new Oferta("Margarina",10.0,tienda1,2.5,"Margarina casera vegetal en oferta", cat);//null esta mal 
	  cat.removeAll(cat);
	  oferta1.setOpiniones(opiniones);
	  ofertas = new TreeMap<Integer, Oferta>();
	  ofertas.put(oferta1.getId_oferta(), oferta1);
	  tiendas = new TreeMap<Integer, Tienda>();
	  tienda1 = new Tienda("DelCampo","Avenida plutarco","Paco");
	  tienda1.setOfertas(ofertas);
	  tiendas.put(tienda1.getId_tienda(), tienda1);
	}
	

	@After
	public void tearDown() {
		
		tienda1 = null;
		oferta1 = null;
		opiniones = null;
		opinion1= null;
		opinion2=null;
		
	}

	
	
	@org.junit.Test
	public void testDespuesdeAniadirUnaOpEstaEnLaColeccion()
	{
		int punt=1;
		opinion1 = new Opinion("Usuario1", "Es una farsa",punt, oferta1, tienda1);
		oferta1.aniadirOp("Usuario1", "Es una farsa",punt);
		opiniones = oferta1.getOpiniones();
		opinion1 = opiniones.get((int)opinion1.getPuntuacion());
		
		assertNotNull("Deberia de existir la opinion",opinion1);
		assertEquals("Deberia ser el usuario del parametro",String.valueOf("Usuario1"),opinion1.getUsuario());
		assertEquals("Deberia ser el mensaje del parametro",String.valueOf("Es una farsa"),opinion1.getMensaje());
		assertTrue("Deberia ser la puntuacion del parametro",punt==opinion1.getPuntuacion());
	}

	
	
	@org.junit.Test
	public void testDespuesdeAniadirUnaOfEstaEnLaColeccion()
	{
		double des = 15.0;
		double pr = 1.8;
		oferta2 = new Oferta("Pepinos",des,tienda1,pr,"Pepinos de huerta ecologicos", cat);
		tienda1.anadirOferta("Pepinos",des,pr,"Pepinos de huerta ecologicos", cat);
		ofertas = tienda1.getOfertas();
		oferta2 = ofertas.get(oferta2.getId_oferta());
		
		assertNotNull("Deberia de existir la oferta",oferta2);
		assertEquals("Deberia ser el producto del parametro",String.valueOf("Pepinos"),oferta2.getProducto());
		assertTrue("Deberia ser el descuento del parametro",des==oferta2.getDescuento());
		assertTrue("Deberia ser la precio del parametro",pr==oferta2.getPrecio());
		assertEquals("Deberia ser la descripcion del parametro",String.valueOf("Pepinos de huerta ecologicos"),oferta2.getDescripcion());
		
		
	}
	
	
	@org.junit.Test
	public void testDespuesdeAniadirUnaTiendaEstaEnLaColeccion()
	{
		int punt=1;
		opinion1 = new Opinion("Usuario1", "Es una farsa",punt, oferta1, tienda1);
		oferta1.aniadirOp("Usuario1", "Es una farsa",punt);
		opiniones = oferta1.getOpiniones();
		
		assertNotNull("Deberia de existir la opinion",opinion1);
		assertEquals("Deberia ser el usuario del parametro",String.valueOf("Usuario1"),opinion1.getUsuario());
		assertEquals("Deberia ser el mensaje del parametro",String.valueOf("Es una farsa"),opinion1.getMensaje());
		assertTrue("Deberia ser la puntuacion del parametro",punt==opinion1.getPuntuacion());
	}
	
	
	
	
	
	
	
}
