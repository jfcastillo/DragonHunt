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
			if (elJuego.getPrimerDragon().isSeFue()) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				elJuego.getPrimerDragon().setSeFue(false);
			}
			
		}
	}

}
