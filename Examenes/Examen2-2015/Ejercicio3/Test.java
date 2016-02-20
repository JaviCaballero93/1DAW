import javax.swing.JFrame;

public class Test {
	public static void main(String[] args) {
		Patibulo ahorcado = new PatibuloPierna2();
		
		ahorcado.setSize(600, 330);
		ahorcado.setVisible(true);
		
		JFrame frame = new JFrame();
		frame.setTitle("Ahorcado");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 330);
		frame.setVisible(true);
		
		frame.add(ahorcado);
		frame.add(new Patibulo());
		frame.add(new PatibuloCabeza());
	}
}
