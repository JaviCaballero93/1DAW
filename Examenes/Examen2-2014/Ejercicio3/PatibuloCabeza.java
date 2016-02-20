import java.awt.Graphics;


public class PatibuloCabeza extends Patibulo {
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawOval(105, 60, 30, 30);
		
	}
}
