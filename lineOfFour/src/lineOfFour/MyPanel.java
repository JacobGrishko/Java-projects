package lineOfFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	
	int colorInt = 1;
	int m_model = 0;
	int turn=0;
	
	//paint method for the disk panels
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth(),getHeight());
		
		g.setColor(Color.WHITE);
		if(turn==1)
			g.setColor(Color.RED);
		if(turn==2)
			g.setColor(Color.BLUE);
		
		g.fillOval(0, 0, getWidth(),getHeight());

	}

	//set current turn to paint a disk in red or blue
	public void setTurnI(int turnI) {
		turn = turnI;
	}
}
