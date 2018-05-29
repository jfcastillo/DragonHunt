package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
* Entidad que representa el Panel de Opciones en la ventana de juego.
* @author Felipe Castillo && Mayumi Tamura
* @version 4.0 23/05/18
*/
public class PanelOpcionesJuego extends JPanel implements ActionListener{
	
	//	CONSTANTES
	
	public static final String GUARDAR = "guardar";
	
	public static final String VOLVER_PRINCIPAL= "volver";

	//	ATRIBUTOS
	
	private JButton btnGuardar;
	
	private JButton btnVolver;
	
	//	RELACIONES
	
	private VentanaJuego vJuego;
	
	//	CONSTRUCTOR
	/**
	 * Método constructor de la clase.
	 * Crea un PanelOpcionesJuego, inicializa sus atributos.
	 * @param ventana La ventana de juego.
	 */
	public PanelOpcionesJuego(VentanaJuego ventana) {
		vJuego = ventana;
		setPreferredSize( new Dimension(1000, 30) );
		setBackground(Color.BLACK);
		setLayout(new GridLayout(1,4));
		ImageIcon imgGuardar = new ImageIcon("img/btnGuardar.png");
		btnGuardar = new JButton();
		btnGuardar.setIcon(imgGuardar);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand(GUARDAR);
		
		ImageIcon imgVolver = new ImageIcon("img/btnVolver.png");
		btnVolver = new JButton();
		btnVolver.setIcon(imgVolver);
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand(VOLVER_PRINCIPAL);
		
		add(btnGuardar);
		add(new JLabel(""));		
		add(new JLabel(""));
		add(btnVolver);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando == GUARDAR) {
			String jA = JOptionPane.showInputDialog("Ingrese su nombre: ");
			vJuego.guardar(jA);
			//vJuego.darVentanaPrincipal().guardarPuntajes();
			System.out.println(btnGuardar.getSize());
			
		}
		else if (comando == VOLVER_PRINCIPAL) {
			vJuego.dispose();
			vJuego.volverPrincipal();
			try {
				
			}
			catch(Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
