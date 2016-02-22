package objetos;

import piezas.*;

public abstract class ConstruirTablero {

	public static Tablero construir() {
		
		Pieza piezas[][] = new Pieza[8][8];
		Tablero tablero = new Tablero();
		
		addPiezasBlancas(piezas, tablero);
		addPiezasNegras(piezas, tablero);
		
		tablero.setPiezas(piezas);
		tablero.setPosicionRey(new Posicion(0, 3), new Posicion(7, 3));
		
		return tablero;
	}
	
	public static Tablero copiar(Tablero tableroAntiguo) {
		
		Tablero tableroNuevo = new Tablero();
		Pieza piezas[][] = new Pieza[8][8];
		
		for(Pieza p : tableroAntiguo.getListaPiezas()) {
			piezas[p.getPosicion().getFilas()][p.getPosicion().getColumnas()] = piezaClonada(tableroNuevo, p);
		}
		
		tableroNuevo.setPiezas(piezas);
		tableroNuevo.setPosicionRey(tableroAntiguo.posicionRey(Jugador.BLANCO), tableroAntiguo.posicionRey(Jugador.NEGRO));
		
		return tableroNuevo;
	}

	private static Pieza piezaClonada(Tablero tablero, Pieza pieza) {
		
		if(pieza == null)
			return null;
		
		if(pieza instanceof Peon)
			return new Peon(tablero, pieza);
		
		if(pieza instanceof Torre)
			return new Torre(tablero, pieza);
		
		if(pieza instanceof Caballo)
			return new Caballo(tablero, pieza);
		
		if(pieza instanceof Alfil)
			return new Alfil(tablero, pieza);
		
		if(pieza instanceof Reina)
			return new Reina(tablero, pieza);
		
		if(pieza instanceof Rey)
			return new Rey(tablero, pieza);
		
		throw new IllegalStateException("Pieza de instancia no encontrada");
	}
	
	private static void addPiezasBlancas(Pieza[][]piezas, Tablero tablero) {
		
		Posicion pos = new Posicion(0, 0);
		piezas[0][0] = new Torre(Jugador.BLANCO, pos, tablero);
		
		pos = new Posicion(0, 1);
		piezas[0][1] = new Caballo(Jugador.BLANCO, pos, tablero);
		
		pos = new Posicion(0, 2);
		piezas[0][2] = new Alfil(Jugador.BLANCO, pos, tablero);
		
		pos = new Posicion(0, 3);
		piezas[0][3] = new Rey(Jugador.BLANCO, pos, tablero);
		
		pos = new Posicion(0, 4);
		piezas[0][4] = new Reina(Jugador.BLANCO, pos, tablero);
		
		pos = new Posicion(0, 5);
		piezas[0][5] = new Alfil(Jugador.BLANCO, pos, tablero);
		
		pos = new Posicion(0, 6);
		piezas[0][6] = new Caballo(Jugador.BLANCO, pos, tablero);
		
		pos = new Posicion(0, 7);
		piezas[0][7] = new Torre(Jugador.BLANCO, pos, tablero);
		
		for(int i=0; i<8; i++) {
			
			pos = new Posicion(1, i);
			piezas[1][i] = new Peon(Jugador.BLANCO, pos, tablero);
			
		}
	}
	
	private static void addPiezasNegras(Pieza[][]piezas, Tablero tablero) {
		
		Posicion pos = new Posicion(7, 0);
		piezas[7][0] = new Torre(Jugador.NEGRO, pos, tablero);
		
		pos = new Posicion(7, 1);
		piezas[7][1] = new Caballo(Jugador.NEGRO, pos, tablero);
		
		pos = new Posicion(7, 2);
		piezas[7][2] = new Alfil(Jugador.NEGRO, pos, tablero);
		
		pos = new Posicion(7, 3);
		piezas[7][3] = new Rey(Jugador.NEGRO, pos, tablero);
		
		pos = new Posicion(7, 4);
		piezas[7][4] = new Reina(Jugador.NEGRO, pos, tablero);
		
		pos = new Posicion(7, 5);
		piezas[7][5] = new Alfil(Jugador.NEGRO, pos, tablero);
		
		pos = new Posicion(7, 6);
		piezas[7][6] = new Caballo(Jugador.NEGRO, pos, tablero);
		
		pos = new Posicion(7, 7);
		piezas[7][7] = new Torre(Jugador.NEGRO, pos, tablero);
		
		for(int i=0; i<8; i++) {
			
			pos = new Posicion(6, i);
			piezas[6][i] = new Peon(Jugador.NEGRO, pos, tablero);
			
		}
	}
}
 