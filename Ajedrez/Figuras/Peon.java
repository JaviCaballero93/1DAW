package piezas;

import objetos.*;

public class Peon extends Pieza {
	
	private final String BLANCA = "img/peonb.png";
	private final String NEGRA = "img/peonn.png";

	public Peon(Jugador color, Posicion pos, Tablero tablero) {
		// TODO Auto-generated constructor stub
		super(color, pos, tablero);
	}
	
	public Peon(Tablero tablero, Pieza p) {
		
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
		
		if(colorPieza == Jugador.NEGRO) {
			
			avanzarNegras();
			atacarNegras();
		}
		
		else {
			
			avanzarBlancas();
			atacarBlancas();
		}
	}

	private void avanzarNegras() {
		
		Posicion pos = new Posicion(posicionActual.getFilas() - 1, posicionActual.getColumnas());
		
		if(tablero.isPosicionVacia(pos))
			addMovimiento(pos);
		
		else
			return;
		
		if(isPosicionInicial()) {
			
			pos = new Posicion(posicionActual.getFilas() - 2, posicionActual.getColumnas());
			
			if(tablero.isPosicionVacia(pos))
				addMovimiento(pos);
		}
	}
	
	private void avanzarBlancas() {
		
		Posicion pos = new Posicion(posicionActual.getFilas() + 1, posicionActual.getColumnas());
		
		if(tablero.isPosicionVacia(pos))
			addMovimiento(pos);
		
		else
			return;
		
		if(isPosicionInicial()) {
			
			pos = new Posicion(posicionActual.getFilas() + 2, posicionActual.getColumnas());
			
			if(tablero.isPosicionVacia(pos))
				addMovimiento(pos);
		}
	}
	
	private void atacarNegras() {
		
		Posicion pos = new Posicion(posicionActual.getFilas() - 1, posicionActual.getColumnas() - 1);
		
		if(tablero.contieneEnemigos(posicionActual, pos))
			addMovimiento(pos);
		
		pos = new Posicion(posicionActual.getFilas() - 1, posicionActual.getColumnas() + 1);
		
		if(tablero.contieneEnemigos(posicionActual, pos))
			addMovimiento(pos);
	}
	
	private void atacarBlancas() {
		
		Posicion pos = new Posicion(posicionActual.getFilas() + 1, posicionActual.getColumnas() - 1);
		
		if(tablero.contieneEnemigos(posicionActual, pos))
			addMovimiento(pos);
		
		pos = new Posicion(posicionActual.getFilas() + 1, posicionActual.getColumnas() + 1);
		
		if(tablero.contieneEnemigos(posicionActual, pos))
			addMovimiento(pos);
	}
	
	private boolean isPosicionInicial() {
		
		if(colorPieza == Jugador.NEGRO)
			return posicionActual.getFilas() == 6;
		
		else
			return posicionActual.getFilas() == 1;
	}
}