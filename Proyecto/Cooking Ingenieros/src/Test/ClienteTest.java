package Test;

import static org.junit.Assert.*;
import org.junit.*;

import CheapDeal.Cliente;

public class ClienteTest {
	Cliente c;
	
	@Before
	public void setUp(){
		c = new Cliente("usuariox","user4576","usuario@ci.com");
	}
	
	@After
	public void tearDown(){
		c = null;
	}	

	@Test
	public void testExisteCliente() {
		assertNotNull("no existe el cliente", c);
		assertEquals("el usuario esta mal", "usuariox",c.getUsuario());
		assertEquals("la contrase�a esta mal", "user4576", c.getContrasenia());
		assertEquals("el correo esta mal", "usuario@ci.com",c.getEmail());
		assertTrue("la reputacion deberia ser 0.0", 0.0==c.getReputacion() );
	}
}
