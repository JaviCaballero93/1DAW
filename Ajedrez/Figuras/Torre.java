package piezas;

import objetos.*;

public class Torre extends Pieza {

	private final String BLANCA = "img/torreb.png";
	private final String NEGRA= "img/torren.png";
	private boolean movida;
	
	public Torre(Jugador color, Posicion pos,Tablero tablero) {
		// TODO Auto-generated constructor stub
		super(color, pos, tablero);
	}
	
	public Torre(Tablero tablero, Pieza p) {
		
		super(tablero, p);
	}
	
	public String getColorPiezaRuta() {
		
		if(colorPieza == Jugador.BLANCO)
			return BLANCA;
		
		else
			return NEGRA;
	}
	
	public void actualizarPosicionActual(Posicion pos) {
		
		this.posicionActual = pos;
		movida = true;
	}
	
	public boolean isMovida() {
		
		return movida;
	}

	@Override
	protected void addTodosPosMov() {
		// TODO Auto-generated method stub
		posicion.clear();
		
		goNorte();
		goSur();
		goEste();
		goOeste();
	}
	
	private void goNorte() {
		
		int col = posicionActual.getColumnas();
		
        for (int i = posicionActual.getFilas() - 1; i >= 0; i--) {
            Posicion pos = new Posicion(i, col);
            
            if (tablero.isPosicionVacia(pos)) 
                addMovimiento(pos);
            
            else {
                comprobarEncontrado(pos);
                return;
            }
        }
	}
	
	private void goSur() {
		
		int col = posicionActual.getColumnas();
		
        for (int i = posicionActual.getFilas() + 1; i<8; i++) {
            Posicion pos = new Posicion(i, col);
            
            if (tablero.isPosicionVacia(pos)) 
                addMovimiento(pos);
            
            else {
                comprobarEncontrado(pos);
                return;
            }
        }
	}
	
	private void goEste() {
		
		int fil = posicionActual.getFilas();
		
        for (int i = posicionActual.getColumnas() + 1; i<8; i++) {
            Posicion pos = new Posicion(i, fil);
            
            if (tablero.isPosicionVacia(pos)) 
                addMovimiento(pos);
            
            else {
                comprobarEncontrado(pos);
                return;
            }
        }
	}
	
	private void goOeste() {
		
		int fil = posicionActual.getFilas();
		
        for (int i = posicionActual.getColumnas() - 1; i >= 0; i--) {
            Posicion pos = new Posicion(i, fil);
            
            if (tablero.isPosicionVacia(pos)) 
                addMovimiento(pos);
            
            else {
                comprobarEncontrado(pos);
                return;
            }
        }
	}
	
	private void comprobarEncontrado(Posicion pos) {
		
		if(tablero.contieneEnemigos(posicionActual, pos))
			addMovimiento(pos);
	}
}