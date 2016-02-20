package objects;

import java.util.ArrayList;
import human.Persona;

public class Cola extends ArrayList<Persona> {

	private static final long serialVersionUID = 1L;
	
	public Cola() {
		
	}

	
	public void colocar(Persona persona) {

		if(isEmpty())
			add(persona);

		else {
			int i=0;

			while(i<size() && get(i).getPrioridad <= persona.getPrioridad) 
				i++;
			

			if(i==size)
				add(persona);

			else
				add(i, persona);
		}
	}
	
	public Persona sacar() {

		if (!isEmpty()) { 

			Persona persona = get(0);
			remove(0);
			
			return persona;
		}
		
		return null;	
	}
	
	public void listar() {

		String text = "";

		for(int i=0; i<size(); i++) {
			text += get(i).toString() + "\n";
		}

		return text;
	}
	
	public void mezclar(Cola cola) {

		for(int i=0; i<=cola.size(); i++) {
			colocar(cola.get(i));
		}
	}		
}

