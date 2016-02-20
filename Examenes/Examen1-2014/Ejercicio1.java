import javax.swing.JOptionPane;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int fil = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de filas que tendra la matriz."));
		int col = Integer.parseInt(JOptionPane.showInputDialog("Ahora el número de columnas que tendra la matriz."));
		
		int[][] matriz = new int[fil][col];
		
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[i].length; j++) {
				matriz[i][j]= Integer.parseInt(JOptionPane.showInputDialog("Introduce un valor para la posición" + i + j));
			}
		}
		
		JOptionPane.showMessageDialog(null, simetrica(matriz));
	}
	
	public static boolean simetrica(int[][] m) {
		
		int fil = m.length;
		int col = m[0].length;
		
		if (fil != col) 
			return false;
		
		boolean flag = true;
		
		for (int i=1; i<fil; i++) {
			for (int j=0; j<i; j++) {
				
				if (m[i][j] != m[j][i])
					return false;
				else
					flag = true;
			}
		}
		
		return flag;
	}
}
