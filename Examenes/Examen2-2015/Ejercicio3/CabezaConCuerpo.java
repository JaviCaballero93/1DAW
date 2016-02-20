package practica;

import java.awt.Graphics;

public class cabezaConCuerpo extends patibuloConCabeza{
	
	public cabezaConCuerpo() {
		super();
	}
	@Override
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawLine(250, 130, 250, 240);
	}
}
