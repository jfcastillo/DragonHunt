package modelo;

public class DragonNormal extends Dragon{

	public DragonNormal(int codigo, String rutaImagen, boolean moviendoDerecha) {
		super(codigo, rutaImagen, moviendoDerecha);
		
	}
	@Override
//	public void mover() {
////		movimientoAleatorio();
//		if (isMoviendoDerecha()) {
//			super.setPosicionY(1);
//			super.setPosicionX(2);
//			setArea(getPosicionX(), getPosicionY());
//			if (getPosicionX() == 850) {
//				setRutaImagen("img/dragon_normal1.gif");
//				setMoviendoDerecha(false);
//			}
//		}
//		else {
//			super.setPosicionX(-1);
//			super.setPosicionY(1);
//			setArea(getPosicionX(), getPosicionY());
//			if (getPosicionX() == 0) {
//				setRutaImagen("img/dragon_normal.gif");
//				setMoviendoDerecha(true);
//			}
//		}		
//	}
	public void mover() {
		//Arriba a la derecha
		if (isMoviendoArriba() && isMoviendoDerecha()) {
			moverArribaDerecha();
			if (getPosicionX() == 850) {
				setRutaImagen("img/dragon_normal1.gif");
				setMoviendoDerecha(false);
			}
			else if (getPosicionY() == 0) {
				setRutaImagen("img/dragon_normal.gif");
				setMoviendoArriba(false);
			}
			
		}
		//Abajo a la derecha
		else if(isMoviendoArriba() == false && isMoviendoDerecha()) {
			moverAbajoDerecha();
			if (getPosicionX() == 850) {
				setRutaImagen("img/dragon_normal1.gif");
				setMoviendoDerecha(false);
			}
			else if (getPosicionY() == 550) {
				setMoviendoArriba(true);
			}
		}
		//Arriba izquierda
		else if(isMoviendoArriba() && isMoviendoDerecha() == false) {
			moverArribaIzquierda();
			if (getPosicionY() == 0) {
				setMoviendoArriba(false);
			}
			else if (getPosicionX() == 0) {
				setMoviendoDerecha(true);
				setRutaImagen("img/dragon_normal.gif");
			}
		}
		//Abajo izquierda
		else {
			moverAbajoIzquierda();
			if (getPosicionY() == 550) {
				setMoviendoArriba(true);
			}
			else if (getPosicionX() == 0) {
				setMoviendoDerecha(true);
				setRutaImagen("img/dragon_normal.gif");
			}
			
		}
		
	}
	
	public void moviendoArriba() {
		if (isMoviendoArriba()) {
			super.setPosicionY(1);
			super.setPosicionX(2);
			setArea(getPosicionX(), getPosicionY());
			if (getPosicionY() == 150) {
				setMoviendoArriba(false);
				if (isMoviendoDerecha()) {
					setMoviendoDerecha(false);
				}
				else {
					setMoviendoDerecha(true);
				}
			}
		}
	}
	
	public void movimientoAleatorio() {
		int rangoMov = (1000 - 1) + 1;
		int random = (int) (Math.random() * rangoMov) + 1;
		if (random <= 800) {
			setMoviendoDerecha(true);
		}
		else {
			setMoviendoDerecha(false);
		}
	}

}
