package lineOfFour;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gameView extends JFrame{
	
	private gameModel m_model;
	
	MyPanel[][] panelArr = new MyPanel[6][7];
	
	
	private Button btn1 = new Button("1");
	private Button btn2 = new Button("2");
	private Button btn3 = new Button("3");
	private Button btn4 = new Button("4");
	private Button btn5 = new Button("5");
	private Button btn6 = new Button("6");
	private Button btn7 = new Button("7");
	private Button btn8 = new Button("Clear");
	
	MyPanel drawing1 = new MyPanel(); 
	
	//Constructor
	//1. create 3 panels to hold the game panels, and buttons
	//2. add all the components to the relevant panels
	public gameView(gameModel mod) {
		
		m_model = mod;
		
		JFrame window 	= new JFrame();	
		JPanel holder 	= new JPanel();
		JPanel buttons 	= new JPanel();
		JPanel clrBtn 	= new JPanel();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		window.setLayout(new GridBagLayout());
		window.setSize(800, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		holder.setLayout(new GridLayout(6,7));
		gbc.weightx = 7.0;
		gbc.weighty = 8.0;
		gbc.gridx 	= 0;
		gbc.gridy 	= 0;
		gbc.fill 	= GridBagConstraints.BOTH;
		window.add(holder, gbc);
		
		buttons.setLayout(new GridLayout(0,7));
		gbc.weightx = 7.0;
		gbc.weighty = 0.5;
		gbc.gridx 	= 0;
		gbc.gridy 	= 1;
		gbc.fill 	= GridBagConstraints.BOTH;
		window.add(buttons, gbc);

		
		clrBtn.setLayout(new FlowLayout());
		gbc.weightx = 7.0;
		gbc.weighty = 0.5;
		gbc.gridx 	= 0;
		gbc.gridy 	= 2;
		gbc.fill 	= GridBagConstraints.BOTH;
		window.add(clrBtn, gbc);
		
		
        for(int i=0; i<6; i++) {
        	for(int j=0; j<7; j++) {
        		panelArr[i][j] = new MyPanel();
        	}
        }
		              
        for(int i=0; i<6; i++) {
        	for(int j=0; j<7; j++) {
        		holder.add(panelArr[i][j]);
        	}
        }
        	
                
        buttons.add(btn1);buttons.add(btn2);buttons.add(btn3);buttons.add(btn4);buttons.add(btn5);buttons.add(btn6);buttons.add(btn7);

        
        clrBtn.add(btn8);
        
        

        window.setTitle("Line Of Four");
        window.setResizable(false);
        window.setVisible(true);
	}
	
    //add the button action listener to each button
    void addBtnListener(ActionListener cal) {
        btn1.addActionListener(cal);
        btn2.addActionListener(cal);
        btn3.addActionListener(cal);
        btn4.addActionListener(cal);
        btn5.addActionListener(cal);
        btn6.addActionListener(cal);
        btn7.addActionListener(cal);
    }
	
    //add the clear button action listener
	void addClearListener(ActionListener mal) {
        btn8.addActionListener(mal);
    }
	
	//after a button was pressed, update the 2D array, and color the new disk
	void colorNext(int col){
		for(int i=5; i>-1; i--) {
			if(m_model.lineOfour[i][col]==0) {
				System.out.println("coloring col "+col+ "line "+i);
				m_model.lineOfour[i][col]=m_model.curTurn();
				
				panelArr[i][col].setTurnI(m_model.curTurn());
				panelArr[i][col].repaint();
				
				if(i==0) {
					deactivateBtn(col);
					m_model.enabledBtns--;
					System.out.println("enabled buttons: "+m_model.enabledBtns);
				}
				if(m_model.enabledBtns==0) {
					JOptionPane.showMessageDialog(new JFrame(), "No more space, DRAW! now clear.");
				}
					
				m_model.printTest();
				if(m_model.checkLine(i,col)) {
					JOptionPane.showMessageDialog(new JFrame(), "Player " + m_model.curTurn()+ " WINS!");
					deactivateAll();
				}
					
				m_model.nextTurn();
				break;
			}
	
		}
	}
	
	//deactivate a specific button
	void deactivateBtn(int btn) {
		if (btn==0)
			btn1.setEnabled(false);
		if (btn==1)
			btn2.setEnabled(false);
		if (btn==2)
			btn3.setEnabled(false);
		if (btn==3)
			btn4.setEnabled(false);
		if (btn==4)
			btn5.setEnabled(false);
		if (btn==5)
			btn6.setEnabled(false);
		if (btn==6)
			btn7.setEnabled(false);
	}
	
	//activate all buttons for a new game
	void activateBtn() {

		btn1.setEnabled(true);
		btn2.setEnabled(true);
		btn3.setEnabled(true);
		btn4.setEnabled(true);
		btn5.setEnabled(true);
		btn6.setEnabled(true);
		btn7.setEnabled(true);
	}
	
	//deactivate all buttons if there is a win
	void deactivateAll() {

		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
}
	
	//clear all the disks for a new game
	void clearColor() {
		
		for (int i=0;i<6;i++) {
			for (int j=0; j<7; j++) {
				panelArr[i][j].setTurnI(0);
				panelArr[i][j].repaint();
			}
		}
	}
}
