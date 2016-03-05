package polinomios;

public class Monomio {
	
	int coefficient;
	int degree;

	public Monomio(String m) {
		// TODO Auto-generated constructor stub
		
		int posX;
		
		if(m.isEmpty()) {
			
			degree = -1;
			coefficient = 0;
		}
		
		else {
			
			posX = (m.toUpperCase()).indexOf('X');
			
			if(posX == -1) {
				
				degree = 0;
				coefficient = Integer.parseInt(m);
			}
			
			else {
				
				if(posX == m.length() - 1)
					degree = 1;
				
				else
					degree = Integer.parseInt(m.substring(posX + 1));
				
				if(posX==0)
					coefficient = 1;
				
				else
					coefficient = Integer.parseInt(m.substring(0, posX));
			}
		}
	}
	
	public int getDegree() {
		
		return degree;
	}
	
	public int getCoefficient() {
		
		return coefficient;
	}
}