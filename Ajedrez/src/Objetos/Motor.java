package objetos;

public class Motor {
	
	public static void main(String[] args) {
		
		Juego juego = new Juego();
		
		juego.empezarPartida();
	}

	public static Jugador cambiarJugador(Jugador jugador) {
		
		if(jugador == Jugador.BLANCO)
			return Jugador.NEGRO;
		
		else
			return Jugador.BLANCO;
	}

}
