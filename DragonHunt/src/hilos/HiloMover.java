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
			for (int i = 1; i <= vPrincipal.darJuego().getNumDragones(); i++) {
				
				vPrincipal.darJuego().buscarDragonCodigo(i).mover();
				
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

}
