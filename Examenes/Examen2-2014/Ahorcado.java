import java.util.ArrayList;

public class Ahorcado {
	private String palabra;
	private boolean[] acertadas;
	private ArrayList<Character> introducidas;
	private int fallos = 0;
	
	public Ahorcado(String paliniciar) {
		palabra = paliniciar;
		
		for(int i=0; i<=palabra.length(); i++) {
			acertadas[i] = false;
		}
	}
	
	public boolean checkLetter (char let) {
		boolean found = false;
		introducidas.add(let);
		if (fallos >= 6) return false;
		
		for (int i=0; i<=palabra.length(); i++) {
			if (palabra.charAt(i) == let) {
				acertadas[i] = true;
				found = true;
			}
		}
		if (!found) fallos++;
		return found;
	}
	
	public String getWord() {
		return palabra;
	}
	
	public String getMaskWord() {
		char[] maskWord = new char[palabra.length()];
		
		for (int i=0; i<palabra.length(); i++) {
			if(acertadas[i]) maskWord[i] = palabra.charAt(i);
			else maskWord[i] = '-';			
		}
		return new String(maskWord);
	}
	
	public ArrayList<Character> getIntroduced() {
		return introducidas;
	}
	
	public boolean youWin() {
		if (getMaskWord() == palabra) return true;
		else return false;
	}
	
	public int getMistake() {
		return fallos;
	}
}



