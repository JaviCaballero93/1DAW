package human;

public class Persona {

	private String nombre;
	private int prioridad = 0;

	public Persona() {

		this();
	}
	
	public Persona(String nombre, int prioridad) {

		this.nombre = nombre;
		this.prioridad = prioridad;
	}
	
	public void setNombre(String nombre) {

		this.nombre = nombre;
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public void setPrioridad(int prioridad) {

		this.prioridad = prioridad;
	}
	
	public int getPrioridad() {

		return prioridad;
	}		
}
