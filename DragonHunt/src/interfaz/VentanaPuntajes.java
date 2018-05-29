package interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPuntajes extends JFrame implements ActionListener, ItemListener {

	//	CONSTANTES
	/**
	 * 
	 */
	public static final String PUNTAJES = "Puntajes";
	/**
	 * 
	 */
	public static final String PODIO = "Podio";
	/**
	 * 
	 */
	public static final String VOLVER_PRINCIPAL= "volver";
	
	//	ATRIBUTOS
	
	private JButton btnVolver;
	
	private JPanel cards;
	
	//	RELACIONES
	/**
	 * 
	 */
	private VentanaPrincipal vPrincipal;
	
	private PanelPuntajes pPuntajes;
	
	private PanelPodio pPodio;
	
	//	CONSTRUCTOR
	/**
	 * Método constructor de la clase.
	 * Crea una VentanaPuntajes, inicializa sus atributos.
	 * @param principal La ventana principal del juego.
	 */
	public VentanaPuntajes(VentanaPrincipal principal) {
		vPrincipal = principal;
		setLayout(new BorderLayout());
		setTitle("Puntajes");
		setSize(700, 600);
		setResizable(false);
		setVisible(true);
		
		pPuntajes = new PanelPuntajes(this);
		pPodio = new PanelPodio(this);
		
		String comboBoxItems[] = { PUNTAJES, PODIO };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        
        cards = new JPanel(new CardLayout());
        cards.add(pPuntajes, PUNTAJES);
        cards.add(pPodio, PODIO);
		
		ImageIcon imgVolver = new ImageIcon("img/btnVolver.png");
		btnVolver = new JButton();
		btnVolver.setIcon(imgVolver);
		btnVolver.addActionListener(this);
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setActionCommand(VOLVER_PRINCIPAL);
		
		add(cb, BorderLayout.NORTH);
		add(cards, BorderLayout.CENTER);
		add(btnVolver, BorderLayout.SOUTH);
	}
	
	//	MÉTODOS
	
	public String[][] darPuntajes() {
		return vPrincipal.darPuntajes();
//		String[][] p = new String[2][2];
//		p[0][0] = "1 Jugador";
//		p[0][1] = "1 su puntaje";
//		p[1][0] = "2 Jugador";
//		p[1][1] = "2 su puntaje";
//		return p;
	}
	public void cambiarPuntajes(String[][] datos) {
		pPuntajes.setData(datos);
	}
	
	public void ordenarXPunt() {
		//vPrincipal.ordenarPuntajesXPnts();
		pPuntajes.repaint();
		
	}
	
	public void ordenarXNomb() {
		//vPrincipal.ordenarPuntajesXNombre();
		pPuntajes.repaint();
		
	}
	/**
	 * Permite cambiar el panel ubicado en el centro, variando entre PanelPuntajes y PanelPodio.
	 * @param ItemEvent La selección del JComboBox sobre cual panel se debe visualizar.
	 */
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando == VOLVER_PRINCIPAL) {
			try {
				vPrincipal.setVisible(true);
				this.dispose();
			}
			catch(Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
