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
			for (int i = 0; i < elJuego.getNumDragones(); i++) {
				if (elJuego.buscarDragonCodigo(i)!=null) {
					elJuego.buscarDragonCodigo(i).mover();
//					System.out.println(i);
				}				
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
		}
		
	}
	

}
