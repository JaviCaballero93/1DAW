package practica;

import java.awt.Graphics;

public class cuerpoConBrazo1 extends cabezaConCuerpo{
	
	public cuerpoConBrazo1() {
		super();
	}
	@Override
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawLine(250, 150, 220, 200);
	}
}
