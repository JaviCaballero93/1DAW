import java.util.Scanner;
import java.util.Random;
import java.io.*;

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
			System.out.println(e);
		}
	}
	
	public String getAll() {
		
		String text = "";
		
		try(Scanner scanner = new Scanner(file)) {
			while(scanner.hasNext()) {
				text += scanner.nextLine() + "\n";
			}
		}

		catch(Exception e) {
			System.out.println(e);
		}
		
		return text;
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
			System.out.println(e);
		}
		
		return text;
	}
	
	public void escribir(String nuevaPalabra) {

		try(PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
			writer.print("\n");
			writer.print(nuevaPalabra);
			palabras++;
		}

		catch(Exception e) {
			System.out.println(e);
		}
	}
}
