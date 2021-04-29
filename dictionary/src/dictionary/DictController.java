package dictionary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DictController {
	
	DictModel m_model;
	DictView m_view;
	
	private Scanner input;
	
	public DictController(DictModel model, DictView view) {
		m_model=model;
		m_view=view;
		
		view.addBtnListener(new searchListener(),new addListener(),new deleteListener(),new updateListener(),new uploadListener(),new loadListener());
	}
	
	
	//Inner class searchListener
	class searchListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String searchVal = m_view.searchTxt.getText();
			System.out.println("pressed search"+searchVal);
			
			if(m_model.mainDict) {
				if(m_model.dictionary.containsKey(searchVal)) {
					JOptionPane.showMessageDialog(new JFrame(), searchVal+"\n"+m_model.dictionary.get(searchVal));
				}else
					JOptionPane.showMessageDialog(new JFrame(), "No such key in the dictionary.");
			}else {
				if(m_model.fileDictionary.containsKey(searchVal)) {
					JOptionPane.showMessageDialog(new JFrame(), searchVal+"\n"+m_model.fileDictionary.get(searchVal));
				}else
					JOptionPane.showMessageDialog(new JFrame(), "No such key in the dictionary.");
			}
			
		}
		
	}//END OF CLASS
	
	//Inner class addListener
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String keyVal = m_view.keyTxt.getText();
			String defVal = m_view.valTxt.getText();
			
			
			if(m_model.mainDict) {
				m_model.dictionary.put(keyVal, defVal);
				System.out.println("pressed add"+keyVal+", "+defVal);
				m_view.dictLbl.setText(m_view.updateLbl(1));
			}else {
				m_model.fileDictionary.put(keyVal, defVal);
				System.out.println("pressed add"+keyVal+", "+defVal);
				m_view.dictLbl.setText(m_view.updateLbl(2));
			}
			
			
			
		}
		
	}//END OF CLASS
	
	//Inner class deleteListener
	class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String keyVal = m_view.keyTxt.getText();
			System.out.println("pressed delete"+keyVal);
			if(m_model.mainDict) {
				if(m_model.dictionary.containsKey(keyVal)) {
					m_model.dictionary.remove(keyVal);
					m_view.dictLbl.setText(m_view.updateLbl(1));
				}else
					JOptionPane.showMessageDialog(new JFrame(), "No such key in the dictionary.");
			
			}else {
				if(m_model.fileDictionary.containsKey(keyVal)) {
					m_model.fileDictionary.remove(keyVal);
					m_view.dictLbl.setText(m_view.updateLbl(2));
				}else
					JOptionPane.showMessageDialog(new JFrame(), "No such key in the dictionary.");
		
			}
			
		}
		
	}//END OF CLASS
	
	//Inner class updateListener
	class updateListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String keyVal = m_view.keyTxt.getText();
			String defVal = m_view.valTxt.getText();
			System.out.println("pressed update: "+keyVal+", "+defVal);
			
			if(m_model.mainDict) {
				if(m_model.dictionary.containsKey(keyVal)) {
					m_model.dictionary.replace(keyVal, defVal);				
					m_view.dictLbl.setText(m_view.updateLbl(1));
				}else
					JOptionPane.showMessageDialog(new JFrame(), "No such key in the dictionary.");
			}else {
				if(m_model.fileDictionary.containsKey(keyVal)) {
					m_model.fileDictionary.replace(keyVal, defVal);				
					m_view.dictLbl.setText(m_view.updateLbl(2));
				}else
					JOptionPane.showMessageDialog(new JFrame(), "No such key in the dictionary.");
			}
			
		}
		
	}//END OF CLASS
	
	//Inner class uploadListener
	class uploadListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("pressed upload");
			
			m_view.fileChooser = new JFileChooser();
			
			m_view.fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = m_view.fileChooser.showOpenDialog(m_view.fileLoader);
			if (result == JFileChooser.APPROVE_OPTION) {
			    m_view.selectedFile = m_view.fileChooser.getSelectedFile();
			    System.out.println("Selected file: " + m_view.selectedFile.getAbsolutePath());
			}
		}
		
	}//END OF CLASS
	
	//Inner class loadListener
	class loadListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("pressed load: ");
			
			openFile();
			readFile();
		}
		
		public void openFile() {
			
			try {
				input = new Scanner(new File(m_view.selectedFile.getAbsolutePath()));		
				
			} catch (FileNotFoundException e) {
//					e.printStackTrace();
				System.out.println("Counld not find file");
			}
		}
		
		public void readFile() {
			int lineNum = 1;
			String key = "";
			String val = "";
			m_model.fileDictionary = new TreeMap<String,String>();
			
			while(input.hasNextLine()) {
				
				String lineStr = input.nextLine();
				
				if(lineNum%2!=0) {
					System.out.println("key line "+lineNum);
					key = lineStr;
					
				}else if(lineNum%2==0) {
					System.out.println("val line "+lineNum);
					val = lineStr;
					m_model.fileDictionary.put(key, val);
				}
				
				lineNum++;
			}
			
			m_view.dictLbl.setText(m_view.updateLbl(2));
			m_model.mainDict=false;
			
		}
		
	}//END OF CLASS
	//open file
	
		

}
