package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaJuego extends JFrame implements MouseListener{
	public static ImageIcon FONDO_JUEGO = new ImageIcon("img/fondo_P.gif");
	
	private VentanaPrincipal vPrincipal;

	public VentanaJuego(VentanaPrincipal vPrin) {
		
		setVisible(false);
		setSize(1000, 500);
		setLocationRelativeTo(null);
		addMouseListener(this);
		vPrincipal = vPrin;
	}
	@Override
	public void paint(Graphics g) {
		Dimension d = getSize();
		g.drawImage(FONDO_JUEGO.getImage(), 0, 0, d.width, d.height, null);
		ImageIcon dragon = new ImageIcon(vPrincipal.darDragonAleatorio().getRutaImagen());
		System.out.println(dragon);
		System.out.println(vPrincipal.darDragonAleatorio().getRutaImagen());
		System.out.println("x"+vPrincipal.darDragonAleatorio().getPosicionX());
		System.out.println("y"+vPrincipal.darDragonAleatorio().getPosicionY());
		g.drawImage(dragon.getImage(), vPrincipal.darDragonAleatorio().getPosicionX(), vPrincipal.darDragonAleatorio().getPosicionY(), null);
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.println(e.getX());
//		System.out.println(e.getY());
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {}

}
