package lineOfFour;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

public class windowTest extends JFrame{
	
	public windowTest() {
		JFrame window = new JFrame();	
		JPanel holder = new JPanel();
		JPanel buttons = new JPanel();
		JPanel clrBtn = new JPanel();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		window.setLayout(new GridBagLayout());
		window.setSize(800, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		holder.setLayout(new GridLayout(6,7));
		gbc.weightx=7.0;
		gbc.weighty=8.0;
		gbc.gridx = 0;
		gbc.gridy = 0;
//		gbc.gridwidth=7;
		gbc.fill = GridBagConstraints.BOTH;
		window.add(holder, gbc);
		
		buttons.setLayout(new GridLayout(0,7));
		gbc.weightx=7.0;
		gbc.weighty=0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
//		gbc.gridwidth=3;
		gbc.fill = GridBagConstraints.BOTH;
		window.add(buttons, gbc);

		
		clrBtn.setLayout(new FlowLayout());
		gbc.weightx=7.0;
		gbc.weighty=0.5;
		gbc.gridx = 0;
		gbc.gridy = 2;
//		gbc.gridwidth=3;
		gbc.fill = GridBagConstraints.BOTH;
		window.add(clrBtn, gbc);
		
		
//		for (int i=0; i<7; i++)
//		{
//			for(int j=0; j<6;j++)
//			{
//				String name = "pan"+i+j;
//				MyPanel pan = new MyPanel();
//			}
//		}
		
		
		
        MyPanel drawing1 = new MyPanel();      
        MyPanel drawing2 = new MyPanel();
        MyPanel drawing3 = new MyPanel();      
        MyPanel drawing4 = new MyPanel();
        MyPanel drawing5 = new MyPanel();      
        MyPanel drawing6 = new MyPanel();
        MyPanel drawing7 = new MyPanel();      
        MyPanel drawing8 = new MyPanel();
        MyPanel drawing9 = new MyPanel();      
        MyPanel drawing10 = new MyPanel();
        MyPanel drawing11 = new MyPanel();      
        MyPanel drawing12 = new MyPanel();
        MyPanel drawing13 = new MyPanel();      
        MyPanel drawing14 = new MyPanel();
        MyPanel drawing15 = new MyPanel();      
        MyPanel drawing16 = new MyPanel();
        MyPanel drawing17 = new MyPanel();      
        MyPanel drawing18 = new MyPanel();
        MyPanel drawing19 = new MyPanel();      
        MyPanel drawing20 = new MyPanel();
        MyPanel drawing21 = new MyPanel();      
        MyPanel drawing22 = new MyPanel();
        MyPanel drawing23 = new MyPanel();      
        MyPanel drawing24 = new MyPanel();
        MyPanel drawing25 = new MyPanel();      
        MyPanel drawing26 = new MyPanel();
        MyPanel drawing27 = new MyPanel();      
        MyPanel drawing28 = new MyPanel();
        MyPanel drawing29 = new MyPanel();      
        MyPanel drawing30 = new MyPanel();
        MyPanel drawing31 = new MyPanel();      
        MyPanel drawing32 = new MyPanel();
        MyPanel drawing33 = new MyPanel();      
        MyPanel drawing34 = new MyPanel();
        MyPanel drawing35 = new MyPanel();      
        MyPanel drawing36 = new MyPanel();
        MyPanel drawing37 = new MyPanel();      
        MyPanel drawing38 = new MyPanel();
        MyPanel drawing39 = new MyPanel();      
        MyPanel drawing40 = new MyPanel();
        MyPanel drawing41 = new MyPanel();
        MyPanel drawing42 = new MyPanel();
        
        
        
//        drawing.setSize(100, 100);
//        drawing2.setSize(50, 50);
        
        
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("Clear");
        
        
        holder.add(drawing1,0,0);
        holder.add(drawing2,1,0);
        holder.add(drawing3,1,0);
        holder.add(drawing4,1,0);
        holder.add(drawing5,1,0);
        holder.add(drawing6,1,0);
        holder.add(drawing7,1,0);
        holder.add(drawing8,1,0);
        holder.add(drawing9,1,0);
        holder.add(drawing10,1,0);
        holder.add(drawing11,0,0);
        holder.add(drawing12,1,0);
        holder.add(drawing13,1,0);
        holder.add(drawing14,1,0);
        holder.add(drawing15,1,0);
        holder.add(drawing16,1,0);
        holder.add(drawing17,1,0);
        holder.add(drawing18,1,0);
        holder.add(drawing19,1,0);
        holder.add(drawing20,1,0);
        holder.add(drawing21,0,0);
        holder.add(drawing22,1,0);
        holder.add(drawing23,1,0);
        holder.add(drawing24,1,0);
        holder.add(drawing25,1,0);
        holder.add(drawing26,1,0);
        holder.add(drawing27,1,0);
        holder.add(drawing28,1,0);
        holder.add(drawing29,1,0);
        holder.add(drawing30,1,0);
        holder.add(drawing31,0,0);
        holder.add(drawing32,1,0);
        holder.add(drawing33,1,0);
        holder.add(drawing34,1,0);
        holder.add(drawing35,1,0);
        holder.add(drawing36,1,0);
        holder.add(drawing37,1,0);
        holder.add(drawing38,1,0);
        holder.add(drawing39,1,0);
        holder.add(drawing40,1,0);
        holder.add(drawing41,1,0);
        holder.add(drawing42,1,0);
        
        
        buttons.add(btn1);buttons.add(btn2);buttons.add(btn3);buttons.add(btn4);buttons.add(btn5);buttons.add(btn6);buttons.add(btn7);

        
        clrBtn.add(btn8);
        
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setResizable(false);
        window.setVisible(true);
	}
}
