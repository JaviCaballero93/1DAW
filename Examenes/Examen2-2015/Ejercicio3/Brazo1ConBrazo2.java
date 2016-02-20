package practica;

import java.awt.Graphics;

public class brazo1ConBrazo2 extends cuerpoConBrazo1{
	
	public brazo1ConBrazo2() {
		super();
	}
	@Override

	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawLine(250, 150, 280, 200);
	}
}
