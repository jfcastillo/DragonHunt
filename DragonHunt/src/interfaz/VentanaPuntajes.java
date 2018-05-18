package interfaz;

import javax.swing.JFrame;

public class VentanaPuntajes extends JFrame{

	//	RELACIONES
	/**
	 * 
	 */
	private VentanaPrincipal vPrincipal;
	
	//	CONSTRUCTOR
	/**
	 * 
	 * @param vPrincipal
	 */
	public VentanaPuntajes(VentanaPrincipal principal) {
		vPrincipal = principal;
		setTitle("Puntajes");
		setSize(700, 600);
		setResizable(false);
		setVisible(true);
		//setLayout();
	}
	
	//	MÉTODOS
	
	public void buscarJugador() {
		
	}
	
	public void ordenarXPuntaje() {
		
	}
}
