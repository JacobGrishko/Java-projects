package restaurantMenu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MenuPanel extends JPanel{

	JScrollPane scrollPane = new JScrollPane();
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth(),getHeight());
		
	}
	
}
