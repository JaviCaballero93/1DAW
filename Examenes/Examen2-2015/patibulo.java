package practica;

import java.awt.*;
import javax.swing.*;

public class patibulo extends JPanel{
	
	@Override
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawLine(100, 350, 100, 40);
		g.drawLine(100, 350, 300, 350);
		g.drawLine(100, 40, 250, 40);
		g.drawLine(250, 40, 250, 80);
	}
}
