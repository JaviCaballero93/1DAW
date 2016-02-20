import javax.swing.JOptionPane;

public class PracticaPolinomio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]polinomio1 = polinomio();
		int[]polinomio2 = polinomio();
		int op;
		
		do {
			
			op = menu();
			
			switch(op) {
				case 1: JOptionPane.showMessageDialog(null, "Polinomio 1 = " + valuePoly(polinomio1) + "\n"
						+ "Polinomio 2 = " + valuePoly(polinomio2));
					break;
				case 2: sumaPolinomio(polinomio1, polinomio2);
					visualizar(sumaPolinomio(polinomio1, polinomio2));
					break;
				case 3: restaPolinomio(polinomio1, polinomio2);
					visualizar(restaPolinomio(polinomio1, polinomio2));
					break;
				case 4: multPolinomio(polinomio1, polinomio2);
					visualizar(multPolinomio(polinomio1, polinomio2));
					break;
				case 5: divPolinomio(polinomio1, polinomio2);
					visualizarDivision(divPolinomio(polinomio1, polinomio2));
					break;
			}
		}
	
		while(op!=6);	
	}
	
	public static int menu() {
		
		int op = Integer.parseInt(JOptionPane.showInputDialog("-------------Menu de opciones-----------\n" 
				+ "1.Evaluar Polinomios.\n"
				+ "2.Sumar Polinomios.\n"
				+ "3.Restar Polinomios.\n"
				+ "4.Multiplicar Polinomios.\n"
				+ "5.Dividir Polinomios.\n"
				+ "6.Exit."));
		
		return op;
	}
	
	public static int[]polinomio() {
		
		//Introducimos el grado mayor del polinomio que vamos a introducir.
		int grado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el grado del polinomio:"));
		//Al grado introducido le sumamos 1 para obtener el tamaño del array donde estara el polinomio(grado + 1)
		int[]polinomio = new int[grado + 1];
		int i;
		
		//Dependiendo del grado, vamos a introducir valores hasta llegar a dicho grado.
		for(i=polinomio.length-1; i>=1; i--) {
			polinomio[i] = Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor para X^" + i + ":"));
		}
		//Introducimos por ultimoo el valor que tendria el valor sin 'x'
		polinomio[0] = Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor para el número(variable sin 'x')"));
		
		return polinomio;
	}
	
	public static int valuePoly(int[]poli) {
		
		int value = 0;
		int n  = Integer.parseInt(JOptionPane.showInputDialog("introduce El valor de X"));
		
		for(int i=0; i<poli.length; i++) {
			value += poli[i] * Math.pow(n, i);
		}
			
		return value;
	}
	
	public static int[]sumaPolinomio(int[]poli1, int[]poli2) {
		
		int[]mayor = (poli1.length > poli2.length)? poli1 : poli2;
		int[]sum = new int[mayor.length];
		
		for(int i=0; i<poli1.length; i++) {
			sum[i] += poli1[i];
		}
		
		for(int i=0; i<poli2.length; i++) {
			sum[i] += poli2[i];
		}
		
		return sum;
	}
	
	public static int[]restaPolinomio(int[]poli1, int[]poli2) {
		
		if(poli1.length < poli2.length) {
			int[]temp = poli1;
			poli1 = poli2;
			poli2 = temp;
		}
		
		int[]resta = new int[poli1.length];
		
		for(int i=0; i<poli2.length; i++) {
			resta[i] = poli1[i] - poli2[i];
		}
		
		for(int i=poli2.length; i<poli1.length; i++) {
			resta[i] = poli1[i];
		}
		
		return resta;
	}
	
	public static int[]multPolinomio(int[]poli1, int[]poli2) {
		
		if(poli1.length<poli2.length){
			int[]temp = poli1;
			poli1 = poli2;
			poli2 = temp;
		}
		
		int[]mult = new int[poli1.length + poli2.length-1];
		
		for (int i=0;i<poli2.length;i++) {
			for(int j=0;j<poli1.length;j++) {
				mult[i+j] += poli1[j] * poli2[i];
			}
		}
		
		return mult;
	}
	/*La division esta incompleta, me da un error que se me repite el bucle dos veces. Te lo envio asi para
	que me lo corrijas y asi poder aprender en donde esta el fallo. Los visualizar("lo que sea") son 
	orientativos para ver como va progresando el metodo.*/
	public static int[][]divPolinomio(int[]poli1, int[]poli2) {
		
		if(poli1.length<poli2.length) {
			int[]temp = poli1;
			poli1 = poli2;
			poli2 = temp;
		}
		
		int[]resto = poli1;
		int[]mult = new int[poli1.length];
		int[]cociente= new int[poli1.length-poli2.length+1];
		int[][]division = new int[2][resto.length];
		int count = 0;
		int i = cociente.length-1;
		
		do {
			
			cociente[i] = resto[resto.length-1-count] / poli2[poli2.length-1];
						
			visualizar(cociente);
						
			for(int j=0; j<=poli2.length-1; j++) {
				mult[j+(poli1.length-poli2.length)-count] = cociente[i] * poli2[j];
			}
					
			visualizar(mult);
					
			for(int j=0; j<=mult.length-1; j++) {
				resto[j] = resto[j] - mult[j];
			}
			
			for(int j=0; j<=mult.length-1; j++) {
				mult[j] = 0;
			}
			
			visualizar(resto);
			
			count++;
			i--;
		}
		
		while(i>=0);
		
		for(int j=0; j<cociente.length; j++) {
			division[0][j] = cociente[j];
		}
			
		for(int j=0; j<resto.length; j++) {
			division[1][j] = resto[j];
		}
		
		return division;
	}
	
	//A la hora de visualizar el polinomio 
	public static void visualizar(int[]m) {
			
		String text="";
			
		for (int i=m.length-1; i>=0; i--) {
			if(m[i]!=0) { 
				
				if(i==m.length-1) {
					if(m[i]==1)
						text += "x^"+ i + " ";
					else if(m[i]==-1)
						text += "-x^" + i + " ";
					else
						text += m[i] + "x^"+ i + " ";
				}
				
				else if((i<m.length-1)&&(i>1)&&(m[i]>0)) {
					if(m[i]==1)
						text += "+ x^"+ i + " ";
					else
						text += "+" + m[i] + "x^"+ i + " ";
				}
				
				else if((i<m.length-1)&&(i>1)) {
					if(m[i]==1)
						text += "- x^"+ i + " ";
					else
						text += m[i] + "x^"+ i + " ";
				}
				
				else if((i==1)&&(m[i]>0)) {
					if(m[i]==1)
						text += "+ x ";
					else
						text += "+" + m[i] + "x ";
				}
				
				else if(i==1) {
					if(m[i]==1)
						text += "- x";
					else
						text += m[i] + "x";
				}
				
				else if(m[i]>0)
					text += "+" + m[i];
				
				else
					text += " " + m[i];
			}	
		}
			
		JOptionPane.showMessageDialog(null, text);
	}
	
	public static void visualizarDivision(int[][]m) {
		
		String text="";
		
		for(int j=0; j<2; j++) {
			
			if(j==0)
				text += "Cociente: ";
			
			else
				text += "Resto: ";
			
			for (int i=m[0].length-1; i>=0; i--) {
				
				if(m[j][i]!=0) { 
					
					if(i==m[0].length-1)
						text += m[j][i] + "x^"+ i + " ";
					
					else if((i<m[0].length-1)&&(i>1)&&(m[j][i]>0)) {
						if(i==m[0].length-1)
							text += m[j][i] + "x^"+ i + " ";
						else
							text += "+" + m[j][i] + "x^"+ i + " ";
					}
					
					else if((i<m[0].length-1)&&(i>1)) 
						text += m[j][i] + "x^"+ i + " ";
					
					else if((i==1)&&(m[j][i]>0)) {
						if(i==m[0].length-1)
							text += m[j][i] + "x^"+ i + " ";
						else
							text += "+" + m[j][i] + "x ";
					}
					
					else if(i==1)
						text += m[j][i] + "x";
					
					else if(m[j][i]>0) {
						if(i==m[0].length-1)
							text += m[j][i];
						else
							text += "+" + m[j][i];
					}
					
					else
						text += " " + m[j][i];
				}	
			}
			
			text += "\n";
		}
			
		JOptionPane.showMessageDialog(null, text);	
	}
}