import javax.swing.JOptionPane;

public class JuegoDados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]tiradas = new int[6];
		boolean[]caras = new boolean[6];
		int count = 1;
		
		boolean escalera = false;
		String list = "";
		
		//Primera tirada
		for(int i=0; i<6; i++) {
			
			tiradas[i] = 1 + (int)(Math.random() * 6);
			caras[tiradas[i] - 1] = true;
			list += tiradas[i] + " ";
		}
		
		if(caras[0]&&caras[1]&&caras[2]&&caras[3]&&caras[4]&&caras[5]) 
			escalera = true;
		
		JOptionPane.showMessageDialog(null, list);
		
		//Tiradas individuales
		while(!escalera) {
			
			list = "";
			caras[0] = false;
			caras[1] = false;
			caras[2] = false;
			caras[3] = false;
			caras[4] = false;
			caras[5] = false;
			
			int tiradaNueva = Integer.parseInt(JOptionPane.showInputDialog("Que dado quiere tirar de nuevo??")) - 1;
			
			tiradas[tiradaNueva] = 1 + (int)(Math.random() * 6);
			count++;
			
			//Comprobar si se ha conseguido escalera
			for(int i=0; i<6; i++) {
				
				caras[tiradas[i] - 1] = true;
				list += tiradas[i] + " ";
			}
			
			JOptionPane.showMessageDialog(null, list);
			
			if(caras[0]&&caras[1]&&caras[2]&&caras[3]&&caras[4]&&caras[5]) 
				escalera = true;
		}
		
		JOptionPane.showMessageDialog(null, "Conseguiste escalera en " + count + " tiradas.");
	}
}