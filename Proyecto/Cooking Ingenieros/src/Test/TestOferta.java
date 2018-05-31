package Test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import CheapDeal.*;

public class TestOferta { 
	Oferta o;
	Tienda t;
	Map<Integer, Opinion> opiniones;
	Opinion opinion1;
	Opinion opinion2;

	
	@Before
	public void setUp()
	{
	  t	=new Tienda("DelCampo","Avenida plutarco","Paco");
	  o = new Oferta("Margarina",10.0,t,2.5,"Margarina casera vegetal en oferta",null);
	}

	@Test
	public void testDespuesDeCrearUnaOfertaEstaExisteDeFormaCorrecta() {
	
		assertEquals("Deberia ser margarina",String.valueOf("Margarina"),o.getProducto());
		assertTrue("El descuento deberia ser del 10%",10.0==o.getDescuento());
		assertEquals("Deberia de salir DelCampo",String.valueOf("DelCampo"),t.getNombre());
		assertEquals("Deberia de salir Avenida Plutarco",String.valueOf("Avenida plutarco"),t.getDireccion());
		assertEquals("Deberia de salir Paco",String.valueOf("Paco"),t.getDuenio());
		assertTrue("El precio deberia ser de 2.5",2.5==o.getPrecio());
		assertEquals("Deberia de salir la descripcion de la margarina",String.valueOf("Margarina casera vegetal en oferta"),o.getDescripcion());
	}
	@Test
	public void testDespuesdeAniadirUnaOpEstaEnLaColeccion()
	{
		int punt=2;
		o.aniadirOp("Usuario1","Es una farsa", punt);
		opiniones = o.getOpiniones();
		opinion1 = opiniones.get("Usuario1");
		
		
		
		assertNotNull("Deberia de existir la opinion",opinion1);
		assertEquals("Deberia ser el usuario del parametro",String.valueOf("Usuario1"),opinion1.getUsuario());
		assertEquals("Deberia ser el mensaje del parametro",String.valueOf("Es una farsa"),opinion1.getMensaje());
		assertTrue("Deberia ser la puntuacion del parametro",punt==opinion1.getPuntuacion());
	}

}