package interfaz;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
/**
 * 
 * @author Felipe Castillo && Mayumi Tamura
 * @version 4.0 23/05/18
 */
public class VentanaJuego extends JFrame {
	
	//	RELACIONES
	
	private VentanaPrincipal vPrincipal;
	
	private PanelInteractivo pInteractivo;
	
	private PanelOpcionesJuego pOpcionesJuego;
	
	//	CONSTRUCTOR
	/**
	 * Método constructor de la clase.
	 * Crea una Ventana de juego e inicializa sus atributos.
	 * @param ventana La ventana principal.
	 */
	public VentanaJuego(VentanaPrincipal ventana) {
		vPrincipal = ventana;
		setTitle("Dragon Hunt");
		setSize(1000, 700);
		setLayout( new BorderLayout());
		setResizable(false);
		setVisible(true);
		
		setIconImage(vPrincipal.ICON.getImage());
		pInteractivo = new PanelInteractivo(this);
		pOpcionesJuego = new PanelOpcionesJuego(this);
		
		add(pInteractivo, BorderLayout.CENTER);
		add(pOpcionesJuego, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
	}
	
	//	MÉTODOS
	
	public VentanaPrincipal darVentanaPrincipal() {
		return vPrincipal;
	}
	
	public void guardar() {
		
	}
	
	public void volverPrincipal() {
		
	}
}