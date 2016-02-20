import java.awt.*;
import javax.swing.*;

public class Patibulo extends JPanel{
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawLine(60, 30, 60, 200);
		g.drawLine(30, 200, 200, 200);
		g.drawLine(60, 30, 180, 30);
		g.drawLine(120, 30, 120, 60);
	}
}
