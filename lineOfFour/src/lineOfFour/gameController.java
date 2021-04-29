package lineOfFour;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameController {
	
	private gameModel m_model;
	private gameView m_view;
	
	//Constructor
	public gameController(gameModel mod,gameView view) {
		m_model = mod;
		m_view 	= view;
		
		view.addBtnListener(new gameBtnListener());
		view.addClearListener(new clearBtnListener());
		
	}


	//Inner class gameBtnListener
	class gameBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("button pressed: "+e.getSource());
			Button b = (Button)e.getSource(); 
			int lbl = Integer.parseInt(b.getLabel());
			m_view.colorNext(lbl-1);
		}
		
	}//END OF CLASS

	
	//Inner class clearBtnListener
	class clearBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("clear button pressed "+e.getSource());
			m_model.zeroize();
			m_model.enabledBtns=7;
			m_model.setTurn();
			m_view.activateBtn();
			m_view.clearColor();
		}
		
	}//END OF CLASS
}




