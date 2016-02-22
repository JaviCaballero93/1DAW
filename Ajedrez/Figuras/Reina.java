package figuras;

import objetos.*;
import java.util.ArrayList;

public class Reina extends Pieza {
	
	private final String BLANCA = "img/reinab.png";
	private final String NEGRA = "img/reinan.png";

	public Reina(Jugador color, Posicion pos,Tablero tablero) {
		// TODO Auto-generated constructor stub
		super(color, pos, tablero);
	}
	
	public Reina(Tablero tablero, Pieza p) {
		
		super(tablero, p);
	}
	
	public String getColorPiezaRuta() {
		
		if(colorPieza == Jugador.BLANCO)
			return BLANCA;
		
		else
			return NEGRA;
	}

	@Override
	public void addTodosPosMov() {
		// TODO Auto-generated method stub
		
		posicion.clear();
		
		Alfil alfil = new Alfil(colorPieza, posicionActual, tablero);
		Torre torre = new Torre(colorPieza, posicionActual, tablero);
		
		ArrayList<Movimiento> alfilMov = alfil.getMovimientos();
		ArrayList<Movimiento> torreMov = torre.getMovimientos();
		
		alfilMov.addAll(torreMov);
		
		for(Movimiento mov : alfilMov)
			addMovimiento(mov.getPosicionFinal());
	}
}
