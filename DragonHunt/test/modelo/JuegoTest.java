package modelo;

import org.junit.Test;

import junit.framework.TestCase;

public class JuegoTest extends TestCase {

	private Juego elJuego;
	
	public void escenario1() {
		elJuego = new Juego();		
	}
	
	@Test
	public void testAgregarJugador() {
		escenario1();
		elJuego.agregarJugador("Mayumi", 21);
		Jugador expected = new Jugador("Mayumi", 21);
		assertEquals(expected.getNombre(), elJuego.getRaiz().getNombre());
	}
	
}
