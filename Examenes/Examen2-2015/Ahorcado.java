import java.util.ArrayList;

public class Ejercicio1Ahorcado {

	private static String palabra;
	private static boolean[]letrasAcertadas;
	private static ArrayList<Character>letrasIntroducidas; 
	private static int fallos = 0;
	
	public Ejercicio1Ahorcado(String palabraInicio) {
		
		palabra = palabraInicio;
		
		for(int i=0; i<=palabra.length(); i++) 
			letrasAcertadas[i] = false;
	}
	
	public static boolean checkLetter(char let) {
		
		boolean found = false;
		letrasIntroducidas.add(let);
		
		if(fallos >= 6) 
			return false;
		
		for(int i=0; i<=palabra.length(); i++) {
			if(palabra.charAt(i) == let) {
				
				letrasAcertadas[i] = true;
				found = true;
			}	
		}
		
		if(!found)
			fallos++;
		
		return found;
	}
	
	public String getWord() {
		
		return palabra;
	}
	
	public String getMaskWord() {
		
		char[]maskWord = new char[palabra.length()];
		
		for(int i=0; i<palabra.length(); i++) {
			if(letrasAcertadas[i])
				maskWord[i] = palabra.charAt(i);
			
			else
				maskWord[i] = '-';			
		}
		
		return new String(maskWord);
	}
	
	public ArrayList<Character>getIntroduced() {
		
		return letrasIntroducidas;
	}
	
	public boolean youWin() {
		
		if(getMaskWord() == palabra)
			return true;
		
		else
			return false;
	}
	
	public int getMistakes() {
		
		return fallos;
	}
}