package modelo;

import org.junit.Test;

import junit.framework.TestCase;

public class JuegoTest extends TestCase {

	private JuegoDragon elJuego;
	
	public void escenario1() {
		elJuego = new JuegoDragon();		
	}
	
	@Test
	public void testAgregarJugador() {
		escenario1();
		elJuego.agregarJugador("Mayumi", 21);
		elJuego.agregarJugador("Felipe", 19);
		Jugador expected = new Jugador("Mayumi", 21);
		assertEquals("Felipe", elJuego.getJugadorRaiz().getIzq().getNombre());
	}
	
}
