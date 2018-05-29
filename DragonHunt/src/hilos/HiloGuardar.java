package hilos;

import interfaz.VentanaPrincipal;
import modelo.JuegoDragon;

public class HiloGuardar extends Thread{
	public static final int VELOCIDAD = 5000;
	private VentanaPrincipal vPrincipal;
	private JuegoDragon elJuego;
	private boolean detener;
	public HiloGuardar(VentanaPrincipal vPrincipal, JuegoDragon elJuego) {
		
		super();
		this.vPrincipal = vPrincipal;
		this.elJuego = elJuego;
		detener = false;
	}
	@Override
	public void run() {
		while (!detener) {
//			elJuego.guardarPartida();
			try {
				Thread.sleep(VELOCIDAD);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
