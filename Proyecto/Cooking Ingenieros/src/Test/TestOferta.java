/*package Test;

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
*/