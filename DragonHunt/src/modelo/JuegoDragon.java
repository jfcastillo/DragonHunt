package modelo;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
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
	 * Primer dragon de la lista
	 */
	private Dragon primerDragon;
	/**
	 * Ultimo dragon de la lista
	 */
	private Dragon ultimoDragon;
	
	//	CONSTRUCTOR
	/**
	 * Metodo constructor de la clase.
	 * Crea un nuevo juego e inicializa sus atributos.	
	 */
	public JuegoDragon() {
//		file = new File(arg0)
		jugadorActual = new Jugador("Felipe", 0);
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

	//	METODOS	
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel() {
		nivel += 1;
		if(nivel==1) {
			setFondoJuego("img/fondo_juego.jpg");
		}
		else if(nivel==2) {
			setFondoJuego("img/fondo_juego1.gif");
		}
		else if(nivel==3) {
			setFondoJuego("img/fondo_juego1.gif");
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

	public void setJugadorActual(String j) {
		Jugador a = new Jugador(j, jugadorActual.getPuntaje());
		this.jugadorActual = a;
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

	public Jugador getRaizPodio() {
		return raizPodio;
	}

	public void setRaizPodio(Jugador raiz) {
		this.raizPodio = raiz;
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
	
	public ArrayList<Jugador> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<Jugador> datos) {
		this.datos = datos;
	}

	//	MÉTODOS
		/**
	 * Método para agregar un nuevo jugador al árbol según su puntaje.
	 * @param nombre El nombre del nuevo jugador.
	 * @param puntaje El puntaje del nuevo jugador.
	 */
	public void agregarJugador(String nombre, int puntaje) {
		Jugador nuevo = new Jugador(nombre, puntaje);
		if (jugadorRaiz == null) {
			jugadorRaiz = nuevo;
		}
		else {
			agregarJugador(nombre, puntaje, jugadorRaiz);
		}
	}
	public void agregarJugador(String nombre, int puntaje, Jugador jug) {
		Jugador nuevo = new Jugador(nombre, puntaje);
		if(jugadorRaiz==null) {
			jugadorRaiz = nuevo;
		} 
		else {
			if (puntaje > jugadorRaiz.getPuntaje()) {
				if (jugadorRaiz.getDer() == null) {
					jugadorRaiz.setDer(nuevo);
				}
				else {
					agregarJugador(nombre, puntaje, jug.getDer());
				}
				
			}
//			if (puntaje < jugadorRaiz.getPuntaje()) {
			else {
				if (jugadorRaiz.getIzq() == null) {
					jugadorRaiz.setIzq(nuevo);
				}
				else {
					agregarJugador(nombre, puntaje, jug.getIzq());
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
	 * Método para recorrer la lista enlazada de dragones y buscar un dragón con un codigo,
	 * para usarlo en el movimiento del dragón
	 * @param codigo del dragón que se va a buscar
	 * @return El dragón encontrado
	 */
	public Dragon buscarDragonCodigo(int codigo)  {
		if (primerDragon == null) {
			return null;
		}
		else if (primerDragon.getCodigo() == codigo) {
			return primerDragon;
		}
		else {
			return buscarDragonCodigo(codigo, primerDragon.getSiguiente());
			
		}		
	}
	public Dragon buscarDragonCodigo(int codigo, Dragon drag) {
		if (drag == null || drag.equals(primerDragon)) {
			return null;
		}
		else {
			if (drag.getCodigo() == codigo) {
				return drag;				
			}
			else {
				return buscarDragonCodigo(codigo, drag.getSiguiente());
			}
		}
	}

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
	 * Método recursivo1 para buscar un dragón
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
			else if (nivel >= 2) {
				int codeRandom = (int) (Math.random()*3)+1;
				int randomMov = (int) (Math.random()*2)+1;
				if ( codeRandom == 1) {
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
				else if(codeRandom == 2) {
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
				else {
					if (randomMov == 1) {
						moviendoDerecha = true;
						ruta = "img/dragon_legendario.gif";
					}
					else {
						moviendoDerecha = false;
						ruta = "img/dragon_legendario1.gif";
					}
					DragonLegendario legendario = new DragonLegendario(numDragones, ruta, moviendoDerecha);
					agregarDragon(legendario);
				}
			}
		}
	}
	/**
	 * Verifica si el jugador perdió
	 * Pierde cuando la cantidad de dragones perdido es igual a 5.
	 * @return true si perdió o false si no.
	 */
	public boolean perdio() {
		return jugadorActual.getCantidadPerdidos() == 5;
	}
	
	/**
	 * Verifica si el dragón está vivo y si el jugador aún tiene munición.
	 * Si se cumple la condicion, el dragón se va.
	 * @param drag el dragon con el que se va a verificar
	 */
	public void verificarDragonHuida(Dragon drag) {
		if ((drag.isMuerto()==false) && (jugadorActual.verificarMunicion())) {
			drag.setSeFue(true);
			jugadorActual.setCantidadPerdidos(1);
		}
	}
	/**
	 * Método para cambiar de nivel.
	 * Cambia de nivel cuando atrapa 5 dragones.
	 */
	public void cambioDeNivel() {
		setNivel();
		jugadorActual.setNivel();
		jugadorActual.setDragonesAtrapados(0);
		crearDragon();
	}
	/**
	 * Permite la serialización de los jugadores.
	 * Guarda el árbol de jugadores, arrayList datos y árbol podio en diferentes archivos.
	 */
	public void guardarPartida() {
		agregarJugador(jugadorActual.getNombre(), jugadorActual.getPuntaje());
		datos.add(jugadorActual);
		actualizarPodio();
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
	 * Permite cargar una partida según sea el nombre indicado como parámetro.
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
	 * Permite recuperar la información guardada anteriormente. (Persistencia)
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
			guardarPartida();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Implementación propia de un algoritmo de búsqueda binaria.
	 * @param nombreJugador Criterio de búsqueda por nombre.
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
	 * Metodo para guardar el nombre del jugador y su puntaje en un archivo de texto.
	 */
	public void guardarPuntaje() {
		File archivo = new File("archivos/puntajes.txt");
		BufferedWriter bw;
		try {
			if (archivo.exists()) {
				FileWriter fw = new FileWriter(archivo, true);
				bw = new BufferedWriter(fw);
				bw.write("\r\n"+jugadorActual.getNombre()+"-"+jugadorActual.getPuntaje());				
			}
			else {
				FileWriter fw = new FileWriter(archivo, true);
				bw = new BufferedWriter(fw);
				bw.write(jugadorActual.getNombre()+"-"+jugadorActual.getPuntaje());
				
			}					
			bw.close();
			
		} catch (Exception e) {
		}
	}
	/**
	 * Metodo para cargar los puntajes almacenados en un archivo de texto.
	 * @return Un ArrayList con los nombre y los puntajes de los jugadores.
	 */
	public ArrayList<String> verPuntajes(){
		File archivo = new File("archivos/puntajes.txt");
		ArrayList<String> datos = new ArrayList<String>();		
		try {
			
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea = "";
			while ((linea = br.readLine()) != null) {
				datos.add(linea);				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datos;
	}

	/**
	 * Implementacion propia de un algoritmo de busqueda binaria.
	 * @param puntaje Criterio de búsqueda por puntaje.
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
				if(	datos.get(j).compare(datos.get(j), datos.get(j+1)) == (1)) {
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
			for (int j = i; j>0 && ( (datos.get(j-1).compare(datos.get(j-1), datos.get(j)))==(1) ); j--) {
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
					menor = datos.get(j);
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
				if (	(datos.get(j).getPuntaje()) > (datos.get(j+1).getPuntaje())	) {
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
		for (int i = 1; i < datos.size(); i++) {
			for (int j = i; j>0 && ( datos.get(j-1).getPuntaje() > datos.get(j).getPuntaje()); j--) {
				Jugador temp = datos.get(j);
				datos.set(j, datos.get(j-1));
				datos.set(j-1, temp);
			}
		}
	}
	/**
	 * Permite ordenar la lista por el algoritmo de ordenamiento Seleccion con el puntaje del jugador como criterio.
	 */
	public void ordenarXPuntajeSeleccion() {
		for (int i = 0; i < datos.size()-1; i++) {
			Jugador menor = datos.get(i);
			int cual = i;
			for (int j = i + 1; j < datos.size(); j++  ) {
				if(datos.get(j).compareTo(menor) < 0) {
					menor = datos.get(j);
					cual = j;
				}
			}
			Jugador temp = datos.get(i);
			datos.set(i, menor);
			datos.set(cual, temp);
		}
	}
	/**
	 * Permite actualizar el podio de mejores puntajes.
	 * Toma los tres ultimos jugadores, mejores puntajes y crea un arbol podio.
	 */
	public void actualizarPodio() {
		ordenarXPuntaje();
		int tam = datos.size();
		raizPodio = datos.get(tam-1);
		raizPodio.setIzq(datos.get(tam-2));
		raizPodio.setDer(datos.get(tam-3));
	}
	
	public String darInfoPodio() {
		actualizarPodio();
		String inf = "";
		inf += raizPodio.getNombre()+"_"+raizPodio.getPuntaje()+" ";
		inf += raizPodio.getIzq().getNombre()+"_"+raizPodio.getIzq().getPuntaje()+" ";
		inf += raizPodio.getDer().getNombre()+"_"+raizPodio.getDer().getPuntaje();
		return inf;
	}
}
