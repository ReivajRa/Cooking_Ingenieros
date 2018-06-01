/*package Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import CheapDeal.Categorias;
import CheapDeal.Cliente;
import CheapDeal.Tienda;
import CheapDeal.Opinion;
import CheapDeal.Oferta;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class OpinionTest {

	public static int id=1;
	private String mensaje;
	private String usuario;
	private int puntuacion=5;
	private int id_opinion;
	private Oferta oferta;
	private Tienda tienda;
	private Opinion opinion;
	
	
	@Rule
	
	public ExpectedException esperado = ExpectedException.none();
	
	@Before 
	
	public void setUp() throws Exception {
		//Oferta of = new Oferta();
		//Tienda tnd = new Tienda();
		opinion = new Opinion ("Muy Bueno", "Antonio", puntuacion, oferta, tienda);
	
	}
	
	@After
	
	public void tearDown() throws Exception {
		
		opinion = null;
	
	}
	

	@Test
	public void testOpinion() {
		int p;
		assertEquals("Mensaje erroneo", String.valueOf("Muy Bueno"),opinion.getMensaje());
		assertEquals("Nombre erroneo", String.valueOf("Antonio"),opinion.getMensaje());
		p=opinion.getpuntuacion();
		assertTrue("la puntuacion es erronea", p=puntuacion);
		
		
	}

	@Test
	public void testEqualsObject() {
		
		Opinion opinion2 = new Opinion("Muy Bueno", "Antonio", puntuacion, oferta, tienda);
		
		
		
		
	}
} 
*/
