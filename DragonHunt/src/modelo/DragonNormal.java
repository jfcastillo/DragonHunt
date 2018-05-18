package modelo;

public class DragonNormal extends Dragon{

	public DragonNormal(int codigo, String rutaImagen) {
		super(codigo, rutaImagen);
		
	}
	@Override
	public void mover() {
		if (isMoviendoDerecha()) {
			super.setPosicionY(1);
			super.setPosicionX(1);
			if (getPosicionX() == 850) {
				setRutaImagen("img/dragon_normal1.gif");
				setMoviendoDerecha(false);
			}
		}
		else {
			super.setPosicionX(-1);
			super.setPosicionY(1);
			if (getPosicionX() == 0) {
				setRutaImagen("img/dragon_normal.gif");
				setMoviendoDerecha(true);
			}
		}		
	}

}
