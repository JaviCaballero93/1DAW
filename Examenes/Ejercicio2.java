import javax.swing.JOptionPane;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matriz = new int[3][3];
		
		JOptionPane.showMessageDialog(null, "El array va a ser de 3x3 de forma predeterminada. El usuario puede introducir los valores" + 
				" de los que dispondra el array para comprobar como se realiza el cambio.");
		
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[i].length; j++) {
				matriz[i][j]= Integer.parseInt(JOptionPane.showInputDialog("Introduce un valor para la posición " + i + j));
			}
		}
		
		//Antes del cambio
		printBidi(matriz);
		
		//Despues del cambio
		modificarArray(matriz);
		
		printBidi(matriz);
		
	}
	
	public static void modificarArray(int[][] array) {
		
		int[][] copy = new int[array.length][array[0].length];
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				
				copy[j][array[i].length-1-i]=array[i][j];
			}
		}
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				
				array[i][j] = copy[i][j];
			}
		}
	}
	
	public static void printBidi (int[][]m) {
		for (int i=0;i<m.length;i++) {
			for(int j=0; j<m[i].length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println(" ");
		}
		System.out.println("____________");
	}

}

