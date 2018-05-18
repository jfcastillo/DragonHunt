package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import hilos.*;
import modelo.Dragon;
import modelo.JuegoDragon;
/**
 * Clase principal de la interfaz
 * @author Felipe Castillo && Mayumi Tamura
 * @version 4.0 23/05/18
 */
public class VentanaPrincipal extends JFrame {
	//	CONSTANTES
	/**
	 * 
	 */
	public static final ImageIcon ICON = new ImageIcon("img/logo.png");
	
	//	RELACIONES
	/**
	 * El panel principal de la ventana.
	 */
	private PanelPrincipal pPrincipal;
	/**
	 * La ventana interactiva del juego.
	 */
	private VentanaJuego vJuego;
	/**
	 * La ventana de puntajes.
	 */
	private VentanaPuntajes vPuntajes;
	/**
	 * El juego de la interfaz.
	 */
	private JuegoDragon elJuego;
	/**
	 * El hilo de movimiento.
	 */
	private HiloMover hiloMover;
	/**
	 * El hilo de creación
	 */
	private HiloCrear hiloCrear;
	
	//CONSTRUCTOR
	/**
	 * Método constructor de la clase.
	 * Crea una ventana principal e inicializa sus relaciones.
	 */
	public VentanaPrincipal() {
		setTitle("Dragon Hunt");
		setSize(700,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		setIconImage(ICON.getImage());
		
		setLocationRelativeTo(null);//"Centra" la pantalla
		
		pPrincipal = new PanelPrincipal(this);
		elJuego = new JuegoDragon();
		hiloMover = new HiloMover(this);
		hiloCrear = new HiloCrear(this, elJuego);
		
		add(pPrincipal);
		
		pack();
		
	}
	
	public JuegoDragon darJuego() {
		return elJuego;
	}
	
	public void nuevaPartida() {
		setVisible(false);
		vJuego = new VentanaJuego(this);
		hiloCrear.start();
		hiloMover.start();
	}
	
	public void cargarPartida() {
		
	}
	
	public void verPuntajes() {
		setVisible(false);
		vPuntajes = new VentanaPuntajes(this);
	}
	
	public void nivel() {
		
	}
	
	public void mover() {
		
	}
	
	
	public static void main(String[] args) {
		VentanaPrincipal principal = new VentanaPrincipal();
	}
}