package modelo;

public class Jugador {
	/**
	 * Nombre del jugador
	 */
	private String nombre;
	/**
	 * Puntaje que ha alcanzado el jugador
	 */
	private int puntaje;
	/**
	 * Subárbol izquierdo de jugadores
	 */
	private Jugador izq;
	/**
	 * Subárbol derecho de jugadores
	 */
	private Jugador der;
	/**
	 * Constructor
	 * Crea un nuevo jugador con la información necesaria
	 * @param nombre Nombre del jugador
	 * @param puntaje Puntaje inicial del jugador
	 */
	public Jugador(String nombre, int puntaje) {
		super();
		this.nombre = nombre;
		this.puntaje = puntaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public Jugador getIzq() {
		return izq;
	}
	public void setIzq(Jugador izq) {
		this.izq = izq;
	}
	public Jugador getDer() {
		return der;
	}
	public void setDer(Jugador der) {
		this.der = der;
	}
	

}
