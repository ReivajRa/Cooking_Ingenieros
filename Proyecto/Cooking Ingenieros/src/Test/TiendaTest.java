package Test;
import CheapDeal.Categorias;
import CheapDeal.Oferta;
import CheapDeal.Opinion;
import CheapDeal.Tienda;
import static org.junit.Assert.*;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TiendaTest {
	private static int id=1;
	private int id_tienda;
	private String nombre;
	private String direccion;
	private String duenio;
	private HashSet<Oferta> ofertas;
	private String[][] horario = new String[2][7]; // Primera fila maniana, segunda fila tarde
	private HashSet<Opinion> opiniones;
	
	@Rule
	public ExpectedException esperado = ExpectedException.none();
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testTienda() {
		Tienda t1 = new Tienda("TuKolchon", "Calle123", "Ninja");
		assertEquals("Nombre: TuKolchon",String.valueOf("TuKolchon"),t1.getNombre());
		assertEquals("Direccion: Calle123",String.valueOf("Calle123"),t1.getDireccion());
		assertEquals("Duenio: Ninja",String.valueOf("Ninja"),t1.getDuenio());
	}
	

	@Test
	public void testAnadirOferta() {
		//String p, double d, Tienda t, double pr, String des, HashSet<Categorias> cat
		//cat.add(Categorias.ELECTRODOMESTICOS);
		//Oferta of = new Oferta("Termo mix", 40.00, 2999.00, 
		//		"Maquina de cocinar del siglo 22 increiblemente util, Doraemon approves", cat);
		//cat.remove();
		//ofertas.add(of);
		//assertNotNull();
	}

	@Test
	public void testQuitarOferta() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerOfertas() {
		fail("Not yet implemented");
	}

	@Test
	public void testMostrarOpiniones() {
		fail("Not yet implemented");
	}

	@Test
	public void testAniadirOp() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarOp() {
		fail("Not yet implemented");
	}

}
