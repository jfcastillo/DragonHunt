package modelo;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Entidad que representa al jugador.
 * @author Felipe Castillo && Mayumi Tamura
 * @version 4.0 23/05/18
 */
public class Jugador implements Serializable, Comparable<Jugador>, Comparator<Jugador>{
	
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
	 * Cantidad de dragones que no ha capturado el jugador
	 */
	private int cantidadPerdidos;
	
	/**
	 * Munición actual del jugador
	 */
	private int municion;
	/**
	 * El nivel actual del jugador.
	 */
	private int nivel;
	
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
		this.nombre = nombre;
		this.puntaje = puntaje;
		municion = 3;
		nivel = 0;
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
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel() {
		nivel++;
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
	//	MÉTODOS	
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
	
	public int getCantidadPerdidos() {
		return cantidadPerdidos;
	}

	public void setCantidadPerdidos(int cantidadPerdidos) {
		this.cantidadPerdidos += cantidadPerdidos;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	/**
	 * Método para recargar la munición agregandole 3.
	 */
	public void reiniciarMunicion() {
		municion = 3;
	}
	
	/**
	 * Método para comparar por orden natural. (Comparable)
	 * @param j2 El jugador contra el cual va a ser comparado.
	 * @return 0 Si son iguales los puntajes.
	 * 		   Un número positivo si el puntaje de este es Mayor al de j2.
	 * 		   Un número negativo si el puntaje de este es Menor al de j2.
	 */
	public int compareTo(Jugador j2) {
		int dif = puntaje - j2.getPuntaje();
		return dif;
	}
	
	/**
	 * Método para comparar por orden propio. (Comparator)
	 * @param j1 El primer jugador a ser comparado
	 * @param j2 El segundo jugador a ser comparado
	 * @return 0 Si los nombres son iguales.
	 * 		   1 Si el nombre de j1 es Mayor al de j2.
	 * 		   -1 Si el nombre de j1 es Menor al de j2.
	 */
	public int compare(Jugador j1, Jugador j2) {
		int dif = 0;
		String nombre1 = j1.getNombre().toUpperCase();
		String nombre2 = j2.getNombre().toUpperCase();
		dif = compararCadenas(nombre1, nombre2, 0);
		return dif;
	}
	/**
	 * Método recursivo que permite comparar cadenas.
	 * @param n1 Primera cadena de caracteres.
	 * @param n2 Segunda cadena de caracteres.
	 * @return 0 Si las cadenas son iguales.
	 * 		   1 Si n1 es Mayor a n2.
	 * 		  -1 Si n1 es Menor a n2.
	 */
	public int compararCadenas(String n1, String n2, int i) {
		if(n1.equals(n2)) {
			return 0;
		}
		if(i>n1.length()-1) {
			return -1;
		}
		if(i>n2.length()-1) {
			return 1;
		}
		else {
			if (n1.charAt(i) > n2.charAt(i)) {
				return 1;
			}
			else if(n1.charAt(i) < n2.charAt(i)) {
				return -1;
			}
			else {
				return compararCadenas(n1, n2, i+1);
			}
		}
	}

}