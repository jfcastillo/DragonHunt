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
		hiloMover = new HiloMover(this, elJuego);
		hiloCrear = new HiloCrear(this, elJuego);
		
		add(pPrincipal);
		
		pack();
		
	}
	
	public void crearDragon() {
		elJuego.crearDragon();
	}
	
	public void nuevaPartida() {
		setVisible(false);
		vJuego = new VentanaJuego(this);
		crearDragon();
//		hiloCrear.start();
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
	public String[] buscarInfoDragon(int i) {
		String[] info =new String[3];
		if (elJuego.buscarDragonCodigo(i)!=null) {
			info[0] = elJuego.buscarDragonCodigo(i).getRutaImagen();
			info[1] = elJuego.buscarDragonCodigo(i).getPosicionX()+"";
			info[2] = elJuego.buscarDragonCodigo(i).getPosicionY()+"";
		}
		else {
			info[0] = "";
			info[1] = "";
			info[2] = "";
		}
		return info;
		
	}
	/**
	 * Método llamado al hacer click en el juego
	 * Llamar al método del mundo encargado de calcular el puntaje si hizo click sobre un dragón
	 * @param x Posición X del cursor
	 * @param y Posición Y del cursor
	 */
	public void calcularPuntaje(int x, int y) {
		elJuego.calcularPuntaje(x, y);
	}
	
	public int darNumDragones() {
		return elJuego.getNumDragones();
	}
	public int darMunicion() {
		return elJuego.getJugadorActual().getMunicion();
	}
	public int darDragonesAtrapados() {
		return elJuego.getJugadorActual().getDragonesAtrapados();
	}
	public String darFondoJuego() {
		return elJuego.getFondoJuego();
	}
	
	public static void main(String[] args) {
		VentanaPrincipal principal = new VentanaPrincipal();
	}
}