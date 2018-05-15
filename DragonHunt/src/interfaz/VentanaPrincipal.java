package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class VentanaPrincipal extends JFrame {
	private PanelPrincipal pPrincipal;
	private VentanaJuego vJuego;
	
	public VentanaPrincipal() {
		super("Dragon Hunt");
		
		setSize(700,600);
		setLocationRelativeTo(null);//"Centra" la pantalla
		pPrincipal = new PanelPrincipal(this);
		vJuego = new VentanaJuego(this);
		add(pPrincipal);		
		pack();
		repaint();

		
	}
	@Override
	public void paint(Graphics g) {		
		Dimension d = getSize();
		ImageIcon fondo = new ImageIcon("img/Fondo1.gif");
		g.drawImage(fondo.getImage(), 0, 0, d.width, d.height, null);

	}
	
	public void nuevaPartida() {
		vJuego.setVisible(true);
		this.setVisible(false);
		
	}
	public void cargarPartida() {
		
	}
	public void verPuntajes() {
		
	}
	

	
	public static void main(String[] args) {
		VentanaPrincipal principal = new VentanaPrincipal();
		principal.setVisible(true);
		

	}

}
