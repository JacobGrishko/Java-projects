package restaurantMenu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RestController {

//	private RestModel m_model;	//not used
	private RestView m_view;
	
	//Constructor
	public RestController(RestModel mod,RestView view) {
//		m_model = mod;			//not used
		m_view 	= view;
		
		view.addBtnListener(new orderListener());
	}
	
	
	//Inner class orderListener
	class orderListener implements ActionListener{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			int length = m_view.checkBoxes.size();
			String orderStr="Your order: \n";
			double price=0;
			double totalSum=0;
			double totalForAmount=0;
			String[] options = {"Accept", "Update", "Cancel"};
			
			
			for(int i=0; i<length; i++) {
				if(m_view.checkBoxes.get(i).isSelected()) {
					
					String stripedValue = (m_view.checkBoxes.get(i).getLabel().replaceAll("[\\s+a-zA-Z :]",""));
					
					price = Double.parseDouble(stripedValue);
					totalForAmount= ((double) m_view.comboBoxes.get(i).getSelectedItem())*price;
					
					totalSum += totalForAmount;
					orderStr+=(int)(double)m_view.comboBoxes.get(i).getSelectedItem()+" "+m_view.checkBoxes.get(i).getLabel()+" sum: "+totalForAmount+"\n";			
				}
			}
			orderStr+="\nTotal price: "+totalSum+"\n";
			
			int x = JOptionPane.showOptionDialog(null, orderStr,
	                "Your order:",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	        System.out.println(x);
	        
	        if (x==0) {
	        	System.out.println("accepted");
	        	try {
					acceptOpt(orderStr);
				} catch (IOException e1) {
					e1.printStackTrace();
					System.out.println("did not pass");
				}
	        }
	        if(x==2) {
	        	System.out.println("Canceled");
	        	cancelOpt();
	        	
	        	
	        }
		}

		
		//accept and save to file
		public void acceptOpt(String str) throws IOException {
			boolean correct=false;
			String input="";
			while(!correct) {
				input = JOptionPane.showInputDialog("enter your name followed by IDnumber: ");
				if(!Character.isLetter(input.charAt(0))){
					JOptionPane.showMessageDialog(new JFrame(), "Your name has to start with a letter. Try again.");
				}else
					correct=true;
						
			}
			
			
			String name = input.replaceAll("[\\s+0-9 :]","");
			System.out.println("enterd string: "+input+" name: "+name);
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(name+".txt", true));
		    writer.append(str);
		    
		    writer.close();
		    
		    cancelOpt();
		}
		
		//Cancel, uncheck everything
		public void cancelOpt() {
			int length = m_view.checkBoxes.size();
			
			for(int i=0; i<length; i++) {
				m_view.checkBoxes.get(i).setSelected(false);
				m_view.comboBoxes.get(i).setSelectedIndex(0);
			}
			
		}
		
	}//END OF CLASS
	
	
}
