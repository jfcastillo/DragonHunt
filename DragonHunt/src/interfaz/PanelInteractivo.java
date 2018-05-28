package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
* Entidad que representa el Panel Interactivo en la ventana de juego.
* @author Felipe Castillo && Mayumi Tamura
* @version 4.0 23/05/18
*/
public class PanelInteractivo extends JPanel implements MouseListener{
	
	/* Falta procesar el fin de la ola de dragones */
	//CONSTANTES
	public static final ImageIcon ICONO_MUNICION = new ImageIcon("img/municion.png");
	
	//	RELACIONES
	
	private VentanaJuego vJuego;
	
	//	CONSTRUCTOR
	/**
	 * Método constructor de la clase.
	 * Crea un PanelInteractivo, inicializa sus atributos.
	 * @param ventana La ventana de juego.
	 */
	public PanelInteractivo(VentanaJuego ventana) {
		vJuego = ventana;
		setPreferredSize( new Dimension(1000, 670) );
		addMouseListener(this);
	}
	
	//	MÉTODOS
	
	/**
	 * Método para pintar el fondo y los dragones.
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		//Imagen fondo-------------------------------------------------------------
		Dimension tamano = getSize();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, tamano.width, tamano.height);
		String fondo = vJuego.darVentanaPrincipal().darFondoJuego();
		ImageIcon imgFondo = new ImageIcon(fondo);
		g.drawImage(imgFondo.getImage(), 0, 0, tamano.width, tamano.height, this);
		//--------------------------------------------------------------------------
		//Ícono dragón--------------------------------------------------------------
		ImageIcon dr = new ImageIcon("img/dragon.png");
		g.drawImage(dr.getImage(), 30, 550, this);
		//--------------------------------------------------------------------------
		//Fuente--------------------------------------------------------------------
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.setColor(Color.WHITE);
		g.drawString(vJuego.darVentanaPrincipal().darDragonesAtrapados()+"", 120, 600);
		//--------------------------------------------------------------------------
		
		//Ícono munición------------------------------------------------------------
		int municion = vJuego.darVentanaPrincipal().darMunicion();
		int xMunicion = 160;
		for (int i = 0; i < municion; i++) {
			
			g.drawImage(ICONO_MUNICION.getImage(), xMunicion, 550, this);
			xMunicion += 45;
			
		}
		//--------------------------------------------------------------------------
		
		//Pintar dragones-----------------------------------------------------------
		int numD = vJuego.darVentanaPrincipal().darNumDragones();
		for (int i = 0; i < numD; i++) {			
			String ruta = vJuego.darVentanaPrincipal().buscarInfoDragon(i)[0];
			if (ruta.length()>0) {
				int x = Integer.parseInt(vJuego.darVentanaPrincipal().buscarInfoDragon(i)[1]);
				int y = Integer.parseInt(vJuego.darVentanaPrincipal().buscarInfoDragon(i)[2]);
				ImageIcon dragon = new ImageIcon(ruta);
				g.drawImage(dragon.getImage(), x, y, this);
			}
			
			//vJuego.darVentanaPrincipal().darJuego().buscarDragonCodigo(i).mover();
		}	
		//--------------------------------------------------------------------------
	}
	
	
//	public void pintarExplosion(int x, int y) {
//		Graphics g = getGraphics();
//		ImageIcon explosion = new ImageIcon("img/explosion.gif");
//		g.drawImage(explosion.getImage(), x, y, this);
//		
//	}
	
	public void reproducirDisparo() {
		try {
			AudioInputStream aus = AudioSystem.getAudioInputStream(new File("sonidos/tiro.wav").getAbsoluteFile());
			Clip audio = AudioSystem.getClip();
			audio.open(aus);
			audio.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		reproducirDisparo();
		vJuego.darVentanaPrincipal().calcularPuntaje(e.getX(),e.getY());
//		System.out.println(e.getX());
//		System.out.println(e.getY());
//		pintarExplosion(e.getX(), e.getY());
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
