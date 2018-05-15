package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaJuego extends JFrame{
	public static ImageIcon FONDO_JUEGO = new ImageIcon("img/fondo_P.gif");
	
	private VentanaPrincipal vPrincipal;

	public VentanaJuego(VentanaPrincipal vPrin) {
		
		setVisible(false);
		setSize(1000, 500);
		setLocationRelativeTo(null);
//		setPreferredSize(new Dimension(1000, 800));
		vPrincipal = vPrin;
	}
	@Override
	public void paint(Graphics g) {
		Dimension d = getSize();
		g.drawImage(FONDO_JUEGO.getImage(), 0, 0, d.width, d.height, null);
		
		
	}

}
