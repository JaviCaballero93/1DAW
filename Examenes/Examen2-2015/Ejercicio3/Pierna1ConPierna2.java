package practica;

import java.awt.Graphics;

public class pierna1ConPierna2 extends brazo2ConPierna1{
	
	public pierna1ConPierna2() {
		super();
	}
	@Override
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawLine(250, 240, 280, 280);
		g.drawLine(235, 97, 245, 105);
		g.drawLine(245, 97, 235, 105);
		g.drawLine(255, 97, 265, 105);
		g.drawLine(265, 97, 255, 105);
		
		g.drawOval(245, 112, 11, 11);
	}
}
