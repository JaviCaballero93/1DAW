public class Alfil extends Pieza {
	
	private final String BLANCA = "img/alfilb.png";
	private final String NEGRA = "img/alfiln.png";

	public Alfil(Jugador color, Posicion pos, Tablero tablero) {
		// TODO Auto-generated constructor stub
		super(color, pos, tablero);
	}
	
	public Alfil(Tablero tablero, Pieza p) {
		
		super(tablero, p);
	}

	@Override
	protected void addTodosPosMov() {
		// TODO Auto-generated method stub
		posicion.clear();
		
		compNorOeste();
		compNorEste();
		compSurOeste();
		compSurEste();
	}

	public String getColorPiezaRuta() {
		
		if(colorPieza == Jugador.BLANCO)
			return BLANCA;
		
		else
			return NEGRA;
	}
	
	private void compNorOeste() {
		
		int fil = posicionActual.getFilas() + 1;
		int col = posicionActual.getColumnas() - 1;
		
		while(fil<8 && col>=0) {
			
			Posicion pos = new Posicion(fil, col);
			
			if(!tablero.isPosicionVacia(pos)) {
				comprobarEncontrado(pos);
				return;
			}
			
			else
				addMovimiento(pos);
			
			fil++;
			col--;
		}
	}
	
	private void compNorEste() {
		
		int fil = posicionActual.getFilas() + 1;
		int col = posicionActual.getColumnas() + 1;
		
		while(fil<8 && col>=0) {
			
			Posicion pos = new Posicion(fil, col);
			
			if(!tablero.isPosicionVacia(pos)) {
				comprobarEncontrado(pos);
				return;
			}
			
			else
				addMovimiento(pos);
			
			fil++;
			col++;
		}
	}
	
	private void compSurOeste() {
		
		int fil = posicionActual.getFilas() - 1;
		int col = posicionActual.getColumnas() - 1;
		
		while(fil<8 && col>=0) {
			
			Posicion pos = new Posicion(fil, col);
			
			if(!tablero.isPosicionVacia(pos)) {
				comprobarEncontrado(pos);
				return;
			}
			
			else
				addMovimiento(pos);
			
			fil--;
			col--;
		}
	}
	
	private void compSurEste() {
		
		int fil = posicionActual.getFilas() - 1;
		int col = posicionActual.getColumnas() + 1;
		
		while(fil<8 && col>=0) {
			
			Posicion pos = new Posicion(fil, col);
			
			if(!tablero.isPosicionVacia(pos)) {
				comprobarEncontrado(pos);
				return;
			}
			
			else
				addMovimiento(pos);
			
			fil--;
			col++;
		}
	}
	
	private void comprobarEncontrado(Posicion pos) {
		
		if(tablero.contieneEnemigos(posicionActual, pos))
			addMovimiento(pos);
	}
}
