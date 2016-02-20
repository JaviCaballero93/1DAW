package practica;

import java.awt.Graphics;

public class patibuloConCabeza extends patibulo{
	
	public patibuloConCabeza() {
		super();
	}
	@Override
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawOval(225, 80, 50, 50);
	}
}
