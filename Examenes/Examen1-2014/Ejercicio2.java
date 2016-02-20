import javax.swing.JOptionPane;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][]m1 = generarMatriz();
		int[][]m2 = generarMatriz();
		
		int[][]matrizResultado = multMatriz(m1, m2);
		
		String text = "Matriz 1\n" + print(m1) + "\nMatriz2\n" + print(m2) + "\nMatrizResultado\n" + print(matrizResultado);
		
		JOptionPane.showMessageDialog(null, text);
	}
	
	public static int[][]generarMatriz() {
		
		int filas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de filas que tendra la matriz."));
		int columnas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de columnas que tendra la matriz."));
		int[][]m = new int[filas][columnas];
		
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[i].length; j++) {
				m[i][j] = (int)(Math.random() * 9);
			}
		}
		
		return m;
	}
	
	public static boolean isMult(int[][]m1, int[][]m2) {
		
		if(m1[0].length == m2.length)
			return true;
		
		else
			return false;
	}
	
	public static int[][]multMatriz(int[][]m1, int[][]m2) {
		
		if(isMult(m1, m2)) {
			
			int[][]mult = new int[m1.length][m2[0].length];
			
			for(int i=0; i<m1.length; i++) {
				for(int j=0; j<m2[0].length; j++) {
					for(int k=0; k<m1[i].length; k++) {
						
						mult[i][j] += m1[i][k] * m2[k][j];
					}
				}
			}
			
			return mult;
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Lo sentimos, pero tus matrices no son multiplicables.");
			return null;
		}
	}
	
	public static String print(int[][]m) {
		
		String text = "";
		
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[i].length; j++) {
				text += m[i][j] + " | ";
			}
			
			text += "\n";
		}
		
		text += "----------------------";
		
		return text;
	}
}