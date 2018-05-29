package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelPuntajes extends JPanel{

	//	CONSTANTES
	
	private static final String[] COLUMNNAMES = {"Jugadores","Puntajes"};
	
	//	ATRIBUTOS
	
	private JTable table;
	
	private String[][] data;
	
	private JScrollPane scrollPane;
	
	//	RELACIONES
	
	private VentanaPuntajes vPuntajes;
	
	private PanelOpcionesPuntajes pOpciones;
	
	//	CONSTRUCTOR
	/**
	 * 
	 * @param ventana
	 */
	public PanelPuntajes(VentanaPuntajes ventana) {
		vPuntajes = ventana;
		setPreferredSize(new Dimension(700, 550));
		
		pOpciones = new PanelOpcionesPuntajes(this);
        

		add(pOpciones, BorderLayout.SOUTH);
	}
	
	//	MÉTODOS
	public void mostrarPuntajes(String [][]datos) {
		data = datos;
		table = new JTable(data, COLUMNNAMES);
		scrollPane = new JScrollPane(table);
		scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
		add(scrollPane, BorderLayout.CENTER);
        
	}
	
	public void ordenarXP() {
		vPuntajes.ordenarXPunt();
		
	}

	public void ordenarXN() {
		vPuntajes.ordenarXNomb();
		
	}
	public void setData(String [][]datos) {
		data = datos;
	}
	/**
	 * Pinta el fondo del panel con una imagen.
	 */
	public void paintComponent(Graphics g) {
		Dimension tamano = getSize();
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, tamano.width, tamano.height);
		
		ImageIcon bg = new ImageIcon("img/fPuntajes.png");
		g.drawImage(bg.getImage(), 0, 0, tamano.width, tamano.height, this);
	}
}
