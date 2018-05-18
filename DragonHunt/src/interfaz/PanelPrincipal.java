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
	
	//	CONSTANTES
	
	public static final String NUEVA_PARTIDA = "new";
	
	public static final String CARGAR_PARTIDA = "car";
	
	public static final String VER_PUNTAJES = "ver";
	
	public static final ImageIcon FONDO_PANEL = new ImageIcon("img/Fondo1.gif");
	
	public static final ImageIcon IMG_NUEVA_PARTIDA = new ImageIcon("img/btnNuevaPartida.png");
	
	public static final ImageIcon IMG_CARGAR_PARTIDA = new ImageIcon("img/btnCargarPartida.png");
	
	public static final ImageIcon IMG_VER_PUNTAJES = new ImageIcon("img/bntVerPuntajes.png");

	//	ATRIBUTOS
	
	private JButton btnNuevaPartida;
	
	private JButton btnCargarPartida;
	
	private JButton btnVerPuntajes;

	//	RELACIONES
	
	private VentanaPrincipal vPrincipal;

	//	CONSTRUCTOR
	/**
	 * Método constructor de la clase.
	 * Crea un Panel Principal e inicializa sus atributos y relaciones.
	 * @param ventana La ventana Principal.
	 */
	public PanelPrincipal(VentanaPrincipal ventana) {
		vPrincipal = ventana;
		setLayout(new GridBagLayout());
		
		// Permite agregar diferentes atributos sobre cómo van a quedar organizados en la pantalla
		GridBagConstraints constrains = new GridBagConstraints();

		setPreferredSize(new Dimension(400, 500));
		
		btnNuevaPartida = new JButton();	
		btnNuevaPartida.setIcon(IMG_NUEVA_PARTIDA);
		btnNuevaPartida.addActionListener(this);
		btnNuevaPartida.setActionCommand(NUEVA_PARTIDA);
		btnNuevaPartida.setPreferredSize(new Dimension(150, 30));
		// Columna en la que va a empezar el botón
		constrains.gridx = 1;
		// Fila en la que va a empezar el botón
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
		// Columna en la que va a empezar el botón
		constrains.gridx = 1;
		// Fila en la que va a empezar el botón
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
		// Columna en la que va a empezar el botón
		constrains.gridx = 1;
		// Fila en la que va a empezar el botón
		constrains.gridy = 4;
		// Cantidad de columnas que ocupa el boton
		constrains.gridwidth = 3;
		// Cantidad de filas que ocupa el boton
		constrains.gridheight = 1;
		add(btnVerPuntajes, constrains);	
	}
	
	public void paintComponent(Graphics g) {
		Dimension tamano = getSize();
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, tamano.width, tamano.height);
		
		
		g.drawImage(FONDO_PANEL.getImage(), 0, 0, tamano.width, tamano.height, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando == NUEVA_PARTIDA) {
			vPrincipal.nuevaPartida();
		}
		else if (comando == CARGAR_PARTIDA) {
			try {
				vPrincipal.cargarPartida();
			}
			catch(Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		else if (comando == VER_PUNTAJES) {
			vPrincipal.verPuntajes();
		}
	}
	
}