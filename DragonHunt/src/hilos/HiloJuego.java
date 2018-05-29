package hilos;

import interfaz.VentanaPrincipal;
import modelo.JuegoDragon;

public class HiloJuego extends Thread{
	private VentanaPrincipal vPrincipal;
	private JuegoDragon elJuego;
	private boolean detener;
	public HiloJuego(VentanaPrincipal vPrincipal, JuegoDragon elJuego) {
		
		super();
		this.vPrincipal = vPrincipal;
		this.elJuego = elJuego;
		detener = false;
	}
	
	public boolean isDetener() {
		return detener;
	}

	public void setDetener(boolean detener) {
		this.detener = detener;
	}

	@Override
	public void run() {
		
		while (!detener) {
			//No eliminar este syso, sino, se daña.
			System.out.println("h");
			if (elJuego.getPrimerDragon()!=null) {
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
				if (elJuego.perdio()) {
					vPrincipal.derrota();
				}
			}
			
			
		}
	}

}
