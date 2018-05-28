package hilos;

import interfaz.VentanaPrincipal;
import modelo.Dragon;
import modelo.JuegoDragon;

public class HiloMover extends Thread {
	private int velocidad;
	
	private VentanaPrincipal vPrincipal;
	private JuegoDragon elJuego;

	public HiloMover(VentanaPrincipal vPrincipal, JuegoDragon elJuego) {	
		velocidad = 5;
		this.vPrincipal = vPrincipal;
		this.elJuego = elJuego;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public VentanaPrincipal getvPrincipal() {
		return vPrincipal;
	}

	public void setvPrincipal(VentanaPrincipal vPrincipal) {
		this.vPrincipal = vPrincipal;
	}

	public JuegoDragon getElJuego() {
		return elJuego;
	}

	public void setElJuego(JuegoDragon elJuego) {
		this.elJuego = elJuego;
	}

	@Override
	public void run() {
		boolean salir = false;
		
		while (!salir) {
			int i = 0;
			Dragon drag = elJuego.buscarDragonCodigo(i);
			for (; i < elJuego.getNumDragones(); i++) {
				if (drag!=null) {
					drag.mover();
//					System.out.println(i);
				}				
			}
			if (drag != null) {
				try {
					Thread.sleep(drag.getVelocidad());
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			}
			
			
		}
		
	}
	

}
