/*package Test;
import CheapDeal.Categorias;
import CheapDeal.Oferta;
import CheapDeal.Opinion;
import CheapDeal.Tienda;
import static org.junit.Assert.*;
import java.util.*;

import org.junit.*;

public class TiendaTest {
	private Tienta t1;
	private static int id=1;
	private int id_tienda;
	private String nombre;
	private String direccion;
	private String duenio;
	private HashSet<Oferta> ofertas;
	private String[][] horario = new String[2][7]; // Primera fila maniana, segunda fila tarde
	private HashSet<Opinion> opiniones;
	
	@Rule
	//public ExpectedException esperado = ExpectedException.none();
	
	@Before
	public void setUp() {
		t1 = new Tienda("TuKolchon","Calle123","Ninja");
	}
	
	@After
	public void tearDown() {
		t1 = null;
	}
	
	@Test
	public void testTienda() {
		assertEquals("Nombre: TuKolchon",String.valueOf("TuKolchon"),t1.getNombre());
		assertEquals("Direccion: Calle123",String.valueOf("Calle123"),t1.getDireccion());
		assertEquals("Duenio: Ninja",String.valueOf("Ninja"),t1.getDuenio());
	}
	

	@Test
	public void testAnadirOferta() {
		Map<Integer,Oferta> y;
		HashSet<Categorias> cat = new HashSet<Categorias>();
		cat.add(Categorias.ELECTRODOMESTICOS);
		
		t1.anadirOferta"Termo mix", 40.00, 2999.00,"Maquina de cocinar del siglo 22 increiblemente util", cat);
		cat.removeAll(cat);
		y = t1.getOfertas();
		assertNotNull("Oferta: Texmo mix es nula",y);
	}

	@Test
	public void testQuitarOferta() {
		Map<Integer,Oferta> x;
		HashSet<Categorias> cat = new HashSet<Categorias>();
		cat.add(Categorias.ELECTRODOMESTICOS);
		
		t1.anadirOferta("Termo mix", 40.00, 2999.00, "Maquina de cocinar del siglo 22 increiblemente util", cat);
		//t1.quitarOferta("Termo mix", 40.00, 2999.00, "Maquina de cocinar del siglo 22 increiblemete util", cat);
		cat.removeAll(cat);
		x = t1.getOfertas();
		assertNull("Oferta: Termo mix, no es nula", x);
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
*/