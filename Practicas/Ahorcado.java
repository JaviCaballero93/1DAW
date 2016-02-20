import javax.swing.JOptionPane;

public class Ahorcado {

	private String palabra;
	private char[]letrasIntroducidas;
	private int turnos;
	private int fallos;
	
	public Ahorcado() {
		// TODO Auto-generated constructor stub
		this("Ahorcado");
	}
	
	public Ahorcado(String palabraInicial) {
		
		this.palabra = palabraInicial.toUpperCase();
		letrasIntroducidas = new char[25];
		turnos = 0;
		fallos = 0;
	}
	
	public boolean buscarLetra(char letra) {
		//Con esto nos quitamos el problema si el usuario introduce una mayuscula o una minuscula.
		letra = Character.toUpperCase(letra);
		if(letraRepetida(letra) && palabra.indexOf(letra) == -1) {
			JOptionPane.showMessageDialog(null, "La letra introducida fue introducida antes y no esta en la palabra. Cuenta como error.");
		}
		
		else if(letraRepetida(letra)) {
			
			JOptionPane.showMessageDialog(null, "La letra introducida esta repetida");
		}
			
		else {
			letrasIntroducidas[turnos] = letra;
			turnos++;
		}
		// indexOf devuelve -1 si no encuentra el char
		if(palabra.indexOf(letra) == -1 ) {
		
			fallos++;
			return true;	
		}
		
		else
			return false;
		
	}
	
	public boolean letraRepetida(char letra) {
		
		for(int i=0; i<letrasIntroducidas.length; i++) {
			
			if(letrasIntroducidas[i] == letra) 
				return true;			
		}
		
		return false;
	}
	
	public String getPalabra() {
		
		return palabra;
	}
	
	public String getPalabraOculta() {
		
		String palabraOculta = palabra;
		boolean temp;
		
		//Recorre palabraOculta(que es igual que palabra)
		for(int i=0; i<palabraOculta.length(); i++) {
			
			temp = false;
			
			//Recorre letrasIntroducidas[]
			for(int j=0; j<letrasIntroducidas.length; j++) {
				
				/* Si una letra de palabraOculta coincide con alguna letra de
				 letrasIntroducidas[] (las que el jugador ha dicho)
				 cambia temp a true, por lo que esa letra de palabraOculta
				 NO sera sustituida por un guion*/
				if(palabraOculta.charAt(i) == letrasIntroducidas[j]) {
					
					temp = true;
					break;
				}
			}
			/* Sustituye la letra que el jugador aun no ha dicho por un guion
			   para ocultarla */
			if(!temp)
				palabraOculta = palabraOculta.replace(palabraOculta.charAt(i), '-');	
		}
		
		return palabraOculta;
	}
	
	public char[]getIntroducidas() {
		
		return letrasIntroducidas;
	}
	
	public String getIntroducidasString() {
		
		return String.copyValueOf(letrasIntroducidas);
	}
	
	public boolean youWin() {
		
		/* palabraOculta es igual a palabra cuando 
		   palabraOculta no tiene ningun guion
		   para ocultar letras, es decir, cuando ya 
		   has acertado todas las letras */
		if(getPalabraOculta() == getPalabra())
			return true;
		
		return false;
	}
	
	public int getFallos() {
		
		return fallos;
	}
}