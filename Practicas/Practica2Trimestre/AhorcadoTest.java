package test;

import object.Ahorcado;
import javax.swing.JOptionPane;

public class AhorcadoTest {

	public static void main(String[]args) {
		
		Ahorcado ahorcado = new Ahorcado(JOptionPane.showInputDialog("Introduce una palabra: "));
		
		do {
			String text = JOptionPane.showInputDialog(ahorcado.getPalabraOculta() + "\n"
					+ ahorcado.getFallos() + "\n" + ahorcado.getIntroducidasString() + 
					"\nIntroduce una letra: ");
			char letra = text.charAt(0);
			ahorcado.buscarLetra(letra);
			
			if(ahorcado.getPalabraOculta() == ahorcado.getPalabra())
				break;
		}
		
		while(ahorcado.getFallos() < 6);
	
		if(ahorcado.youWin())
			JOptionPane.showMessageDialog(null, "Enhorabuena.");
		
		else
			JOptionPane.showMessageDialog(null, "Lo sentimos. Has cometido 6 fallos y la palabra era " + ahorcado.getPalabra());
	}	
}