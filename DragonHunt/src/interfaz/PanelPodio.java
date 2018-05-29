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
	
	public String[] recibirPodio() {
		String p = vPuntajes.verPodio();
		String[] p1 = p.split(" ");
		String[] p3 = new String[6];
		int c = 0;
		for (int i = 0; i < 3; i++) {
			String[] n = p1[i].split("_");
			p3[c] = n[0];
			c++;
			p3[c] = n[1];
			c++;
		}
		return p3;
	}
	
	//	MÉTODOS
	public void paintComponent(Graphics g) {
		Dimension tamano = getSize();
		String[] s = recibirPodio();
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, tamano.width, tamano.height);
		
		ImageIcon bg = new ImageIcon("img/fPodio.png");
		g.drawImage(bg.getImage(), 0, 0, tamano.width, tamano.height, this);
		
		ImageIcon pd = new ImageIcon("img/podio.png");
		g.drawImage(pd.getImage(), 70, 170, pd.getIconWidth(), pd.getIconHeight(), this);
		try {
			g.drawString(s[0], 70, 170);
			g.drawString(s[1], 80, 180);
//			g.drawString(s[2], 70, 170);
//			g.drawString(s[3], 80, 180);
//			g.drawString(s[4], 70, 170);
//			g.drawString(s[5], 80, 180);
		}
		catch(NullPointerException np) {
			np.getMessage();
		}
	}
}
