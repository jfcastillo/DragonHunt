package hilos;

import interfaz.VentanaJuego;
import interfaz.VentanaPrincipal;
import modelo.JuegoDragon;

public class HiloCrear extends Thread{

	private VentanaPrincipal vPrincipal;
	private JuegoDragon elJuego;
	public HiloCrear(VentanaPrincipal vPrincipal, JuegoDragon elJuego) {
		super();
		this.vPrincipal = vPrincipal;
		this.elJuego = elJuego;
	}
	
	@Override
	public void run() {
		int i = 1;
		while (i<=10) {
//			elJuego.crearDragonAleatorio(i);
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
}
