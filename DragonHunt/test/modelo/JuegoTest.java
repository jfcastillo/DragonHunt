package modelo;

import org.junit.Test;

import junit.framework.TestCase;

public class JuegoTest extends TestCase {

	private JuegoDragon elJuego;
	
	public void escenario1() {
		elJuego = new JuegoDragon();		
	}
	public void escenario2() {
//		elJuego.agregarDragon(drag);
	}
	
	@Test
	public void testAgregarJugador() {
		escenario1();
		elJuego.agregarJugador("Mayumi", 21);
		elJuego.agregarJugador("Felipe", 19);
		elJuego.agregarJugador("Castillo", 25);
		Jugador expected = new Jugador("Mayumi", 21);
		assertEquals("Felipe", elJuego.getJugadorRaiz().getIzq().getNombre());
		assertEquals("Mayumi", elJuego.getJugadorRaiz().getNombre());
		assertEquals("Castillo", elJuego.getJugadorRaiz().getDer().getNombre());
	}
	
}
