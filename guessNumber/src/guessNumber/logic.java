package guessNumber;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;


public abstract class logic {

	static boolean win= true;	
	static int tries;
	static String[] guessNums; 
	static int[] boolseyes;
	static int[] hits;
	

//Main game function	
	protected static void startGame()
	{
		guessNums = new String[0];
		boolseyes = new int[0];
		hits = new int[0];
		win = false; 
		String randNum;
		String inpNum;
		tries=0;
		
		JOptionPane.showMessageDialog(new JFrame(), "Hello!\nTry to guess the number. 4 digits with no repeats.");
		randNum = createNum();
		
		while(!win)
		{
			do {
		    inpNum = getNum();}
			while (inpNum.length()==0);
		    
		    check(randNum,inpNum);	
		}
		
		if(win)
		{
			String res = results();
			JOptionPane.showMessageDialog(new JFrame(), "YOU WON!\nYour tries:\n"+res);
			playAgain();
		}
	}
	
	
	
//Helping methods	
//Ask about new game
	static void playAgain()
	{
		int result = JOptionPane.showConfirmDialog(new JFrame(), "Would you like to try again?", "Guess the Number game", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			startGame();
		}
	}
	
//Generate result string
	static String results()
	{
		String results ="";
		for(int i=0; i<tries; i++)
		{
			results+= (i+1)+": Guess - "+guessNums[i]+" boolseyes - "+boolseyes[i]+" hits - "+hits[i]+"\n";
		}
		return results;
	}
	
//Check repeating
	 static boolean isRepeating(String str) {	
		for(int i=0; i<4; i++)
		{
			int count = 0;
			for(int j=0; j<4; j++)
			{
				if(str.charAt(i)==str.charAt(j))
					count++;
			}	
			if(count>1)
				return true;
			count = 0;
		}
		return false;
	}

//Check if a String is numeric	
	 static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
//Get number from player	
	 static String getNum() 
	{		
		String input = JOptionPane.showInputDialog("Guess the number: ");
		
		if(!isNumeric(input) || input.length()!=4 || isRepeating(input))
	    {
			System.out.println("bad input: "+input);			//for debug
	    	JOptionPane.showMessageDialog(new JFrame(), "It wasn't a number or it wasn't 4 digits or a digit is repeating. Try again.");
	    	input="";
	    }else
	    {
			System.out.println("returning: "+input);  			//for debug			
	    }
		return input;
	}

//Generate a number	
	 static String createNum()
	{
		//Create a number
		List<Integer> numbers = new ArrayList<>();
	    for(int i = 0; i < 10; i++){
	        numbers.add(i);
	    }

	    Collections.shuffle(numbers);

	    String result = "";
	    for(int i = 0; i < 4; i++){
	        result += numbers.get(i).toString();
	    }	
	    return result;
	}
	
//Compare the random number and the input number	
	 static void check(String randNum, String inpNum) {
		System.out.println("randNum: "+randNum+" inpNum: "+inpNum);  		//for debug

		//add string to list or array
		int boolseye=0;
		int hit=0;
		
		for(int i=0; i<4 ; i++)
		{
			for(int j=0; j<4; j++)
			{
				if(randNum.charAt(i)==inpNum.charAt(j))
				{
					if (i==j)
						boolseye++;
					else
						hit++;
				}
			}
		}
		
		guessNums = Arrays.copyOf(guessNums, guessNums.length + 1);
		guessNums[guessNums.length - 1] = inpNum; 
		boolseyes = Arrays.copyOf(boolseyes, boolseyes.length + 1);
		boolseyes[boolseyes.length - 1] = boolseye; 
		hits = Arrays.copyOf(hits, hits.length + 1);
		hits[guessNums.length - 1] = hit; 
		tries++;
		
		if(boolseye==4)
		{
			JOptionPane.showMessageDialog(new JFrame(), "CORRECT!");	
			win = true;
		}else
		{
			JOptionPane.showMessageDialog(new JFrame(), "Your guess: "+inpNum+"\nYou got "+boolseye+ " boolseyes, and "+hit+" hits.");		
		}
		
		
	}
}

