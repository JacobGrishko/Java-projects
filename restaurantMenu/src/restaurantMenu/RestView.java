package restaurantMenu;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class RestView extends JFrame {
	
	private RestModel m_model;
	Button orderBtn = new Button("Oreder");
	
	ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
	ArrayList<JComboBox> comboBoxes = new ArrayList<JComboBox>();
	int total = 0;
	
	//menu window
	public RestView(RestModel model) {
		
		m_model = model;
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JFrame menuWindow = new JFrame();
		
		menuWindow.setLayout(new GridBagLayout());
		menuWindow.setSize(850, 600);
		menuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuPanel firstsP = new MenuPanel();
		MenuPanel mainCourseP = new MenuPanel();
		MenuPanel desertsP = new MenuPanel();
		MenuPanel drinksP = new MenuPanel();
		MenuPanel Order = new MenuPanel();
		
		
		Order.setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.BOTH;
		Order.add(orderBtn,gbc);
		

		gbc.weightx=2.0;
		gbc.weighty=3.0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		menuWindow.add(firstsP, gbc);
		
		gbc.weightx=2.0;
		gbc.weighty=3.0;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		menuWindow.add(mainCourseP, gbc);
		
		gbc.weightx=2.0;
		gbc.weighty=3.0;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		menuWindow.add(desertsP, gbc);
		
		gbc.weightx=2.0;
		gbc.weighty=3.0;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		menuWindow.add(drinksP, gbc);
		
		gbc.weightx=2.0;
		gbc.weighty=1.0;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		menuWindow.add(Order, gbc);
		
		
		setPanel(firstsP,		m_model.firsts,		m_model.firstsPrice,	 	"Firsts");
		setPanel(mainCourseP,	m_model.maincourses,m_model.maincoursesPrice,	"Main course");
		setPanel(desertsP,		m_model.deserts,	m_model.desertsPrice,		"Deserts");
		setPanel(drinksP,		m_model.drinks,		m_model.drinksPrice,		"Drinks");
		
		
		
		
		
		
		
		
		menuWindow.setTitle("Not so fancy menu");
		menuWindow.setVisible(true);
		
	}
	
	//set panel of each category
	public void setPanel(JPanel panel, ArrayList<String> product, ArrayList<Double> price, String label) {
		
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Set label for panel
		final JLabel lbl1 = new JLabel();  
		lbl1.setText(label);
		lbl1.setFont(new Font("David", Font.PLAIN, 22));
		lbl1.setVerticalAlignment(JLabel.NORTH);    
		lbl1.setSize(400,100);
		
		final JLabel lbl2 = new JLabel();
		lbl2.setText("Amount:");
		lbl2.setFont(new Font("David", Font.PLAIN, 22));
		lbl2.setVerticalAlignment(JLabel.NORTH);    
		lbl2.setSize(400,100);
		
		
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(lbl1,gbc);
		
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(lbl2,gbc);
		
		
		int size = product.size();

		for(int i=0; i<size; i++) {
			JCheckBox checkBox = new JCheckBox(product.get(i)+"  "+price.get(i)+" Shekels");  
			checkBox.setBounds(100*i,0, 50,50); 
			checkBoxes.add(checkBox);
			
			JComboBox c1 = new JComboBox();
			c1.setPreferredSize(new Dimension(1,25));
			comboBoxes.add(c1);
			
			for (double j = 1; j <10; j++) {
				c1.addItem(j);
			}
			
			gbc.weightx=3.0;
			gbc.weighty=1.0;
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.fill = GridBagConstraints.BOTH;
			panel.add(checkBox,gbc);
			
			gbc.weightx=1.0;
			gbc.weighty=1.0;
			gbc.gridx = 1;
			gbc.gridy = i;
			panel.add(c1,gbc);
			
		}
		
	}
	
	 //add the button action listener to each button
    void addBtnListener(ActionListener cal) {
    	orderBtn.addActionListener(cal);  
    }
}
