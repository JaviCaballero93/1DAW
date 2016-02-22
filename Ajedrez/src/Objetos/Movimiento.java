package objetos;

import piezas.Pieza;

public class Movimiento {
	
	private Posicion posInicial;
	private Posicion posFinal;
	private Pieza piezaMovida;
	private boolean enroque;

	public Movimiento(Posicion posInicial, Posicion posFinal, Pieza piezaMovida) {
		// TODO Auto-generated constructor stub
		
		this.posInicial = posInicial;
		this.posFinal = posFinal;
		this.piezaMovida = piezaMovida;
	}
	
	public Movimiento(Posicion posInicial, Posicion posFinal) {
		
		this.posInicial = posInicial;
		this.posFinal = posFinal;
		enroque = true;
	}
	
	public Posicion getPosicionInicial() {
		
		return posInicial;
	}
	
	public Posicion getPosicionFinal() {
		
		return posFinal;
	}
	
	public Pieza getPiezaMovida() {
		
		return piezaMovida;
	}
	
	public void setPiezaMovida(Pieza p) {
		
		piezaMovida = p;
	}
	
	@Override
	public String toString() {
		
		String text = "";
		
		text += positionToString(posInicial) + "->" + positionToString(posFinal);
		
		return text;
	}
	
	private String positionToString(Posicion posicion) {
		
		String text = "";
		char letra = (char)(posicion.getColumnas() + 65);
		
		text += letra + "" + (posicion.getFilas() + 1);
		
		return text;
	}
}
