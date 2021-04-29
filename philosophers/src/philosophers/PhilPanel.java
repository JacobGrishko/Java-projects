package philosophers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class PhilPanel extends JPanel{
	
	PhilModel _model;
	public PhilPanel(PhilModel model) {
		_model=model;
	}
	
	//paint method for the disk panels
	//GREEN- eating Phil
	//BLUE - thinking Phil
	//GRAY - waiting for sticks Phil
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));

      //************************************************* STICK 1 ***************************
        if(_model.stick1._user==null)
        	g2.draw(new Line2D.Float(600, 240, 700, 140));//1
        else if(_model.stick1._user==_model.phil5)
        	g2.draw(new Line2D.Float(700, 290, 800, 190));//fix
        else if(_model.stick1._user==_model.phil1)
        	g2.draw(new Line2D.Float(450, 190, 550, 90));//fix
      
        
      	//***********************************************************PHIL 1 (top) ******************
		if(_model.phil1.eating)
			g.setColor(Color.GREEN);
		else if(_model.phil1.thinking)
			g.setColor(Color.BLUE);
		else if(!_model.phil1.thinking&&!_model.phil1.eating)
			g.setColor(Color.GRAY);
		g.fillOval(400, 50, 100,100);
		
		//************************************************* STICK 2 ***************************
		g.setColor(Color.BLACK);
		
        if(_model.stick2._user==null)
        g2.draw(new Line2D.Float(200, 140, 300, 240));//2
        else if(_model.stick2._user==_model.phil1)
        	g2.draw(new Line2D.Float(350, 140, 450, 240));
        else if(_model.stick2._user==_model.phil2)
        	g2.draw(new Line2D.Float(100, 240, 200, 340));//fix
        
      	//***********************************************************PHIL 2 (left)******************
		if(_model.phil2.eating)
			g.setColor(Color.GREEN);
		else if(_model.phil2.thinking)
			g.setColor(Color.BLUE);
		else if(!_model.phil2.thinking&&!_model.phil2.eating)
			g.setColor(Color.GRAY);
		g.fillOval(100, 300, 100,100);
		
		//************************************************* STICK 3 ***************************
		g.setColor(Color.BLACK);
		if(_model.stick3._user==null)
			g2.draw(new Line2D.Float(150, 530, 250, 470));//3
		else if(_model.stick3._user==_model.phil2)
			g2.draw(new Line2D.Float(150, 410, 250, 350));
		else if(_model.stick3._user==_model.phil3)
			g2.draw(new Line2D.Float(250, 630, 350, 570));//fix
      
    	//***********************************************************PHIL 3 (bottom left)******************
		if(_model.phil3.eating)
			g.setColor(Color.GREEN);
		else if(_model.phil3.thinking)
			g.setColor(Color.BLUE);
		else if(!_model.phil3.thinking&&!_model.phil3.eating)
			g.setColor(Color.GRAY);
		g.fillOval(250, 600, 100,100);
		
		//************************************************* STICK 4 ***************************
		g.setColor(Color.BLACK);
		if(_model.stick4._user==null)
			g2.draw(new Line2D.Float(450, 730, 450, 630));//4
		else if(_model.stick4._user==_model.phil3)
			g2.draw(new Line2D.Float(350, 730, 350, 630));//fix
		else if(_model.stick4._user==_model.phil4)
			g2.draw(new Line2D.Float(600, 730, 600, 630));//fix
      
    	//***********************************************************PHIL 4 (bottom right)******************
		if(_model.phil4.eating)
			g.setColor(Color.GREEN);
		else if(_model.phil4.thinking)
			g.setColor(Color.BLUE);
		else if(!_model.phil4.thinking&&!_model.phil4.eating)
			g.setColor(Color.GRAY);
		g.fillOval(600, 600, 100,100);
		
		//************************************************* STICK 5 ***************************
		g.setColor(Color.BLACK);
		if(_model.stick5._user==null)
			g2.draw(new Line2D.Float(750, 530, 650, 470));//5
		else if(_model.stick5._user==_model.phil4)
			g2.draw(new Line2D.Float(750, 630, 650, 570));//fix
		else if(_model.stick5._user==_model.phil5)
			g2.draw(new Line2D.Float(750, 430, 650, 370));//fix
       
     	//***********************************************************PHIL 5 (right)******************
		if(_model.phil5.eating)
			g.setColor(Color.GREEN);
		else if(_model.phil5.thinking)
			g.setColor(Color.BLUE);
		else if(!_model.phil5.thinking&&!_model.phil5.eating)
			g.setColor(Color.GRAY);
		g.fillOval(700, 300, 100,100);

	}
}
