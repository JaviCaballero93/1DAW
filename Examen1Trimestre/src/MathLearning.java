import java.util.Scanner;
import javax.swing.*;

public class MathLearning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		final int NUMBER_OF_DIGITS = 3;
    int right = 0;
       
    JOptionPane.showMessageDialog(null, "Math Learning: Subtraction");
      
    do {
    	int number1 = generateOperand(NUMBER_OF_DIGITS);
      int number2 = generateOperand(NUMBER_OF_DIGITS);
           
      if(number1 < number2) {
        int aux=number1;
        number1=number2;
        number2=aux;
      }
           
      int answer = Integer.parseInt(JOptionPane.showInputDialog(null,"How much is "+ number1 + " minus " + number2 + "?"));
           
      if (answer==number1-number2) {
        ++right;
        JOptionPane.showMessageDialog(null, "Good job:" + right + " right answers");
      }
           
      else
        JOptionPane.showMessageDialog(null, "Wrong position:" + findMistakenPosition(number1,number2,answer));
    }
       
    while (right < 5);
	}

	public static int findMistakenPosition(int n1,int n2,int a) {

		int[]solucion = getArray(n1 - n2);
		int[]solucionAlumno = getArray(a);
		int pos = 0;
		
		for(int i=0; i<solucion.length; i++) {
			
			if(solucion[i] != solucionAlumno[i]) {
				pos = i;
				return 0;
			}
		}
		
		return pos;
	}
	
	public static int[] getArray(int n) {
		
		int[]array = new int[3];
		int count = 0;
		
		for(int i=3; i>0; i--) {

			array[i-1] = n % 10;
			n /= 10;
		}
		
		return array;
	}
	
	public static int generateOperand(int n) {
		
		int number = 100 + (int)(Math.random() * (Math.pow(10, n) - 101));
		
		return number;
	}
}//fin de la clase
