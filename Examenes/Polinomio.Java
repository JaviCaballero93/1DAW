public class Polinomio {
	
	int[]polinomio;
	int grado;

	public Polinomio(String p) {
		// TODO Auto-generated constructor stub
		
		p = p.replace('+', '%');
		String[]monomios = p.split("%", 0);
		
		for(int i=0; i<monomios.length; i++) {
			
			Monomio m = new Monomio(monomios[i]);
			
			if(i==0) {
				grado = m.getDegree();
				polinomio = new int[grado+1];
			}
			
			polinomio[m.getDegree()] = m.getCoefficient();	
		}
	}
	
	public Polinomio(int[]poli) {
		
		this.polinomio = poli;
		this.grado = poli.length-1;
	}
	
	public Polinomio suma(Polinomio poli) {
		
		int[]suma = new int[((this.grado > poli.grado)? this.grado : poli.grado)+1];
		
		for(int i=0; i<this.polinomio.length; i++) {
			
			suma[i] += this.polinomio[i];
		}
		
		for(int i=0; i<poli.polinomio.length; i++) {
			
			suma[i] += poli.polinomio[i];
		}
		
		Polinomio resultSum = new Polinomio(suma);
		
		return resultSum;
	}
	
	
	public String toString() {
		
		String p = "";
		
		for(int i= grado; i>=0; i--) {
			
			if(i!=grado && polinomio[i]>0)
				p += " +";
			
			if(polinomio[i] == 0)
				continue;
			
			if(polinomio[i] != 1)
				p += String.valueOf(polinomio[i]);
			
			if(i==1)
				p += "X";
			
			if(i!=0 && i!=1)
				p += "X" + i;
		}
		
		return p;
	}
}