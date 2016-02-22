package piezas;

import objetos.*;

public class Rey extends Pieza {
	
	private final String BLANCA = "img/reyb.png";
	private final String NEGRA = "img/reyn.png";
	private boolean movida;

	public Rey(Jugador color, Posicion pos, Tablero tablero) {
		// TODO Auto-generated constructor stub
		super(color, pos, tablero);
	}
	
	public Rey(Tablero tablero, Pieza p) {
		
		super(tablero, p);
	}
	
	public void actualizarPosicionActual(Posicion pos) {
		
		this.posicionActual = pos;
		movida = true;
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
		
		Posicion pos = new Posicion(posicionActual.getFilas() + 1, posicionActual.getColumnas());
		verificarEspacio(pos);
		
		pos = new Posicion(posicionActual.getFilas() + 1, posicionActual.getColumnas() + 1);
		verificarEspacio(pos);
		
		pos = new Posicion(posicionActual.getFilas(), posicionActual.getColumnas() + 1);
		verificarEspacio(pos);
		
		pos = new Posicion(posicionActual.getFilas() - 1, posicionActual.getColumnas() + 1);
		verificarEspacio(pos);
		
		pos = new Posicion(posicionActual.getFilas() - 1, posicionActual.getColumnas());
		verificarEspacio(pos);
		
		pos = new Posicion(posicionActual.getFilas() - 1, posicionActual.getColumnas() - 1);
		verificarEspacio(pos);
		
		pos = new Posicion(posicionActual.getFilas(), posicionActual.getColumnas() - 1);
		verificarEspacio(pos);
		
		pos = new Posicion(posicionActual.getFilas() + 1, posicionActual.getColumnas() - 1);
		verificarEspacio(pos);
	}
	
	private void comprobarEnroque() {
		
		enroqueLadoReina();
		enroqueLadoRey();
	}
	
	private void enroqueLadoReina() {
		
		if(movida)
			return;
		
		for(int col=4; col<7; col++) {
			
			Posicion pos = new Posicion(posicionActual.getFilas(), col);
			
			if(!tablero.isPosicionVacia(pos))
				return;
		}
		
		Posicion torreLadoReina = new Posicion(posicionActual.getFilas(), 7);
		
		if(tablero.contieneEnemigos(posicionActual, torreLadoReina))
			return;
		
		if(!tablero.isTorreInmovil(torreLadoReina))
			return;
		
		addMovimiento(torreLadoReina);
	}
	
	private void enroqueLadoRey() {
		
		if(movida)
			return;
		
		for(int col=4; col>0; col++) {
			
			Posicion pos = new Posicion(posicionActual.getFilas(), col);
			
			if(!tablero.isPosicionVacia(pos))
				return;
		}
		
		Posicion torreLadoRey = new Posicion(posicionActual.getFilas(), 0);
		
		if(tablero.contieneEnemigos(posicionActual, torreLadoRey))
			return;
		
		if(!tablero.isTorreInmovil(torreLadoRey))
			return;
		
		addMovimiento(torreLadoRey);
	}
	
	private void verificarEspacio(Posicion pos) {
		
		if(tablero.contieneEnemigos(posicionActual, pos))
			addMovimiento(pos);
		
		else if(tablero.isPosicionVacia(pos))
			addMovimiento(pos);
	}
}
