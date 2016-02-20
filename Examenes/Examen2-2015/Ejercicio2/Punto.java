public class Punto extends Figura {

	private int coordX;
	private int coordY;
	
	public Punto() {
		// TODO Auto-generated constructor stub
		this("Punto", 0, 0);
	}
	
	public Punto(String nombre, int coordX, int coordY) {
		
		super(nombre);
		this.coordX = coordX;
		this.coordY = coordY;		
	}
	
	public int getCoordX() {
		
		return coordX;
	}
	
	public int getCoordY() {
		
		return coordY;
	}
	
	public void setCoordX(int coordX) {
		
		this.coordX = coordX;
	}
	
	public void setCoordY(int coordY) {
		
		this.coordY = coordY;
	}
	
	public boolean equals(Punto p) {
		
		if(this.coordX == p.getCoordX()) {
			if(this.coordY == p.getCoordY())
				return true;
			
			else 
				return false;
		}
		
		else
			return false;
	}
}