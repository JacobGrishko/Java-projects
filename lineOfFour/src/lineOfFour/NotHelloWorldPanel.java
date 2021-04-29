package lineOfFour;
import java.awt.*;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NotHelloWorldPanel extends JPanel {
	
  public void paint(Graphics g) {
    super.paint(g);
    g.drawString("Java Source and Support", getHeight()/2, getWidth()/2-20);
  }
  
  
	/*
	 * public static void main(String[] args) {
	 * 
	 * JFrame frame = new JFrame(); JPanel panel = new JPanel();
	 * frame.setTitle("Line of four"); frame.setSize(600, 200); frame.add(panel);
	 * panel.setVisible(true);
	 * 
	 * frame.addWindowListener(new WindowAdapter() { public void
	 * windowClosing(WindowEvent e) { System.exit(0); } });
	 * 
	 * frame.add(new NotHelloWorldPanel()); frame.setVisible(true); //
	 * frame.setResizable(false);
	 * 
	 * 
	 * 
	 * Button b1 = new Button("1"); b1.setBounds(50,50,150, 150);
	 * b1.addActionListener(new ActionListener(){ public void
	 * actionPerformed(ActionEvent e){ System.out.println("button1 pressed"); } });
	 * 
	 * panel.add(b1);
	 * 
	 * }
	 */
}
