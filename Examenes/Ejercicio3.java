import java.util.Random;
import javax.swing.JOptionPane;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] dados = randomFillArray(6);
		
		printArray(dados, 6);
		
		while (!comprobarEscalera(dados)){
			int pos = Integer.parseInt(JOptionPane.showInputDialog("No ha obtenido escalera,"
					+ " escoja el dado que quiera tirar de nuevo"));
			Random aleatorio = new Random();
			dados[pos - 1] = (int)aleatorio.nextInt(5) + 1;
			printArray(dados, 6);
		}

		JOptionPane.showMessageDialog(null, "Escalera!!! Has ganado!!!");	
	}

	public static boolean comprobarEscalera(int[] tirada) {
	
		boolean comp = true;
		int cont = 0;
		for (int i = 0;i < tirada.length;i++){
			for(int j = tirada.length - 1;j >= 0;j--) {
				if (tirada[j] == tirada[i])
					cont++;
				
			}

			if (cont > 1){
				comp = false;
				break;
			}

			cont = 0;
		}
	
		return comp;
	}

	public static int[] randomFillArray(int size) {
		
		int[] array = new int[size];
		Random aleatorio = new Random();
				
		for(int i = 0;i < array.length;i++) {
				array[i] = (int)aleatorio.nextInt(6) + 1;
		}

		return array;
	}

	public static void printArray(int[] array, int numberPerLine) {

		String cadena = "";
		for(int i = 0;i < array.length;i++){
			if((i+1)%numberPerLine==0)
				cadena += array[i] + "\n";
			

			else 
				cadena += array[i] + " ";
		}

		JOptionPane.showMessageDialog(null, cadena);
	}
}