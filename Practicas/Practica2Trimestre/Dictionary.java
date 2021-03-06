import java.util.Scanner;
import java.util.Random;
import java.io.*;
import javax.swing.JOptionPane;

public class Dictionary {
	
	private File file;
	private int palabras;
	
	public Dictionary() {
		
		this("C:/Dict.txt");
	}
	
	public Dictionary(String path) {
		
		file = new File(path);
		getNumeroDePalabras();
	}
	
	private void getNumeroDePalabras()	{
		
		try(Scanner scanner = new Scanner(file)) {
			while(scanner.hasNext()) {
				palabras++;
				scanner.nextLine();
			}
		}

		catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public String getRandom() {
		
		String text = "";
		Random random = new Random();
		int palabraObjetivo = random.nextInt(palabras);
		
		try(Scanner scanner = new Scanner(file)) {
			for(int i = 0; i < palabraObjetivo; i++) {
				scanner.nextLine();
			}
			
			text = scanner.nextLine();
		}

		catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
		}
		
		return text;
	}
}
