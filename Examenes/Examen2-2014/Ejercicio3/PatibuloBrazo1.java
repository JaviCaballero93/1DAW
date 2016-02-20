import java.awt.Graphics;

public class PatibuloBrazo1 extends PatibuloCuerpo{
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawLine(120, 110, 90, 130);
	}
}
