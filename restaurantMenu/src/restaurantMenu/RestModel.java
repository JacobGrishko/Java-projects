package restaurantMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class RestModel {
	
	public ArrayList<String> firsts = 			new ArrayList<String>();
	public ArrayList<Double> firstsPrice =	 	new ArrayList<Double>();
	
	public ArrayList<String> maincourses = 		new ArrayList<String>();
	public ArrayList<Double> maincoursesPrice = new ArrayList<Double>();
	
	public ArrayList<String> deserts = 			new ArrayList<String>();
	public ArrayList<Double> desertsPrice = 	new ArrayList<Double>();
	
	public ArrayList<String> drinks = 			new ArrayList<String>();
	public ArrayList<Double> drinksPrice = 		new ArrayList<Double>();
	
	private Scanner input;
	private int step=1;
	private int lineNum=1;
	
	private static String name="";
	private static String kind="";
	private static Double price = 0.0;
	
	public RestModel() {
		openFile();
		readFile();
		testPrint();		//for debug
		closeFile();
	}
	
	//open file
	public void openFile() {
		
		try {
			input = new Scanner(new File("Menu.txt"));
			
			
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("Counld not find file");
		}
	}
	
	//read from text file Menu.txt
	public void readFile() {
		while(input.hasNextLine()) {
			String line = input.nextLine();

			if(step==1) {
				name = line;
				nextStep();
				lineNum++;
					
			}else if(step==2) {
				kind = line;
				nextStep();
				lineNum++;
				
			}else if (step==3) {
				try {
					price = Double.parseDouble(line);
					
				}catch(NumberFormatException e) {
					System.out.println("Thats not a double number in line "+lineNum);
				}
				
				lineNum++;

				
				if(kind.equals("First")) {
					firsts.add(name);
					firstsPrice.add(price);
				}else if(kind.equals("Main course")) {
					maincourses.add(name);
					maincoursesPrice.add(price);
					
				}else if(kind.equals("Desert")) {
					deserts.add(name);
					desertsPrice.add(price);
				}else if(kind.equals("Drink")) {
					drinks.add(name);
					drinksPrice.add(price);
				}else {
					System.out.println("Sorry, theres no such dish "+kind);
					return;
				}
				
				nextStep();
			}
		}
		
	}
	
	//close file
	public void closeFile() {
		input.close();
	}
	
	//step 1: read dish, step 2: read category, step 3: read price
	public void nextStep(){
		if (step==1)
			step=2;
		else if(step==2)
			step=3;
		else if(step==3)
			step=1;
	}
	
	//for debug, print all from menu
	public void testPrint() {
		
		System.out.println("firsts size:"+ firsts.size());
		System.out.println("main size:"+ maincourses.size());
		System.out.println("deserts size:"+deserts.size());
		System.out.println("drinks size:"+ drinks.size());
		
		if(firsts.size()!=0) {
			for (int i=0; i<firsts.size(); i++) {
				System.out.println("name: "+firsts.get(i) +" Price: "+firstsPrice.get(i));
			}
		}

		if(maincourses.size()!=0) {
			for (int i=0; i<maincourses.size(); i++) {
				System.out.println("name: "+maincourses.get(i) +" Price: "+maincoursesPrice.get(i));
			}	
		}

		if(deserts.size()!=0) {
			for (int i=0; i<deserts.size(); i++) {
				System.out.println("name: "+deserts.get(i) +" Price: "+desertsPrice.get(i));
			}
		}

		if(drinks.size()!=0) {
			for (int i=0; i<drinks.size(); i++) {
				System.out.println("name: "+drinks.get(i) +" Price: "+drinksPrice.get(i));
			}
		}

	}
	

}
