public class Circulo extends Figura {
	
	private int radio;

	public Circulo() {
		// TODO Auto-generated constructor stub
		this("Circulo", 20);
	}
	
	public Circulo(String nombre, int radio) {
		
		super(nombre);
		this.radio = radio;
	}
	
	public int getRadio() {
		
		return radio;
	}
	
	public void setRadio(int radio) {
		
		this.radio = radio;
	}
	
	public double getArea() {
		
		return (radio * radio * Math.PI);
	}
	
	public boolean equals(Circulo c) {
		
		if(this.radio == c.getRadio())
			return true;
		
		else
			return false;
	}
}