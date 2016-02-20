import javax.swing.JOptionPane;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum;
		String num = "1";
		
		for(int i=1; i<10000; i++) {
			sum = 0;
			
			for(int j=1; j<i; j++) {
				if(i%j == 0) {
					sum += j;
				}
			}
			
			if (sum == i) 
				num += ", " + i;
		}
		
		JOptionPane.showMessageDialog(null, num);
	}
}
