import javax.swing.JOptionPane;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número para saber si es un número perfecto o no."));
		
		if(perfectNumber(num))
			JOptionPane.showMessageDialog(null, "El número " + num + " es un número perfecto.");
		else
			JOptionPane.showMessageDialog(null, "El número " + num + " NO es un número perfecto.");
	}
	
	public static boolean perfectNumber(int num) {
		int sum = 0;
		
		for(int i=1; i<num; i++) {
			if(num%i == 0) {
				sum += i;
			}
		}
		
		if(num == sum)	
			return true;
		else
			return false;
		
	}

}