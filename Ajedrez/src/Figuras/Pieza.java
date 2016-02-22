public abstract class Pieza {
	
	protected ArrayList<Movimiento> posicion = new ArrayList<Movimiento>();
	protected Jugador colorPieza;
	protected Posicion posicionActual;
	protected Tablero tablero;

	public Pieza(Jugador color, Posicion posInicial, Tablero tablero) {
		// TODO Auto-generated constructor stub
		
		posicionActual = posInicial;
		colorPieza = color;
		this.tablero = tablero;
	}
	
	public Pieza(Tablero tablero, Pieza p) {
		
		colorPieza = p.getColorPieza();
		this.tablero = tablero;
		posicionActual = new Posicion(p.getPosicion());
	}
	
	abstract protected void addTodosPosMov();
	
	public Jugador getColorPieza() {
		
		return colorPieza;
	}
	
	public Posicion getPosicion() {
		
		return posicionActual;
	}
	
	public void actualizarPos(Posicion pos) {
		
		this.posicionActual = pos;
	}
	
	public void addMovimiento(Posicion destino) {
		
		Movimiento movimiento = new Movimiento(posicionActual, destino, this);
		posicion.add(movimiento);
	}
	
	public ArrayList<Movimiento> getMovimientos() {
		
		addTodosPosMov();
		return posicion;
	}
}
