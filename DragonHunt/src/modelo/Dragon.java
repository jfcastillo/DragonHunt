package modelo;

import java.awt.Rectangle;

import javax.swing.GroupLayout.SequentialGroup;

public abstract class Dragon implements Movible {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	public static int MINIMO_X = 0;
	public static int MAXIMO_X = 850;
	public static int MINIMO_Y = 0;
	public static int MAXIMO_Y = 700;
	public static int VALOR_PUNTAJE = 10;
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * C�digo con el que se va a identificar el Drag�n
	 */
	private int codigo;
	/**
	 * Ruta de la imagen que va a tener el Drag�n
	 */
	private String rutaImagen;
	/**
	 * Posici�n X donde se encuentra en la pantalla
	 */
	protected int posicionX;
	/**
	 * Posici�n X donde se encuentra en la pantalla
	 */
	protected int posicionY;
	/**
	 * El movimiento del dragon, true si se est� moviendo a la derecha.
	 */
	private boolean moviendoDerecha;
	/**
	 * El movimiento del dragon, true si se est� moviendo hacia arriba.
	 */
	private boolean moviendoArriba;
	/**
	 * Estado en que se encuentra el dragon.
	 */
	private boolean muerto;
	/**
	 * Estado de vuelo en que se encuentra el drag�n.
	 */
	private boolean seFue;
	/**
	 * Velocidad a la que se mueve
	 */
	protected int velocidad;
	/**
	 * Tama�o del area del drag�n
	 */
	protected Rectangle area;
	/**
	 * El Drag�n siguiente de la lista
	 */
	private Dragon siguiente;
	/**
	 * El Drag�n anterior de la lista
	 */
	private Dragon anterior;

	/**
	 * Crea un nuevo drag�n con la informaci�n necesaria
	 * 
	 * @param codigo
	 *            C�digo con el que se va a identificar el Drag�n
	 * @param rutaImagen
	 *            Ruta de la imagen que va a tener el Drag�n
	 */
	public Dragon(int codigo, String rutaImagen, boolean moviendoDerecha) {
		this.codigo = codigo;
		this.rutaImagen = rutaImagen;
		this.moviendoDerecha = moviendoDerecha;
		moviendoArriba = true;
		muerto = false;
		int rangoPosX = (MAXIMO_X - MINIMO_X) + 1;
		posicionX = (int) (Math.random() * rangoPosX) + MINIMO_X;
		posicionY = MAXIMO_Y;
		area = new Rectangle(posicionX, posicionY, 200, 177);
		velocidad = 5;
	}

	public Rectangle getArea() {
		return area;
	}

	public void setArea(int x, int y) {
		area = new Rectangle(x, y, 200, 177);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX += posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY -= posicionY;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public boolean isMoviendoDerecha() {
		return moviendoDerecha;
	}

	public void setMoviendoDerecha(boolean moviendoDerecha) {
		this.moviendoDerecha = moviendoDerecha;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public boolean isMuerto() {
		return muerto;
	}

	public void setMuerto(boolean estaMuerto) {
		this.muerto = estaMuerto;
	}
	

	public boolean isSeFue() {
		return seFue;
	}

	public void setSeFue(boolean seFue) {
		this.seFue = seFue;
	}

	public boolean isMoviendoArriba() {
		return moviendoArriba;
	}

	public void setMoviendoArriba(boolean moviendoArriba) {
		this.moviendoArriba = moviendoArriba;
	}

	public Dragon getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Dragon siguiente) {
		this.siguiente = siguiente;
	}

	public Dragon getAnterior() {
		return anterior;
	}

	public void setAnterior(Dragon anterior) {
		this.anterior = anterior;
	}

	public void desconectarSiguiente() {
		siguiente = siguiente.getSiguiente();
	}

}
