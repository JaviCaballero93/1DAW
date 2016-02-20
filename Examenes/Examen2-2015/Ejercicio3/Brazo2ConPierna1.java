package practica;

import java.awt.Graphics;

public class brazo2ConPierna1 extends brazo1ConBrazo2{
	
	public brazo2ConPierna1() {
		super();
	}
	@Override
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawLine(250, 240, 220, 280);
	}
}
