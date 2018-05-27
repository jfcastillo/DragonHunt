package modelo;

public class DragonNormal extends Dragon{

	public DragonNormal(int codigo, String rutaImagen, boolean moviendoDerecha) {
		super(codigo, rutaImagen, moviendoDerecha);
		
	}
	@Override
	public void mover() {
		movimientoAleatorio();
		if (isMoviendoDerecha()) {
			super.setPosicionY(1);
			super.setPosicionX(1);
			setArea(getPosicionX(), getPosicionY());
			if (getPosicionX() == 850) {
				setRutaImagen("img/dragon_normal1.gif");
				setMoviendoDerecha(false);
			}
		}
		else {
			super.setPosicionX(-1);
			super.setPosicionY(1);
			setArea(getPosicionX(), getPosicionY());
			if (getPosicionX() == 0) {
				setRutaImagen("img/dragon_normal.gif");
				setMoviendoDerecha(true);
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
