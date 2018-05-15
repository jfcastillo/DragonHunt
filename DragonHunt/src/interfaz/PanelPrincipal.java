package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel implements ActionListener {
	public static final String NUEVA_PARTIDA = "new";
	public static final String CARGAR_PARTIDA = "car";
	public static final String VER_PUNTAJES = "ver";
	public static ImageIcon IMG_NUEVA_PARTIDA = new ImageIcon("img/btnNuevaPartida.png");
	public static ImageIcon IMG_CARGAR_PARTIDA = new ImageIcon("img/btnCargarPartida.png");
	public static ImageIcon IMG_VER_PUNTAJES = new ImageIcon("img/bntVerPuntajes.png");

	private JButton btnNuevaPartida;
	private JButton btnCargarPartida;
	private JButton btnVerPuntajes;

	private VentanaPrincipal vPrincipal;

	public PanelPrincipal(VentanaPrincipal vPrin) {
		repaint();
		setLayout(new GridBagLayout());
		vPrincipal = vPrin;
		// Permite agregar diferentes atributos sobre c�mo van a quedar organizados en la pantalla
		GridBagConstraints constrains = new GridBagConstraints();

		setPreferredSize(new Dimension(400, 500));
		
		
		btnNuevaPartida = new JButton();	
		btnNuevaPartida.setIcon(IMG_NUEVA_PARTIDA);
		btnNuevaPartida.addActionListener(this);
		btnNuevaPartida.setActionCommand(NUEVA_PARTIDA);
		btnNuevaPartida.setPreferredSize(new Dimension(150, 30));
		// Columna en la que va a empezar el bot�n
		constrains.gridx = 1;
		// Fila en la que va a empezar el bot�n
		constrains.gridy = 0;
		// Cantidad de columnas que ocupa el boton
		constrains.gridwidth = 3;
		// Cantidad de filas que ocupa el boton
		constrains.gridheight = 1;
		
		
		add(btnNuevaPartida, constrains);

		
		//Label para dejar espacio entre los botones
		JLabel espacio = new JLabel("");
		espacio.setPreferredSize(new Dimension(150, 30));
		constrains.gridy = 1;
		add(espacio, constrains);
		
		btnCargarPartida = new JButton();
		btnCargarPartida.setIcon(IMG_CARGAR_PARTIDA);
		btnCargarPartida.addActionListener(this);
		btnCargarPartida.setActionCommand(CARGAR_PARTIDA);
		btnCargarPartida.setPreferredSize(new Dimension(150, 30));
		// Columna en la que va a empezar el bot�n
		constrains.gridx = 1;
		// Fila en la que va a empezar el bot�n
		constrains.gridy = 2;
		// Cantidad de columnas que ocupa el boton
		constrains.gridwidth = 3;
		// Cantidad de filas que ocupa el boton
		constrains.gridheight = 1;
		
		add(btnCargarPartida, constrains);
		
		JLabel espacio2 = new JLabel("");
		espacio2.setPreferredSize(new Dimension(150, 30));
		constrains.gridy = 3;
		add(espacio2, constrains);

		
		btnVerPuntajes = new JButton();
		btnVerPuntajes.setIcon(IMG_VER_PUNTAJES);
		btnVerPuntajes.addActionListener(this);
		btnVerPuntajes.setActionCommand(VER_PUNTAJES);
		btnVerPuntajes.setPreferredSize(new Dimension(150, 30));
		// Columna en la que va a empezar el bot�n
		constrains.gridx = 1;
		// Fila en la que va a empezar el bot�n
		constrains.gridy = 4;
		// Cantidad de columnas que ocupa el boton
		constrains.gridwidth = 3;
		// Cantidad de filas que ocupa el boton
		constrains.gridheight = 1;
		add(btnVerPuntajes, constrains);
		
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando == NUEVA_PARTIDA) {
			vPrincipal.nuevaPartida();
			
		}
		else if (comando == CARGAR_PARTIDA) {
			
		}
		else if (comando == VER_PUNTAJES) {
			
		}

	}

}
