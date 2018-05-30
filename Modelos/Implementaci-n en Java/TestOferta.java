<<<<<<< HEAD
<<<<<<< HEAD
package prCheapDeal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOferta { 
	Oferta o;
	
	@Before
	public void setUp()
	{
	  o = new Oferta("Margarina",10.0,"DelCampo",2.5,"LaFoto","Margarina casera vegetal en oferta","Comestibles");
	}

	@Test
	public void testOferta() {
	
		assertEquals("Deberia ser margarina",String.valueOf("Margarina"),o.getProducto());
		assertTrue("El descuento deberia ser del 10%",10.0==o.getDescuento());
		assertEquals("Deberia de salir DelCampo",String.valueOf("DelCampo"),o.getTienda());
		assertTrue("El precio deberia ser de 2.5",2.5==o.getPrecio());
		assertEquals("Deberia de salir LaFoto en su formato correcto",String.valueOf("LaFoto"),o.getFoto());
		assertEquals("Deberia de salir la descripcion de la margarina",String.valueOf("Margarina casera vegetal en oferta"),o.getDescripcion());
		assertEquals("Deberia de salir la categoria Comestibles",String.valueOf("Comestibles"),o.getCategoria());
	}

	@Test
	public void testModificarProducto() {
	
		
	}

	@Test
	public void testModificarDescuento() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarFoto() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarDescripcion() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarCategoria() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerOferta() {
		fail("Not yet implemented");
	}

}
=======
package prCheapDeal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOferta { 
	Oferta o;
	
	@Before
	public void setUp()
	{
	  o = new Oferta("Margarina",10.0,"DelCampo",2.5,"LaFoto","Margarina casera vegetal en oferta","Comestibles");
	}

	@Test
	public void testOferta() {
	
		assertEquals("Deberia ser margarina",String.valueOf("Margarina"),o.getProducto());
		assertTrue("El descuento deberia ser del 10%",10.0==o.getDescuento());
		assertEquals("Deberia de salir DelCampo",String.valueOf("DelCampo"),o.getTienda());
		assertTrue("El precio deberia ser de 2.5",2.5==o.getPrecio());
		assertEquals("Deberia de salir LaFoto en su formato correcto",String.valueOf("LaFoto"),o.getFoto());
		assertEquals("Deberia de salir la descripcion de la margarina",String.valueOf("Margarina casera vegetal en oferta"),o.getDescripcion());
		assertEquals("Deberia de salir la categoria Comestibles",String.valueOf("Comestibles"),o.getCategoria());
	}

	@Test
	public void testModificarProducto() {
	
		
	}

	@Test
	public void testModificarDescuento() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarFoto() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarDescripcion() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarCategoria() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerOferta() {
		fail("Not yet implemented");
	}

}
>>>>>>> 1f8796410979ee2bf6b26700798ea0cddeee52bc
=======
package prCheapDeal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOferta { 
	Oferta o;
	
	@Before
	public void setUp()
	{
	  o = new Oferta("Margarina",10.0,"DelCampo",2.5,"LaFoto","Margarina casera vegetal en oferta","Comestibles");
	}

	@Test
	public void testOferta() {
	
		assertEquals("Deberia ser margarina",String.valueOf("Margarina"),o.getProducto());
		assertTrue("El descuento deberia ser del 10%",10.0==o.getDescuento());
		assertEquals("Deberia de salir DelCampo",String.valueOf("DelCampo"),o.getTienda());
		assertTrue("El precio deberia ser de 2.5",2.5==o.getPrecio());
		assertEquals("Deberia de salir LaFoto en su formato correcto",String.valueOf("LaFoto"),o.getFoto());
		assertEquals("Deberia de salir la descripcion de la margarina",String.valueOf("Margarina casera vegetal en oferta"),o.getDescripcion());
		assertEquals("Deberia de salir la categoria Comestibles",String.valueOf("Comestibles"),o.getCategoria());
	}

	@Test
	public void testModificarProducto() {
	
		
	}

	@Test
	public void testModificarDescuento() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarFoto() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarDescripcion() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarCategoria() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerOferta() {
		fail("Not yet implemented");
	}

}
>>>>>>> 57d7e0d08c8678693b1594c9dbde99b319ff1c1e
