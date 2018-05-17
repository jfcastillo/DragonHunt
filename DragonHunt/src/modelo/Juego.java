package modelo;



public class Juego {
	/**
	 * Nivel en el que se encuentra el juego
	 */
	private int nivel;
	/**
	 * Primer jugador del arbol de jugadores
	 */
	private Jugador raiz;
	/**
	 * Primer dragón de la lista
	 */
	private Dragon primerDragon;
	/**
	 * Último dragón de la lista
	 */
	private Dragon ultimoDragon;
	/**
	 * Constructor
	 * Crea un nuevo juego e inicializa los dragones	
	 */
	public Juego () {
		DragonNormal normal = new DragonNormal(1, "img/dragon_normal.gif");
		DragonSuperior superior = new DragonSuperior(2, "img/dragon_superior.gif");
		DragonLegendario legendario = new DragonLegendario(3, "img/dragon_legendario.gif");
		agregarDragon(normal);
		agregarDragon(superior);
		agregarDragon(legendario);
		
	}
	
	
	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public Jugador getRaiz() {
		return raiz;
	}


	public void setRaiz(Jugador raiz) {
		this.raiz = raiz;
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

	public void agregarJugador(String nombre, int puntaje) {
		Jugador nuevo = new Jugador(nombre, puntaje);
		
		if(raiz==null) {
			raiz = nuevo;
		} 
		else {
			Jugador auxiliar = raiz;
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
	
	private void imprimirEntre (Jugador reco)
    {
        if (reco != null)
        {    
            imprimirEntre (reco.getIzq());
            System.out.print(reco.getPuntaje() + " ");
            imprimirEntre (reco.getDer());
        }
    }
    public void imprimirEntre ()
    {
        imprimirEntre (raiz);
        System.out.println();
    }
	/**
	 * Método para agregar un nuevo dragón a la lista
	 * @param drag Es el dragon que se va a agregar
	 */
	public void agregarDragon(Dragon drag) {
		Dragon actual = primerDragon;
		if (actual == null) {
			primerDragon = drag;
			ultimoDragon = drag;
			primerDragon.setAnterior(ultimoDragon);
			primerDragon.setSiguiente(ultimoDragon);			
		}
		else {
			actual = ultimoDragon;
			actual.setSiguiente(drag);
			actual.getSiguiente().setAnterior(actual);
			ultimoDragon = drag;
			primerDragon.setAnterior(ultimoDragon);
			actual.getSiguiente().setSiguiente(primerDragon);
			
		}
		
	}
	
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
	
	
	public Dragon darDragonAleatorio() {		
		int codeRamdon = (int) (Math.random()*3)+1;
		return buscarDragonCodigo(codeRamdon);
	}

}
