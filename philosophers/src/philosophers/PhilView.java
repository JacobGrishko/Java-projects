package philosophers;

import javax.swing.JFrame;


public class PhilView extends JFrame{
	
	private PhilModel _model;
	
	JFrame window;
	PhilPanel panel;
	
	//constructor
	public PhilView(PhilModel mod) {
		
		_model = mod;
		_model.sendRef(this);
		
		
		window = new JFrame();	
		panel = new PhilPanel(_model);
	
		window.add(panel);
		
		window.setSize(1000, 1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setTitle("Philosophers");
        window.setResizable(false);
        window.setVisible(true);
	}


}
