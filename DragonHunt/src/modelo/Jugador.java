package modelo;
/**
 * Entidad que representa al jugador.
 * @author Felipe Castillo && Mayumi Tamura
 * @version 4.0 23/05/18
 */
public class Jugador {
	
	//	ATRIBUTOS
	/**
	 * Nombre del jugador
	 */
	private String nombre;
	/**
	 * Puntaje que ha alcanzado el jugador
	 */
	private int puntaje;
	/**
	 * Cantidad de dragones atrapados
	 */	
	private int dragonesAtrapados;
	/**
	 * Munición actual del jugador
	 */
	private int municion;
	
	//	RELACIONES
	/**
	 * Subárbol izquierdo de jugadores
	 */
	private Jugador izq;
	/**
	 * Subárbol derecho de jugadores
	 */
	private Jugador der;
	
	//	CONSTRUCTOR
	/**
	 * Método constructor de la clase.
	 * Crea un nuevo jugador con la información necesaria e inicializa sus atributos y relaciones.
	 * @param nombre El nombre del jugador.
	 * @param puntaje El puntaje inicial del jugador.
	 */
	public Jugador(String nombre, int puntaje) {
		super();
		this.nombre = nombre;
		this.puntaje = puntaje;
		municion = 3;
		izq = null;
		der = null;
	}
	
	//	MÉTODOS GET && SET
		
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void aumentarPuntaje(int puntaje) {
		this.puntaje += puntaje;
	}
	
	public void disminuirPuntaje() {
		puntaje -= 10;
	}
	public void aumentarDragonesAtrapados() {
		dragonesAtrapados++;
	}
	public void disminuirMunicion() {
		municion--;
	}
	
	public int getDragonesAtrapados() {
		return dragonesAtrapados;
	}

	public void setDragonesAtrapados(int dragonesAtrapados) {
		this.dragonesAtrapados = dragonesAtrapados;
	}
	
	public int getMunicion() {
		return municion;
	}

	public void setMunicion(int municion) {
		this.municion = municion;
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
	/**
	 * Método para verificar la munición restante del jugador
	 * @return false si aún tiene munición, o verdadero si se le acabó la munición.
	 */
	public boolean verificarMunicion() {
		boolean verificar = false;
		if (municion == 0) {
			verificar = true;
		}
		return verificar;
	}
	/**
	 * Método para recargar la munición agregandole 3.
	 */
	public void reiniciarMunicion() {
		municion = 3;
	}
}