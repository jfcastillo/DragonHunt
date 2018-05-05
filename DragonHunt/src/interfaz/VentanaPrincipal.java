package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame implements ActionListener {
	public static final String NUEVA_PARTIDA = "new";
	public static final String CARGAR_PARTIDA = "car";
	public static final String VER_PUNTAJES = "ver";
		
	private JButton btnNuevaPartida;
	private JButton btnCargarPartida;
	private JButton btnVerPuntajes;
	

	public VentanaPrincipal() {
		super("Dragon Hunt");
		setLayout(new GridLayout(6, 1));
		setPreferredSize(new Dimension(400, 500));
//		setLocationRelativeTo(null);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btnNuevaPartida = new JButton("Nueva partida");
		btnNuevaPartida.addActionListener(this);
		btnNuevaPartida.setActionCommand(NUEVA_PARTIDA);
		btnNuevaPartida.setContentAreaFilled(false);
		
		btnCargarPartida = new JButton("Cargar partida");
		btnCargarPartida.addActionListener(this);
		btnCargarPartida.setActionCommand(CARGAR_PARTIDA);
		btnCargarPartida.setContentAreaFilled(false);
		
		btnVerPuntajes = new JButton("Ver puntajes");
		btnVerPuntajes.addActionListener(this);
		btnVerPuntajes.setActionCommand(VER_PUNTAJES);
		btnVerPuntajes.setContentAreaFilled(false);
		
		add(btnNuevaPartida);
		add(btnCargarPartida);
		add(btnVerPuntajes);
		repaint();
		pack();
		
	}

	@Override
	public void paint(Graphics g) {
		g.fillRect(0, 0, 400, 500);
		ImageIcon fondo = new ImageIcon("img/Fondo.gif");
		g.drawImage(fondo.getImage(), 0, 0, null);
		
	}
	public static void main(String[] args) {
		VentanaPrincipal principal = new VentanaPrincipal();
		principal.setVisible(true);
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
