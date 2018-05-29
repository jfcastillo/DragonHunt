package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
	 * Jugador raiz del podio de primeros jugadores.
	 */
	private Jugador raizPodio;
	/**
	 * Lista de jugadores modificable.
	 */
	private ArrayList<Jugador> datos;
	/**
	 * Primer drag�n de la lista
	 */
	private Dragon primerDragon;
	/**
	 * �ltimo drag�n de la lista
	 */
	private Dragon ultimoDragon;
	
	//	CONSTRUCTOR
	/**
	 * M�todo constructor de la clase.
	 * Crea un nuevo juego e inicializa sus atributos.	
	 */
	public JuegoDragon() {
		jugadorActual = new Jugador("", 0);
		jugadorRaiz = null;
		primerDragon = null;
		ultimoDragon = null;
		raizPodio = null;
		datos = new ArrayList<Jugador>();
		numDragones = 0;
		nivel = 0;
		fondo = "img/fondo_P.gif";
		cargarDatos();
	}

	//	M�TODOS	
	
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
	
	//	M�TODOS
	/**
	 * M�todo para agregar un nuevo jugador al �rbol seg�n su puntaje.
	 * @param nombre El nombre del nuevo jugador.
	 * @param puntaje El puntaje del nuevo jugador.
	 */
	public void agregarJugador(String nombre, int puntaje) {
		Jugador nuevo = new Jugador(nombre, puntaje);
		datos.add(nuevo);
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
	 * M�todo para agregar un nuevo drag�n a la lista.
	 * @param drag El drag�n a agregar.
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
	 * Crea un dragon aleatoriamente seg�n el nivel de juego.
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
	 * M�todo para recorrer la lista enlazada de dragones y buscar un drag�n con un codigo,
	 * para usarlo en el movimiento del drag�n
	 * @param codigo del drag�n que se va a buscar
	 * @return El drag�n encontrado
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
	 * M�todo para eliminar un drag�n cuando llegue al final o
	 * cuando el jugador lo atrape
	 * @param drag Drag�n que se va a eliminar
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
	 * M�todo para comprobar si existe un dragon en esa posici�n
	 * @param x Posici�n X donde el jugador hizo click
	 * @param y Posici�n Y donde el jugador hizo click
	 * @return El drag�n encontrado
	 * @throws DragonInexistenteException 
	 */	
	public Dragon buscarDragon(int x, int y) throws DragonInexistenteException {
		if (primerDragon == null) {
			throw new DragonInexistenteException();
		}
		else if (primerDragon.getArea().contains(x,y)) {
			return primerDragon;
		}
		else {
			return buscarDragon(primerDragon.getSiguiente(), x, y);
		}		
	}
	/**
	 * M�todo recursivo para buscar un drag�n
	 * @param drag El drag�n que se usar� para avanzar en la recusividad
	 * @param x Posici�n X donde el jugador hizo click
	 * @param y Posici�n Y donde el jugador hizo click
	 * @return El drag�n encontrado
	 */
	public Dragon buscarDragon(Dragon drag, int x, int y) {
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
	 * M�todo llamado al hacer click en el panel para capturar un drag�n
	 * Busca si existe un drag�n en las posiciones x y y donde hizo click, 
	 * si existe aumenta el puntaje.
	 * @param x Posici�n X donde el jugador hizo click
	 * @param y Posici�n Y donde el jugador hizo click
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
	 * M�todo para crear un drag�n de acuerdo al nivel en el que se encuentre.
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
	 * Verifica si el drag�n est� vivo y si el jugador a�n tiene munici�n.
	 * Si se cumple la condicion, el drag�n se va.
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
	 * M�todo para cambiar de nivel.
	 * Cambia de nivel cuando atrapa 5 dragones.
	 */
	public void cambioDeNivel() {
		setNivel();
		jugadorActual.setNivel();
		jugadorActual.setDragonesAtrapados(0);
		crearDragon();
	}
	/**
	 * Permite la serializaci�n de los jugadores.
	 * Guarda el �rbol de jugadores, arrayList datos y �rbol podio en diferentes archivos.
	 */
	public void guardarPartida() {
		agregarJugador(jugadorActual.getNombre(), jugadorActual.getPuntaje());
		datos.add(jugadorActual);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("archivos/datosArbol"));
			out.writeObject(jugadorRaiz);
			out.close();
			ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("archivos/datosLista"));
			out2.writeObject(datos);
			out2.close();
			ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream("archivos/datosPodio"));
			out3.writeObject(raizPodio);
			out3.close();
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Permite cargar una partida seg�n sea el nombre indicado como par�metro.
	 * @param nombreJugador El jugador cuya partida quiere ser cargada.
	 */
	public void cargarUnaPartida(String nombreJugador) {
		try {
			Jugador j = buscarJugadorXNombre(nombreJugador);
			jugadorActual = j;
			nivel = jugadorActual.getNivel();
		}
		catch (JugadorInexistenteException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/**
	 * Permite recuperar la informaci�n guardada anteriormente. (Persistencia)
	 * Recupera cada archivo separado y los atributos son inicializados nuevamente.
	 */
	public void cargarDatos() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("archivos/datosArbol"));
			jugadorRaiz = (Jugador)in.readObject();
			in.close();
			ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("archivos/datosLista"));
			datos = (ArrayList<Jugador>)in2.readObject();
			in2.close();
			ObjectInputStream in3 = new ObjectInputStream(new FileInputStream("archivos/datosPodio"));
			raizPodio = (Jugador)in3.readObject();
			in3.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Implementaci�n propia de un algoritmo de b�squeda binaria.
	 * @param nombreJugador Criterio de b�squeda por nombre.
	 * @return El jugador buscado.
	 * @throws JugadorInexistenteException en caso de que el jugador por ese nombre no exista.
	 */
	public Jugador buscarJugadorXNombre(String nombreJugador) throws JugadorInexistenteException{
		ordenarXNombre();
		Jugador buscado = new Jugador(nombreJugador, 0);
		int inicio = 0;
		int medio = 0;
		int fin = datos.size()-1;
		boolean salir = false;
		
		while (inicio<=fin && !salir) {
			medio = (inicio + fin)/2;
			if(buscado.compare(buscado, datos.get(medio))==1) {
				inicio = medio+1;
			}
			else {
				fin = medio-1;
			}
			if(buscado.compare(buscado, datos.get(medio))==0) {
				buscado = datos.get(medio);
				salir = true;
			}
		}
		if(!salir) {
			JugadorInexistenteException e = new JugadorInexistenteException("No existe jugador llamado: ", nombreJugador);
			throw e;
		}
		return buscado;
	}

	/**
	 * Implementaci�n propia de un algoritmo de b�squeda binaria.
	 * @param puntaje Criterio de b�squeda por puntaje.
	 * @return El jugador buscado.
	 * @throws JugadorInexistenteException en caso de que el jugador por ese nombre no exista.
	 */
	public Jugador buscarJugadorXPuntaje(int puntaje) throws JugadorInexistenteException{
		Jugador jugadorBuscado = null;
		ordenarXPuntaje();
		int inicio = 0;
		int medio = 0;
		int fin = datos.size()-1;
		boolean salir = false;
		
		while (inicio<=fin && !salir) {
			medio = (inicio + fin)/2;
			if(puntaje > datos.get(medio).getPuntaje()) {
				inicio = medio+1;
			}
			else {
				fin = medio-1;
			}
			if(datos.get(medio).getPuntaje() == puntaje) {
				jugadorBuscado = datos.get(medio);
				salir = true;
			}
		}
		if(!salir) {
			JugadorInexistenteException e = new JugadorInexistenteException("El jugador con el puntaje indicado no existe.", "");
			throw e;
		}		
		return jugadorBuscado;
	}
	/**
	 * Permite elegir aleatoriamente el algoritmo de ordenamiento por el cual se va a ordenar la lista de jugadores por nombres.
	 */
	public void ordenarXNombre() {
		int random = (int) Math.random() * 3 + 1;
		if(random==1) {
			ordenarXNombreBurbuja();
		}
		else if(random==2) {
			ordenarXNombreInsercion();
		}
		else if(random==3) {
			ordenarXNombreSeleccion();
		}
	}
	/**
	 * Permite elegir aleatoriamente el algoritmo de ordenamiento por el cual se va a ordenar la lista de jugadores por puntajes.
	 */
	public void ordenarXPuntaje() {
		int random = (int) Math.random() * 3 + 1;
		if(random==1) {
			ordenarXPuntajeBurbuja();
		}
		else if(random==2) {
			ordenarXPuntajeInsercion();
		}
		else if(random==3) {
			ordenarXPuntajeSeleccion();
		}
	}
	/**
	 * Permite ordenar la lista por el algoritmo de ordenamiento Burbuja con el nombre del jugador como criterio.
	 */
	public void ordenarXNombreBurbuja() {
		for (int i = datos.size(); i > 0; i-- ) {
			for (int j=0; j<i-1; j++) {
				if(	datos.get(j).compare(datos.get(j), datos.get(j+1)) == (-1)) {
					Jugador tmp = datos.get(j);
					datos.set(j, datos.get(j+1));
					datos.set((j+1), tmp);
				}
			}
		}
	}
	/**
	 * Permite ordenar la lista por el algoritmo de ordenamiento Insercion con el nombre del jugador como criterio.
	 */
	public void ordenarXNombreInsercion() {
		for (int i = 1; i < datos.size(); i++) {
			for (int j = i; j>0 && ((datos.get(j).compare(datos.get(j), datos.get(j-1)))==(-1)); j--) {
				Jugador temp = datos.get(j);
				
				datos.set(j, datos.get(j-1));
				datos.set(j-1, temp);
			}
		}
	}
	/**
	 * Permite ordenar la lista por el algoritmo de ordenamiento Seleccion con el nombre del jugador como criterio.
	 */
	public void ordenarXNombreSeleccion() {
		for (int i = 0; i < datos.size()-1; i++) {
			Jugador menor = datos.get(i);
			int cual = i;
			for (int j = i + 1; j < datos.size(); j++) {
				if((datos.get(j).compare(datos.get(j), menor))==(-1)) {
					menor = datos.get(i);
					cual = j;
				}
			}
			Jugador temp = datos.get(i);
			datos.set(i, menor);
			datos.set(cual, temp);
		}
	}
	/**
	 * Permite ordenar la lista por el algoritmo de ordenamiento Burbuja con el puntaje del jugador como criterio.
	 */
	public void ordenarXPuntajeBurbuja() {
		for (int i = datos.size(); i > 0; i-- ) {
			for (int j=0; j<i-1; j++) {
				if (datos.get(j).getPuntaje() < datos.get(j+1).getPuntaje()) {
					Jugador tmp = datos.get(j);
					datos.set(j, datos.get(j+1));
					datos.set((j+1), tmp);
				}
			}
		}
	}
	/**
	 * Permite ordenar la lista por el algoritmo de ordenamiento Insercion con el puntaje del jugador como criterio.
	 */
	public void ordenarXPuntajeInsercion() {
		
	}
	/**
	 * Permite ordenar la lista por el algoritmo de ordenamiento Seleccion con el puntaje del jugador como criterio.
	 */
	public void ordenarXPuntajeSeleccion() {
		for (int i = 0; i < datos.size()-1; i++) {
			Jugador menor = datos.get(i);
			int cual = i;
			for (int j = i + 1; j < datos.size(); j++  ) {
				if(datos.get(j).compareTo(menor)<0) {
					menor = datos.get(i);
					cual = j;
				}
			}
			Jugador temp = datos.get(i);
			datos.set(i, menor);
			datos.set(cual, temp);
		}
	}
	
}