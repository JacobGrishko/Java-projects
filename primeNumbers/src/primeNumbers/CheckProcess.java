package primeNumbers;

import java.util.LinkedList;

public class CheckProcess extends Thread {
	
	ListOfNums _numList;
	int _id;
	LinkedList<CheckProcess> _procList;
	
	//Constructor
	public CheckProcess(ListOfNums list, int idNum, LinkedList<CheckProcess> procList) {
		_id = idNum;
		_numList = list;
		_procList = procList;
	}
	
	//run method for each thread.
	//1. get the next available number from the list.
	//2. check if the number is a prime number.
	//3. if yes, add to list of prime numbers, if not, continue.
	//4. if there is no new available number, remove yourself from processes list.
	
//	@SuppressWarnings("deprecation")
	public void run() {
		System.out.println("new process started..");

		int num = _numList.getNext();
		int root = (int) Math.sqrt(num);
		System.out.println("num: "+num+" root: "+root);
		
		while(num!=0) {			
			boolean prime = true;

			for(int i=2;i<root+1; i++) {
				double res = num%i;
				if(res==0) {
					prime=false;
					break;
				}	
			}
		
			if(prime) {
				System.out.println("PROC "+_id+". "+num+" is prime"); //for debug
				_numList.addToList(num);
				
			}

			num = _numList.getNext();
			root = (int) Math.sqrt(num);
		}
		
		System.out.println("current size of numList is: "+_numList._resultList.size()); //for debug
		System.out.println("process "+_id+" finished."); //for debug
		_procList.remove(this);
		
	}
}
