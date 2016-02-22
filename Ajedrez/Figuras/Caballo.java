public class Caballo extends Pieza {
	
	private final String BLANCA = "img/caballob.png";
	private final String NEGRA= "img/caballon.png";

	public Caballo(Jugador color, Posicion pos, Tablero tablero) {
		// TODO Auto-generated constructor stub
		super(color, pos, tablero);
	}
	
	public Caballo(Tablero tablero, Pieza p) {
		
		super(tablero, p);
	}
	
	public String getColorPiezaRuta() {
		
		if(colorPieza == Jugador.BLANCO)
			return BLANCA;
		
		else
			return NEGRA;
	}

	@Override
	protected void addTodosPosMov() {
		// TODO Auto-generated method stub
		posicion.clear();
        
        //1 norte, 2 oeste:
       Posicion pos = new Posicion(posicionActual.getFilas() + 1, posicionActual.getColumnas() - 2);
       comprobarEncontrado(pos);

       //1 norte, 2 este:
       pos = new Posicion(posicionActual.getFilas() + 1, posicionActual.getColumnas() + 2);
       comprobarEncontrado(pos);

       //2 norte, 1 oeste:
       pos = new Posicion(posicionActual.getFilas() + 2, posicionActual.getColumnas() - 1);
       comprobarEncontrado(pos);

       //2 norte, 1 este:
       pos = new Posicion(posicionActual.getFilas() + 2, posicionActual.getColumnas() + 1);
       comprobarEncontrado(pos);

       //1 sur, 2 oeste:
       pos = new Posicion(posicionActual.getFilas() - 1, posicionActual.getColumnas() - 2);
       comprobarEncontrado(pos);
       
       //1 sur, 2 este:
       pos = new Posicion(posicionActual.getFilas() - 1, posicionActual.getColumnas() + 2);
       comprobarEncontrado(pos);
       
       //2 sur, 1 oeste:
       pos = new Posicion(posicionActual.getFilas() - 2, posicionActual.getColumnas() - 1);
       comprobarEncontrado(pos);
       
       //2 sur, 1 este:
       pos = new Posicion(posicionActual.getFilas() - 2, posicionActual.getColumnas() + 1);
       comprobarEncontrado(pos);
	}
	
	private void comprobarEncontrado(Posicion pos) {
		
		if(tablero.contieneEnemigos(posicionActual, pos)) {
			
			addMovimiento(pos);
			return;
		}
		
		if(tablero.isPosicionVacia(pos))
			addMovimiento(pos);
	}
}
