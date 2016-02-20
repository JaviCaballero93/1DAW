import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FiguraTest {
	
	private ArrayList<Figura>array;
	
	public FiguraTest() {
		
		array = new ArrayList<Figura>();
	}
	
	public void add(Figura f) {
		
		array.add(f);
	}
	
	public Figura get(int index) {
		
		return array.get(index);
	}
	
	public int length() {
		
		return array.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = null;
		FiguraTest test = new FiguraTest();
		test.add(new Punto());
		test.add(new Circulo());
		test.add(new Cilindro());
		
		for(int i=0; i<test.length(); i++) {
			if(test.get(i) instanceof Punto) {
				
				text += "Element number " + (i+1) + " is a Punto.\n";
				text += "Name: " + test.get(i).getNombre() + ".\n";
			}
			
			else if(test.get(i) instanceof Circulo) {
				
				Circulo circulo = (Circulo)test.get(i);
				text += "Element number " + (i+1) + " is a Circulo.\n";
				text += "Name: " + circulo.getNombre() + ".\n";
				text += "Area: " + circulo.getArea() + ".\n";
			}
			
			else {
				
				Cilindro cilindro = (Cilindro)test.get(i);
				text += "Element number " + (i+1) + " is a Cilindro.\n";
				text += "Name: " + cilindro.getNombre() + ".\n";
				text += "Area: " + cilindro.getArea() + ".\n";
				text += "Volumen: " + cilindro.getVolumen() + ".\n";
			}
		}
		
		JOptionPane.showMessageDialog(null, text);
	}
}