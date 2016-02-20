package objects;

public class ComplexNumber {

	private double real;
	private double imaginario;
	
	public ComplexNumber(double real, double imaginario) {
		// TODO Auto-generated constructor stub
		this.real = real;
		this.imaginario = imaginario;
	}

	public double getReal() {
		
		return real;
	}
	
	public double getImaginario() {
		
		return imaginario;
	}
	
	public ComplexNumber add(ComplexNumber number) {
		
		return new ComplexNumber(this.real + number.getReal(), this.imaginario + number.getImaginario());
	}
	
	public ComplexNumber multiply(ComplexNumber number) {
		
		return new ComplexNumber(this.real * number.getReal() - this.imaginario * number.getImaginario() ,
				this.real * number.getImaginario() + this.imaginario * number.getReal());
	}
	
	public boolean equals(ComplexNumber number) {
		
		if(this.real == number.getReal() && this.imaginario == number.getImaginario())
			return true;
		
		return false;
	}
}
