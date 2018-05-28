package hilos;

import interfaz.VentanaPrincipal;
import modelo.JuegoDragon;

public class HiloJuego extends Thread{
	private VentanaPrincipal vPrincipal;
	private JuegoDragon elJuego;
	public HiloJuego(VentanaPrincipal vPrincipal, JuegoDragon elJuego) {
		super();
		this.vPrincipal = vPrincipal;
		this.elJuego = elJuego;
	}
	@Override
	public void run() {
		boolean salir = false;
		while (!salir) {
			//No eliminar este syso, sino, se daña.
			System.out.println("h");
			if (elJuego.getPrimerDragon().isSeFue()) {
				
				try {
					Thread.sleep(2000);
					elJuego.getPrimerDragon().setSeFue(false);					
					elJuego.eliminarDragon(elJuego.getPrimerDragon());
					elJuego.getJugadorActual().reiniciarMunicion();
					elJuego.crearDragon();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	}

}
