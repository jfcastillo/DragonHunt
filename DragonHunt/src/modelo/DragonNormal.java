package modelo;

public class DragonNormal extends Dragon{

	public DragonNormal(int codigo, String rutaImagen) {
		super(codigo, rutaImagen);
		
	}
	@Override
	public void mover() {
		super.setPosicionX(10);
		super.setPosicionY(10);
		
	}

}
