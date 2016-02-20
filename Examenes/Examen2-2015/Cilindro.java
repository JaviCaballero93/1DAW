public class Cilindro extends Figura {
	
	private Punto punto;
	private int radio;
	private int altura;

	public Cilindro() {
		// TODO Auto-generated constructor stub
		this("Cilindro", new Punto(),20, 15);
	}
	
	public Cilindro(String nombre, Punto punto, int radio, int altura) {
		
		super(nombre);
		this.punto = punto;
		this.radio = radio;
		this.altura = altura;
	}
	
	public Punto getPunto() {
		
		return punto;
	}
	
	public int getRadio() {
		
		return radio;
	}
	
	public int getAltura() {
		
		return altura;
	}
	
	public double getArea() {
		
		double area;
		
		area = (radio * radio * Math.PI) + (2 * Math.PI * radio * altura);
		
		return area;
	}
	
	public double getVolumen() {
		
		double volumen;
		
		volumen = (Math.PI * Math.pow(radio, 2) * altura);
		
		return volumen;
	}
	
	public boolean equals(Cilindro c) {
		
		if(this.punto == c.getPunto()) {
			if(this.radio == c.getRadio()) {
				if(this.altura == c.getAltura())
					return true;
				
				else
					return false;
			}
			
			else
				return false;
		}
		
		else
			return false;
	}
}