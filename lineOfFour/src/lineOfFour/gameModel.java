package lineOfFour;


public class gameModel {
	
	public static int[][] lineOfour = new int[6][7];
	public int enabledBtns;
	private int turn;
	
	
	//Constructor
	public gameModel ()
	{
		lineOfour = new int[6][7];
		turn=1;
		enabledBtns=7;
		zeroize();
		printTest();
	}

	//Zeroize the 2D array for new game
	public void zeroize()
	{
		for(int i=0; i<6;i++) {
			for(int j=0; j<7; j++) {
				lineOfour[i][j] = 0;
			}
		}
	}
	
	
	//for debug, printing 2D array of current result
	public void printTest()
	{
		for(int i=0; i<6;i++) {
			for(int j=0; j<7; j++) {
				System.out.print(lineOfour[i][j]);
			}
			System.out.println("\n");
		}
	}
	
	//set next turn
	public void nextTurn() {
		if (turn==1)
			turn=2;
		else if(turn==2)
			turn=1;
	}
	
	//return current turn
	public int curTurn() {
		return turn;
	}
	
	//set turn
	public void setTurn() {
		turn=1;
	}
	
	
	// Checking if there is a win
	// from the last input disk, it will count how many disks in a row from the same color there are. Vertical, Horizontal and Diagonal.
	public boolean checkLine(int line, int col) {
		int disks = 1;
		int steps = 1;
		boolean check=true;


//		//****************************************VERTICAL
//		//check down
//		System.out.println("------------checking VERTICAL");	
		while(check) {
			if((line+steps)>-1 && (line+steps)<6) {
				System.out.println("in boundries");
				if(lineOfour[line+steps][col]==turn) {
					disks++;
					steps++;
				}else {
					check=false;
				}
				
			}else {
				check=false;
			}
			
		}
		
		steps = 1;
		check = true;
		
		while(check) {
			if((line-steps)>-1 && (line-steps)<6) {
				if(lineOfour[line-steps][col]==turn) {
					disks++;
					steps++;
				}else {
					check=false;
				}
			}else {
				check=false;
			}
			
		}
		if (disks>3) {
			System.out.println("won. last point is: "+line+","+col);
			return true;
		}
		
		disks = 1;
		steps = 1;
		check = true;
		//****************************************HORIZONTAL
		//**************************check right
		while(check) {
			if((col+steps)>-1 && (col+steps)<7) {
				if(lineOfour[line][col+steps]==turn) {
					disks++;
					steps++;
				}else {
					check=false;
				}
				
			}else {
				check=false;
			}
			
		}
		
		steps = 1;
		check = true;
		
		//*************************check left
		while(check) {
			if((col-steps)>-1 && (col-steps)<7) {
				if(lineOfour[line][col-steps]==turn) {
					disks++;
					steps++;
				}else {
					check=false;
				}
				
			}else {
				check=false;
			}
			
		}
		if (disks>3) {
			System.out.println("won. last point is: "+line+","+col);
			return true;
		}
		
		disks = 1;
		steps = 1;
		check = true;
		
		//****************************************DIAGONAL left up
		//**************************check right		
		while(check) {
			if((col+steps)>-1 && (col+steps)<7 && (line+steps)>-1 && (line+steps)<6) {
				if(lineOfour[line+steps][col+steps]==turn) {
					disks++;
					steps++;
				}else {
					check=false;
				}
				
			}else {
				check=false;
			}
			
		}
		
		steps = 1;
		check = true;
		
		//*************************check left
		while(check) {
			if((col-steps)>-1 && (col-steps)<7 && (line-steps)>-1 && (line-steps)<6) {
				if(lineOfour[line-steps][col-steps]==turn) {
					disks++;
					steps++;
				}else {
					check=false;
				}
				
			}else {
				check=false;
			}
			
		}
		if (disks>3) {
			System.out.println("won. last point is: "+line+","+col);
			return true;
		}
		
		disks = 1;
		steps = 1;
		check = true;
		
		//****************************************DIAGONAL left down
		//**************************check right		
		while(check) {
			if((col+steps)>-1 && (col+steps)<7 && (line-steps)>-1 && (line-steps)<6) {
				if(lineOfour[line-steps][col+steps]==turn) {
					disks++;
					steps++;
				}else {
					check=false;
				}
				
			}else {
				check=false;
			}
			
		}
		
		steps = 1;
		check = true;
		
		//*************************check left
		while(check) {
			if((col-steps)>-1 && (col-steps)<7 && (line+steps)>-1 && (line+steps)<6) {
				if(lineOfour[line+steps][col-steps]==turn) {
					disks++;
					steps++;
				}else {
					check=false;
				}
				
			}else {
				check=false;
			}
			
		}
		if (disks>3) {
			System.out.println("won. last point is: "+line+","+col);
			return true;
		}
			
		
		
		
		return false;
	}
	
}
