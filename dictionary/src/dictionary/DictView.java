package dictionary;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DictView extends JPanel{

	private DictModel m_model;
	
	JFrame window 		= new JFrame();
	
	JPanel dictList 	= new JPanel();
	JPanel actions	 	= new JPanel();
	JPanel fileLoader 	= new JPanel();
	
	JButton searchBtn = new JButton("Search");
	JButton addBtn = new JButton("Add");
	JButton deleteBtn = new JButton("Delete");
	JButton updateBtn = new JButton("Update");
	
	JButton fileChoose = new JButton("Choose file");
	JButton fileLoad = new JButton("Load dictionary");
	
	JTextField searchTxt = new JTextField("Search key",20);
	JTextField keyTxt = new JTextField("key",20);
	JTextField valTxt = new JTextField("definition",100);
	
	JLabel dictLbl = new JLabel();
	
	JFileChooser fileChooser;
	File selectedFile;
	
	//Constructor
	public DictView(DictModel model) {
		
		m_model = model;

		GridBagConstraints gbc = new GridBagConstraints();

		//***************************** first panel - dictionary ***************************
		dictList.setLayout(new BoxLayout(dictList, BoxLayout.Y_AXIS));	
		String dictFull="<html>";
		for(String key : m_model.dictionary.keySet()) {
			
			String keyName = key.toString();
			String def = m_model.dictionary.get(key);
			dictFull+=keyName+" - "+def+"<br/>";
		}
		dictFull+="</html>";
		
		dictLbl.setText(dictFull);
		dictList.add(dictLbl);
		
		//****************************** second panel - actions *****************************

		actions.setLayout(new GridBagLayout());
		
		gbc.weightx = 1.0;
		gbc.weighty = 8.0;
		gbc.gridx 	= 0;
		gbc.gridy 	= 0;
		gbc.fill 	= GridBagConstraints.BOTH;
		actions.add(searchTxt, gbc);
		
		gbc.weightx = 1.0;
		gbc.weighty = 8.0;
		gbc.gridx 	= 1;
		gbc.gridy 	= 0;
		gbc.fill 	= GridBagConstraints.BOTH;
		actions.add(searchBtn, gbc);
		
		
		gbc.weightx = 1.0;
		gbc.weighty = 8.0;
		gbc.gridx 	= 0;
		gbc.gridy 	= 1;
		gbc.fill 	= GridBagConstraints.BOTH;
		actions.add(keyTxt, gbc);
		
		gbc.weightx = 1.0;
		gbc.weighty = 8.0;
		gbc.gridx 	= 1;
		gbc.gridy 	= 1;
		gbc.fill 	= GridBagConstraints.BOTH;
		actions.add(valTxt, gbc);
		
		gbc.weightx = 1.0;
		gbc.weighty = 8.0;
		gbc.gridx 	= 0;
		gbc.gridy 	= 2;
		gbc.fill 	= GridBagConstraints.BOTH;
		actions.add(addBtn, gbc);
		
		gbc.weightx = 1.0;
		gbc.weighty = 8.0;
		gbc.gridx 	= 1;
		gbc.gridy 	= 2;
		gbc.fill 	= GridBagConstraints.BOTH;
		actions.add(deleteBtn, gbc);
		
		gbc.weightx = 1.0;
		gbc.weighty = 8.0;
		gbc.gridx 	= 2;
		gbc.gridy 	= 2;
		gbc.fill 	= GridBagConstraints.BOTH;
		actions.add(updateBtn, gbc);
		

		//*****************************************third panel - file loader***********************
		
		fileLoader.setLayout(new FlowLayout());		
		fileLoader.add(fileChoose);
		fileLoader.add(fileLoad);
		

		//********************************************* add panels *******************************
		window.setLayout(new GridBagLayout());
		window.setSize(800, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gbc.weightx = 1.0;
		gbc.weighty = 8.0;
		gbc.gridx 	= 0;
		gbc.gridy 	= 0;
		gbc.fill 	= GridBagConstraints.BOTH;
		window.add(dictList, gbc);
			
		gbc.weightx = 0;
		gbc.weighty = 2.0;
		gbc.gridx 	= 0;
		gbc.gridy 	= 1;
		gbc.gridwidth = 4;
		gbc.fill 	= GridBagConstraints.BOTH;
		window.add(actions, gbc);
		
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.gridx 	= 0;
		gbc.gridy 	= 2;
		gbc.fill 	= GridBagConstraints.BOTH;
		window.add(fileLoader,gbc);
		

		window.setTitle("Dictionary");
		window.setVisible(true);
	}
	

	  //add the button action listener to each button
    void addBtnListener(ActionListener cal1, ActionListener cal2, ActionListener cal3, ActionListener cal4, ActionListener cal5, ActionListener cal6) {
    	searchBtn.addActionListener(cal1);
    	addBtn.addActionListener(cal2);
    	deleteBtn.addActionListener(cal3);
    	updateBtn.addActionListener(cal4);
    	fileChoose.addActionListener(cal5);
    	fileLoad.addActionListener(cal6);
    }
    
    //update the label with all keys and definitions
    public String updateLbl(int option) {
    	String dictFull="<html>";
    	
    	if (option==1) {
    		
    		for(String key : m_model.dictionary.keySet()) {
    			
    			String keyName = key.toString();
    			String def = m_model.dictionary.get(key);
    			dictFull+=keyName+" - "+def+"<br/>";
    		}
    	}else if (option ==2) {
    		for(String key : m_model.fileDictionary.keySet()) {
    			
    			String keyName = key.toString();
    			String def = m_model.fileDictionary.get(key);
    			dictFull+=keyName+" - "+def+"<br/>";
    		}
    	}
    	
    	dictFull+="</html>";
		
		return dictFull;
    }
    
    

}
