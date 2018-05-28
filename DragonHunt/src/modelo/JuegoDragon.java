package modelo;
/**
 * Clase principal del modelo del juego.
 * @author Felipe Castillo && Mayumi Tamura
 * @version 4.0 23/05/18
 */
public class JuegoDragon {
	
	//	ATRIBUTOS
	/**
	 * Nivel en el que se encuentra el juego
	 */
	private int nivel;
	/**
	 * La imagen de fondo del juego. 
	 */
	private String fondo;
	/**
	 * Cantidad de dragones en la lista
	 */
	private int numDragones;
	
	//	RELACIONES
	/**
	 * Usuario jugando actualmente
	 */
	private Jugador jugadorActual;
	/**
	 * Primer jugador del arbol de jugadores
	 */	
	private Jugador jugadorRaiz;
	/**
	 * Primer dragón de la lista
	 */
	private Dragon primerDragon;
	/**
	 * Último dragón de la lista
	 */
	private Dragon ultimoDragon;
	
	//	CONSTRUCTOR
	/**
	 * Método constructor de la clase.
	 * Crea un nuevo juego e inicializa sus atributos.	
	 */
	public JuegoDragon() {
		jugadorActual = new Jugador("", 0);
		jugadorRaiz = null;
		primerDragon = null;
		ultimoDragon = null;
		numDragones = 0;
		nivel = 0;
		fondo = "img/fondo_P.gif";
	}

	//	MÉTODOS	
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel() {
		nivel += 1;
		if(nivel==1) {
			setFondoJuego("img/fondo_juego.jpg");
		}
		else if(nivel==2) {
			setFondoJuego("img/fondo_juego.jpg");
		}
		else if(nivel==3) {
			setFondoJuego("img/fondo_juego.jpg");
		}
	}
	
	public String getFondoJuego() {
		return fondo;
	}

	public void setFondoJuego(String ruta) {
		this.fondo = ruta;
	}	

	public int getNumDragones() {
		return numDragones;
	}

	public void setNumDragones(int numDragones) {
		this.numDragones = numDragones;
	}
	
	

	public String getFondo() {
		return fondo;
	}

	public void setFondo(String fondo) {
		this.fondo = fondo;
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}

	public void setJugadorActual(Jugador jugadorActual) {
		this.jugadorActual = jugadorActual;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Jugador getJugadorRaiz() {
		return jugadorRaiz;
	}

	public void setJugadorRaiz(Jugador raiz) {
		this.jugadorRaiz = raiz;
	}

	public Dragon getPrimerDragon() {
		return primerDragon;
	}

	public void setPrimerDragon(Dragon primerDragon) {
		this.primerDragon = primerDragon;
	}

	public Dragon getUltimoDragon() {
		return ultimoDragon;
	}

	public void setUltimoDragon(Dragon ultimoDragon) {
		this.ultimoDragon = ultimoDragon;
	}

	/**
	 * Método para agregar un nuevo jugador al árbol según su puntaje.
	 * @param nombre El nombre del nuevo jugador.
	 * @param puntaje El puntaje del nuevo jugador.
	 */
	public void agregarJugador(String nombre, int puntaje) {
		Jugador nuevo = new Jugador(nombre, puntaje);
		if(jugadorRaiz==null) {
			jugadorRaiz = nuevo;
		} 
		else {
			Jugador auxiliar = jugadorRaiz;
			Jugador padre = null;
			while( auxiliar!=null ) {
				padre = auxiliar;
				if(puntaje<auxiliar.getPuntaje()) {
					auxiliar = auxiliar.getIzq();
					if (auxiliar==null) {
						padre.setIzq(nuevo);
						auxiliar = null;
					}
				}
				else {
					auxiliar = auxiliar.getDer();
					if (auxiliar==null) {
						padre.setDer(nuevo);
						auxiliar = null;
					}
				}
			}
		}
	}

	/**
	 * Método para agregar un nuevo dragón a la lista.
	 * @param drag El dragón a agregar.
	 */
	public void agregarDragon(Dragon drag) {
		Dragon actual = primerDragon;
		if (actual == null) {
			primerDragon = drag;
			ultimoDragon = drag;
			primerDragon.setAnterior(ultimoDragon);
			primerDragon.setSiguiente(ultimoDragon);
			numDragones++;
		}
		else {
			actual = ultimoDragon;
			actual.setSiguiente(drag);
			actual.getSiguiente().setAnterior(actual);
			ultimoDragon = drag;
			primerDragon.setAnterior(ultimoDragon);
			actual.getSiguiente().setSiguiente(primerDragon);
			numDragones++;
			
		}
		
	}
	
	/**
	 * Crea un dragon aleatoriamente según el nivel de juego.
	 */
//	public void crearDragonAleatorio(int i) {
//		int rangoMov = (2 - 1) + 1;
//		int random = (int) (Math.random() * rangoMov) + 1;
//		boolean moviendoDerecha = false;
//		String ruta = "";
//		if(nivel==0) {				
//			if (random == 1) {
//				moviendoDerecha = true;
//				ruta = "img/dragon_normal.gif";
//			}
//			else {
//				moviendoDerecha = false;
//				ruta = "img/dragon_normal1.gif";
//			}
//			DragonNormal normal = new DragonNormal(i, ruta, moviendoDerecha);
//			agregarDragon(normal);
//		}
//		else if(nivel==1) {
//			int codeRandom = (int) (Math.random()*2)+1;
//			if (codeRandom == 1) {
//				DragonNormal normal = new DragonNormal(i, "img/dragon_normal.gif", moviendoDerecha);
//				agregarDragon(normal);
//			}
//			else {
//				DragonSuperior superior = new DragonSuperior(i, "img/dragon_superior.gif", moviendoDerecha);
//				agregarDragon(superior);
//			}
//		}
//		else if(nivel==2) {
//			int codeRandom = (int) (Math.random()*3)+1;
//			if ( codeRandom == 1) {
//				DragonNormal normal = new DragonNormal(i, "img/dragon_normal.gif", moviendoDerecha);
//				agregarDragon(normal);
//			}
//			else if( codeRandom == 2 ){
//				DragonSuperior superior = new DragonSuperior(i, "img/dragon_superior.gif", moviendoDerecha);
//				agregarDragon(superior);
//			}
//			else {
//				DragonLegendario legendario = new DragonLegendario(i, "img/dragon_legendario.gif", moviendoDerecha);
//				agregarDragon(legendario);
//			}
//		}
//		else if(nivel==3) {
//			int codeRandom = (int) (Math.random()*3)+1;
//			if ( codeRandom == 1) {
//				DragonNormal normal = new DragonNormal(i, "img/dragon_normal.gif", moviendoDerecha);
//				agregarDragon(normal);
//			}
//			else if( codeRandom == 2 ){
//				DragonSuperior superior = new DragonSuperior(i, "img/dragon_superior.gif", moviendoDerecha);
//				agregarDragon(superior);
//			}
//			else {
//				DragonLegendario legendario = new DragonLegendario(i, "img/dragon_legendario.gif", moviendoDerecha);
//				agregarDragon(legendario);
//			}
//		}
//	}
	/**
	 * Método para recorrer la lista enlazada de dragones y buscar un dragón con un codigo,
	 * para usarlo en el movimiento del dragón
	 * @param codigo del dragón que se va a buscar
	 * @return El dragón encontrado
	 */
	public Dragon buscarDragonCodigo(int codigo) {
		Dragon encontrado = null;
		Dragon actual = primerDragon;
		if (actual == null) {
			//Lanzar NoExisteException			
		}
		else {
			if (actual.getCodigo() == codigo) {
				encontrado = actual;
			}
			else {
				boolean salir = false;
				actual = actual.getSiguiente();
				while ((actual != null) && (actual != primerDragon) && !salir) {
					if (actual.getCodigo() == codigo) {
						encontrado = actual;
						salir = true;
					}
					else {
						actual = actual.getSiguiente();
					}
				}
			}
		}
		
		return encontrado;
	}
//	public Dragon darDragonAleatorio() {		
//		int codeRamdon = (int) (Math.random()*3)+1;
//		return buscarDragonCodigo(codeRamdon);
//	}
	

	/**
	 * Método para eliminar un dragón cuando llegue al final o
	 * cuando el jugador lo atrape
	 * @param drag Dragón que se va a eliminar
	 */
	public void eliminarDragon(Dragon drag) {
		if (numDragones == 1) {
			primerDragon.setSiguiente(null);
			primerDragon.setAnterior(null);
			primerDragon = null;
			numDragones--;		
		}
		else if (drag == primerDragon) {
			primerDragon = primerDragon.getSiguiente();
			ultimoDragon.setSiguiente(primerDragon);
			numDragones--;
		}
		else {
			Dragon anterior = drag.getAnterior();
			if (anterior.getSiguiente() == ultimoDragon) {
				anterior.setSiguiente(primerDragon);
				ultimoDragon = anterior;				
			}
			else {
				anterior.desconectarSiguiente();
			}
			numDragones--;
		}
//		drag.setEstaMuerto(true);
	}
	/**
	 * Método para comprobar si existe un dragon en esa posición
	 * @param x Posición X donde el jugador hizo click
	 * @param y Posición Y donde el jugador hizo click
	 * @return El dragón encontrado
	 * @throws DragonInexistenteException 
	 */	
	public Dragon buscarDragon(int x, int y)  {
		if (primerDragon == null) {
			return null;
		}
		else if (primerDragon.getArea().contains(x,y)) {
			return primerDragon;
		}
		else {
			return buscarDragon(primerDragon.getSiguiente(), x, y);
			
		}		
	}
	/**
	 * Método recursivo para buscar un dragón
	 * @param drag El dragón que se usará para avanzar en la recusividad
	 * @param x Posición X donde el jugador hizo click
	 * @param y Posición Y donde el jugador hizo click
	 * @return El dragón encontrado
	 * @throws DragonInexistenteException  si el dragón no existe
	 */
	public Dragon buscarDragon(Dragon drag, int x, int y)  {
		if (drag == null || drag.equals(primerDragon)) {
			return null;
		}
		else {
			if (drag.getArea().contains(x,y)) {
				return drag;				
			}
			else {
				return buscarDragon(drag.getSiguiente(), x, y);
			}
		}
		
	}
	/**
	 * Método llamado al hacer click en el panel para capturar un dragón
	 * Busca si existe un dragón en las posiciones x y y donde hizo click, 
	 * si existe aumenta el puntaje.
	 * @param x Posición X donde el jugador hizo click
	 * @param y Posición Y donde el jugador hizo click
	 * @throws DragonInexistenteException 
	 */
	public void calcularPuntaje(int x, int y) throws DragonInexistenteException {
		Dragon drag = buscarDragon(x, y);
		jugadorActual.disminuirMunicion();
		verificarDragonHuida(primerDragon);
		if (drag != null) {
			
			if (jugadorActual.getMunicion()>0) {
				jugadorActual.aumentarPuntaje(drag.VALOR_PUNTAJE);
				eliminarDragon(drag);
				jugadorActual.aumentarDragonesAtrapados();
				jugadorActual.reiniciarMunicion();		
				if (jugadorActual.getDragonesAtrapados() == 5) {
					cambioDeNivel();
				}
				else {
					crearDragon();
				}
			}
					
		}
		else if (jugadorActual.getMunicion() == 0) {
			
		}
	}
	
	
	
	
	/**
	 * Método para crear un dragón de acuerdo al nivel en el que se encuentre.
	 */
	public void crearDragon() {
		if (jugadorActual.getDragonesAtrapados()<5) {
//			int rangoMov = (2 - 1) + 1;
//			int random = (int) (Math.random() * rangoMov) + 1;
			boolean moviendoDerecha = false;
			int random = (int) (Math.random()*2)+1;
			String ruta = "";
			if(nivel==0) {				
				if (random == 1) {
					moviendoDerecha = true;
					ruta = "img/dragon_normal.gif";
				}
				else {
					moviendoDerecha = false;
					ruta = "img/dragon_normal1.gif";
				}
				DragonNormal normal = new DragonNormal(numDragones, ruta, moviendoDerecha);
				agregarDragon(normal);
			}
			else if(nivel==1) {
				int randomMov = (int) (Math.random()*2)+1;
				if (randomMov == 1) {
					if (randomMov == 1) {
						moviendoDerecha = true;
						ruta = "img/dragon_normal.gif";
					}
					else {
						moviendoDerecha = false;
						ruta = "img/dragon_normal1.gif";
					}
					DragonNormal normal = new DragonNormal(numDragones, ruta, moviendoDerecha);
					agregarDragon(normal);
				}
				else {
					if (randomMov == 1) {
						moviendoDerecha = true;
						ruta = "img/dragon_superior.gif";
					}
					else {
						moviendoDerecha = false;
						ruta = "img/dragon_superior1.gif";
					}
					DragonSuperior superior = new DragonSuperior(numDragones, ruta, moviendoDerecha);
					agregarDragon(superior);
				}
			}
		}
	}
	/**
	 * Verifica si el dragón está vivo y si el jugador aún tiene munición.
	 * Si se cumple la condicion, el dragón se va.
	 * @param drag el dragon con el que se va a verificar
	 */
	public void verificarDragonHuida(Dragon drag) {
		if ((drag.isMuerto()==false) && (jugadorActual.verificarMunicion())) {
			drag.setSeFue(true);
//			eliminarDragon(drag);
//			jugadorActual.reiniciarMunicion();
			jugadorActual.setCantidadPerdidos(1);
		}
	}
	/**
	 * Método para cambiar de nivel.
	 * Cambia de nivel cuando atrapa 5 dragones.
	 */
	public void cambioDeNivel() {
		setNivel();
		jugadorActual.setDragonesAtrapados(0);
		crearDragon();
	}
	

}