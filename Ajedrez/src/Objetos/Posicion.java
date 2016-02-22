package objetos;

public class Posicion {
	
	private int filas;
	private int columnas;

	public Posicion(int fil, int colum) {
		// TODO Auto-generated constructor stub
		
		this.filas = fil;
		this.columnas = colum;
	}
	
	public Posicion(Posicion c) {
		
		this.filas = c.filas;
		this.columnas = c.columnas;
	}
	
	public int getFilas() {
		
		return filas;
	}
	
	public int getColumnas() {
		
		return columnas;
	}
	
	public boolean equals(Posicion c) {
		
		if(this.filas == c.filas && this.columnas == c.columnas)
			return true;
		
		return false;
	}
}