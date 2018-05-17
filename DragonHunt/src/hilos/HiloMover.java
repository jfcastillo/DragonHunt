package hilos;

import interfaz.VentanaPrincipal;

public class HiloMover extends Thread {
	
	private VentanaPrincipal vPrincipal;

	public HiloMover(VentanaPrincipal vPrincipal) {		
		this.vPrincipal = vPrincipal;
	}
	
	@Override
	public void run() {
		boolean salir = false;
		while (!salir) {
			vPrincipal.getvJuego().repaint();
			
			
		}
	}
	

}
