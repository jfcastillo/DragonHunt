package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelPodio extends JPanel{
	
	//	RELACIONES
	
	private VentanaPuntajes vPuntajes;
	
	//	CONSTRUCTOR
	/**
	 * Método constructor de la clase.
	 * @param ventana
	 */
	public PanelPodio(VentanaPuntajes ventana) {
		vPuntajes = ventana;
		setPreferredSize(new Dimension(700, 550));
	}
	
	//	MÉTODOS
	public void paintComponent(Graphics g) {
		Dimension tamano = getSize();
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, tamano.width, tamano.height);
		
		ImageIcon bg = new ImageIcon("img/fPodio.png");
		g.drawImage(bg.getImage(), 0, 0, tamano.width, tamano.height, this);
		
		ImageIcon pd = new ImageIcon("img/podio.png");
		g.drawImage(pd.getImage(), 50, 100, pd.getIconWidth(), pd.getIconHeight(), this);
	}
}
