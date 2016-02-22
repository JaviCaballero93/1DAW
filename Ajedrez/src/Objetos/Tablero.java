package objetos;

import java.util.*;
import objetos.*;
import piezas.*;

public class Tablero {
	
	private Pieza piezas[][];
	private Posicion posReyB;
	private Posicion posReyN;
	private ArrayList<Pieza> piezasBlancas;
	private ArrayList<Pieza> piezasNegras;

	public Tablero() {
		// TODO Auto-generated constructor stub
	}
	
	protected void setPiezas(Pieza pieza[][]){
        	
        	this.piezas = pieza;
	}
	    
	protected void setPiezasBlancas(ArrayList<Pieza> piezaB){
	        
	        this.piezasBlancas = piezaB;
	}
	    
	protected void setPiezasNegras(ArrayList<Pieza> piezaN){
	     	
	     	this.piezasNegras = piezaN;
	}
	
	protected void setPosicionRey(Posicion blanco, Posicion negro) {
	    	
	    	posReyB = blanco;
	    	posReyN = negro;
	}
	    
	protected Pieza[][] getPiezas() {
	    	
	    	return piezas;
	}
	    
	public ArrayList<Pieza>getListaPiezas() {
	    	
	    	ArrayList<Pieza> todas = getListaPiezas(Jugador.BLANCO);
	    	
	    	todas.addAll(getListaPiezas(Jugador.NEGRO));
	    	
	    	return todas;
	}
	    
	public ArrayList<Pieza>getListaPiezas(Jugador j) {
	    	
	    	ArrayList<Pieza>listaPiezas = new ArrayList<Pieza>();
	    	
	    	for(int i=0; i<8; i++) {
	    		for(int k=0; k<8; k++) {
	    			if(piezas[i][k] != null && piezas[i][k].getColorPieza() == j)
	    				listaPiezas.add(piezas[i][k]);
	    		}
	    	}
	    	
		return listaPiezas;
	}
	    
	public Pieza getPieza(Posicion pos) {
	    	
	    	return piezas[pos.getFilas()][pos.getColumnas()];
	}
	    
	public ArrayList<Movimiento>getMovimientosLegalesDe(Posicion pos) {
	    	
	    	ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
	    	
	    	if(isFueraLimites(pos))
	    		return movimientos;
	    	
	    	Pieza pieza = piezas[pos.getFilas()][pos.getColumnas()];
	    	
	    	if(pieza == null)
	    		return movimientos;
	    	
	    	for(Movimiento movimiento: pieza.getMovimientos()) {
			if(!movimientoEnJaque(movimiento))
				movimientos.add(movimiento);    			
	    	}
	    	
	    	return movimientos;
	}
	    
	public ArrayList<Movimiento> getMovimientoLegal(Pieza pieza){
	       
	    	ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
	        
	        if(pieza == null)
			return movimientos;
	        
	        for(Movimiento movimiento : pieza.getMovimientos()){
			if(!movimientoEnJaque(movimiento))
				movimientos.add(movimiento);
	        }
	        
	        return movimientos;
	}
	    
	public ArrayList<Movimiento> getMovimientoLegal(Jugador jugador){
	        
	    	ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
	        
	        for(Pieza pieza: getListaPiezas(jugador)) 
			movimientos.addAll(getMovimientoLegal(pieza));
	       
	        return movimientos;
	}
	    
	public void actualizarMovimiento(Movimiento movimiento) {
	    	
	        Pieza piezaMovida = piezas[movimiento.getPosicionInicial().getFilas()][movimiento.getPosicionInicial().getColumnas()];
	        piezaMovida.actualizarPos(movimiento.getPosicionFinal());
	        
	        piezas[movimiento.getPosicionInicial().getFilas()][movimiento.getPosicionInicial().getColumnas()] = null;
	        
	        piezas[movimiento.getPosicionFinal().getFilas()][movimiento.getPosicionFinal().getColumnas()] = piezaMovida;
	        
	        if(piezaMovida instanceof Rey)
			actualizarPosRey(movimiento);
	        
	        if(piezaMovida instanceof Peon)
			comprobarMejoraPeon(movimiento);
	}
	    
	private void actualizarEnroque(Movimiento movimiento) {
	    	
	        int reyX = movimiento.getPosicionFinal().getFilas();
	        int reyY = movimiento.getPosicionFinal().getColumnas();
	        Pieza rey = piezas[reyX][reyY];
	        
	        int torreX = movimiento.getPosicionFinal().getFilas();
	        int torreY = movimiento.getPosicionFinal().getColumnas();
	        Pieza torre = piezas[torreX][torreY];
	        
	        piezas[reyX][reyY] = null;
	        piezas[torreX][torreY] = null;
	        
	        if(torreY > reyY) {
			Posicion reyPos = new Posicion(reyX, reyY-2);
			rey.actualizarPos(reyPos);
	        }
	}
	    
	private void comprobarMejoraPeon(Movimiento movimiento){
	        
	    	int filas = movimiento.getPosicionFinal().getFilas();
	        
	    	if(filas == 7 || filas == 0) {
			Jugador colorPieza = movimiento.getPiezaMovida().getColorPieza();
			Reina reina = new Reina(colorPieza, movimiento.getPosicionFinal(), this);
			int columna = movimiento.getPosicionFinal().getColumnas();
	            
			piezas[filas][columna] = reina;
			movimiento.setPiezaMovida(reina);
	        }
	}
	    
	private void actualizarPosRey(Movimiento movimiento) {
	    	
	        Pieza pieza = movimiento.getPiezaMovida();
	        
	        if(pieza.getColorPieza() == Jugador.BLANCO)
			posReyB = movimiento.getPosicionFinal();
	        
	        else 
			posReyN = movimiento.getPosicionFinal();
	}
	    
	public boolean contieneEnemigos(Posicion posicionInicial, Posicion posicionFinal) {
	        
	    	if(isFueraLimites(posicionFinal))
			return false;
	        
	        if(isPosicionVacia(posicionFinal))
			return false;
	        
	        Jugador movingPieceColor = piezas[posicionInicial.getFilas()][posicionInicial.getColumnas()].getColorPieza();
	        Jugador receivingPieceColor = piezas[posicionFinal.getFilas()][posicionFinal.getColumnas()].getColorPieza();
	        
	        return (movingPieceColor != receivingPieceColor);
	}
	    
	public boolean isPosicionVacia(Posicion posicionFinal) {
	    	
	        if(isFueraLimites(posicionFinal))
			return false;
	        
	        return (piezas[posicionFinal.getFilas()][posicionFinal.getColumnas()] == null);
	}
	    
	public boolean isFueraLimites(Posicion posicionFinal) {
	    	
	        return posicionFinal.getFilas() >= 8 || posicionFinal.getFilas() <0
	                || posicionFinal.getColumnas() >= 8 || posicionFinal.getColumnas() <0;
	}
	    
	public boolean isEnJaque(Jugador jugador) {
	    	
	        Posicion posRey = posicionRey(jugador);
	        Jugador opponent = Motor.cambiarJugador(jugador);
	        ArrayList<Pieza> listaPieza = getListaPiezas(opponent);
	        
	        for(Pieza pieza: listaPieza) {
			for(Movimiento movimiento: pieza.getMovimientos()) {
				if(movimiento.getPosicionFinal().equals(posRey))
					return true;
			}
	        }
	        
	        return false;
	}
	    
	public Posicion posicionRey(Jugador jugador) {
	        
	    	if(jugador == Jugador.BLANCO)
			return posReyB;
	        
	        else
			return posReyN;
	}
	    
	public boolean isTorreInmovil(Posicion pos) {
	    	
	        Pieza pieza = piezas[pos.getFilas()][pos.getColumnas()];
	        
	        if(!(pieza instanceof Torre))
			return false;
	        
	        Torre torre = (Torre) pieza;
	        
	        if(torre.isMovida())
			return false;
	        
	        return true;
	}
	    
	public boolean movimientoEnJaque(Movimiento movimiento) {
	    	
	        Jugador jugador = movimiento.getPiezaMovida().getColorPieza();
	        Tablero nuevoTablero = ConstruirTablero.copiar(this);
	        
	        nuevoTablero.actualizarMovimiento(movimiento);
	        
	        if(nuevoTablero.isEnJaque(jugador))
			return true;
	        
	        return false;
	}
	    
	public boolean isMovimientoValido(Movimiento movimiento){
	        
	    	if(!isMovimientoValidoAislado(movimiento))
			return false;
	        
	        if(movimientoEnJaque(movimiento))
			return false;
	        
	        return true;
	}
	    
	private boolean isMovimientoValidoAislado(Movimiento movimiento){
	        
	    	Pieza pieza = movimiento.getPiezaMovida();
	        Posicion candidate = movimiento.getPosicionFinal();
	        
	        for(Movimiento mov : pieza.getMovimientos()){
	            
	        	Posicion posicionFinal = mov.getPosicionFinal();
	            
	        	if(candidate.equals(posicionFinal))
				return true;
	        }
	        
	        return false;
	}
}
