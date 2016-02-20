import javax.swing.JOptionPane;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un n�mero para saber si es un n�mero perfecto o no."));
		
		if(perfectNumber(num))
			JOptionPane.showMessageDialog(null, "El n�mero " + num + " es un n�mero perfecto.");
		else
			JOptionPane.showMessageDialog(null, "El n�mero " + num + " NO es un n�mero perfecto.");
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