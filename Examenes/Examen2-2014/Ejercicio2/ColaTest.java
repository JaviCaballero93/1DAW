import javax.swing.JOptionPane;

public class ColaTest() {
        public static void main(String[] args) {
                
                Cola cola1 = new Cola();
                
                cola1.colocar(new Persona("Pepe", 1));
                cola1.colocar(new Persona("Javi", 0));
                cola1.colocar(new Persona("Maria", 2));
		cola1.colocar(new Persona("Jesus", 0));
		cola1.colocar(new Persona("Ana", 1));
		cola1.colocar(new Persona("Juan", 2));
		cola1.colocar(new Persona("Irene", 3));
		
		JOptionPane.showMessageDialog(cola1.listar());
		
		Cola cola2 = new Cola();
		
	        cola2.colocar(new Persona("Ignacio", 2));
		cola2.colocar(new Persona("Tońi", 0));
		cola2.colocar(new Persona("Docarmo", 1));
		
		cola1.mezclar(cola2);
		
		JOptionPane.showMessageDialog(cola1);
        }
}
