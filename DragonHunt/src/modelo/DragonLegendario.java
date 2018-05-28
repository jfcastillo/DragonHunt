package modelo;

public class DragonLegendario extends Dragon{
	public static int VALOR_PUNTAJE = 20;

	public DragonLegendario(int codigo, String rutaImagen, boolean moviendoDerecha) {
		super(codigo, rutaImagen, moviendoDerecha);
	}
	public void mover() {
		// Arriba a la derecha
		if (isMoviendoArriba() && isMoviendoDerecha()) {
			moverArribaDerecha();
			if (getPosicionX() == 850) {
				setRutaImagen("img/dragon_normal1.gif");
				setMoviendoDerecha(false);
			} else if (getPosicionY() == 0) {
				setRutaImagen("img/dragon_normal.gif");
				setMoviendoArriba(false);
			}

		}
		// Abajo a la derecha
		else if (isMoviendoArriba() == false && isMoviendoDerecha()) {
			moverAbajoDerecha();
			if (getPosicionX() == 850) {
				setRutaImagen("img/dragon_normal1.gif");
				setMoviendoDerecha(false);
			} else if (getPosicionY() == 550) {
				setMoviendoArriba(true);
			}
		}
		// Arriba izquierda
		else if (isMoviendoArriba() && isMoviendoDerecha() == false) {
			moverArribaIzquierda();
			if (getPosicionY() == 0) {
				setMoviendoArriba(false);
			} else if (getPosicionX() == 0) {
				setMoviendoDerecha(true);
				setRutaImagen("img/dragon_normal.gif");
			}
		}
		// Abajo izquierda
		else {
			moverAbajoIzquierda();
			if (getPosicionY() == 550) {
				setMoviendoArriba(true);
			} else if (getPosicionX() == 0) {
				setMoviendoDerecha(true);
				setRutaImagen("img/dragon_normal.gif");
			}

		}

	}

	public void moverArribaDerecha() {
		setPosicionX(1);
		setPosicionY(1);
		setArea(getPosicionX(), getPosicionY());
	}

	public void moverArribaIzquierda() {
		setPosicionX(-1);
		setPosicionY(1);
		setArea(getPosicionX(), getPosicionY());
	}

	public void moverAbajoDerecha() {
		setPosicionX(1);
		setPosicionY(-1);
		setArea(getPosicionX(), getPosicionY());
	}

	public void moverAbajoIzquierda() {
		setPosicionX(-1);
		setPosicionY(-1);
		setArea(getPosicionX(), getPosicionY());
	}

}
