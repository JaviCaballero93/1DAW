import java.awt.Graphics;

public class PatibuloCuerpo extends PatibuloCabeza{
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawLine(120, 90, 120, 150);
	}
}
