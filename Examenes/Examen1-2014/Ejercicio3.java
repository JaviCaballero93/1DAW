import javax.swing.JOptionPane;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		
		int op = 1;
		int[] list = new int[5];
		
		do {
			op = menu();
			
			switch(op) {
				case 1: push(list);
					break;
				case 2: pop(list);
					break;
			}	
		}
		
		while(op!=3);
	}
	
	public static int menu() {
		
		int op = Integer.parseInt(JOptionPane.showInputDialog("Menu de Opciones:\n1.-Introducir elemento en la cola.\n" + 
				"2.-Sacar elemento de la cola.\n3.-Salir."));
		
		return op;
	}
	
	public static void push(int[] list) {
		
		if(!isFull(list)) {
			
			int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número: "));
			int i = 0;
			
			while(list[i] != 0)
				i++;
			
			list[i] = num;
		}
		
		else
			JOptionPane.showMessageDialog(null, "La lista esta llena. No puedes añadir mas numeros.");
	}
	
	public static void pop(int[] list) {
		
		if(!isEmpty(list)) {
			
			for(int i=0; i<list.length-1; i++) {
				list[i] = list[i+1];
				list[i+1] = 0;
			}
		}
		
		else
			JOptionPane.showMessageDialog(null, "La lista esta vacia, por lo que no puede borrar ningun elemento de ella.");
	}

	public static boolean isFull(int[] list) {
		
		if(list[list.length-1] != 0)
			return true;
		
		else
			return false;
	}
	
	public static boolean isEmpty(int[] list) {
		
		if(list[0] == 0)
			return true;
		
		else
			return false;
	}
}