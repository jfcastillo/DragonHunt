package hilos;

import interfaz.VentanaPrincipal;
import modelo.JuegoDragon;

public class HiloMover extends Thread {
	
	private VentanaPrincipal vPrincipal;
	private JuegoDragon elJuego;

	public HiloMover(VentanaPrincipal vPrincipal, JuegoDragon elJuego) {		
		this.vPrincipal = vPrincipal;
		this.elJuego = elJuego;
	}
	
	@Override
	public void run() {
		boolean salir = false;
		while (!salir) {
			for (int i = 1; i <= elJuego.getNumDragones(); i++) {
				if (elJuego.buscarDragonCodigo(i)!=null) {
					elJuego.buscarDragonCodigo(i).mover();
				}				
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
		}
		
	}
	

}
