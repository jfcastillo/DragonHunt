package modelo;

public class JugadorInexistenteException extends Exception{
	private String nombreJugador;

	public JugadorInexistenteException(String message, String nombreJugador) {		
		super(message);
		this.nombreJugador = nombreJugador;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	
}
