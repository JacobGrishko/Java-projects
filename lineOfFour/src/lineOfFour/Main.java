package lineOfFour;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Main {
	
	 public static void main(String args[]) {
	     	
	     	gameModel model = new gameModel();
	     	gameView window = new gameView(model);
	     	gameController ctrl = new gameController(model,window);
	     	
	    }	
		
}



