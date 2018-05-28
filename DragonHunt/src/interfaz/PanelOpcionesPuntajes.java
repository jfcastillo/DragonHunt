package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOpcionesPuntajes extends JPanel implements ActionListener{

	//	CONSTANTES
	/**
	 * 
	 */
	public static final String ORDENAR_NOMBRE = "xnombre";
	/**
	 * 
	 */
	public static final String ORDENAR_PUNTAJE = "xpuntaje";
	
	//	ATRIBUTOS
	
	private JButton butOrdenarXNombre;
	
	private JButton butOrdenarXPuntaje;
	
	//	RELACIONES
	
	private PanelPuntajes pContenedor;
	
	//	CONSTRUCTOR
	
	public PanelOpcionesPuntajes(PanelPuntajes panel) {
		pContenedor = panel;
		setLayout( new GridLayout(1, 2));
		setPreferredSize( new Dimension(700, 50) );
		TitledBorder border = BorderFactory.createTitledBorder("Ordenar puntajes por: ");
		border.setTitleColor( Color.WHITE );
		setBorder( border );
		setOpaque(false);
		
		butOrdenarXNombre = new JButton("Nombre");
		butOrdenarXNombre.addActionListener(this);
		butOrdenarXNombre.setActionCommand(ORDENAR_NOMBRE);
		
		butOrdenarXPuntaje = new JButton("Puntaje");
		butOrdenarXPuntaje.addActionListener(this);
		butOrdenarXPuntaje.setActionCommand(ORDENAR_PUNTAJE);
		
		add(butOrdenarXNombre);
		add(butOrdenarXPuntaje);
	}
	
	//	MÉTODOS
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando == ORDENAR_NOMBRE) {
			pContenedor.ordenarXN();
		}
		else if(comando == ORDENAR_PUNTAJE){
			pContenedor.ordenarXP();
		}
	}
}
