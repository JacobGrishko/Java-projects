package primeNumbers;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;


public class Main {
	
	static int maxNum;
	static int processes;
	static LinkedList<CheckProcess> procList = new LinkedList<>();
	static TreeSet<Integer> _resultList = new TreeSet<Integer>();;
	
	//main method
	//1. get numbers from user.
	//2. create a list of numbers.
	//3. create threads.
	//4. check every second if there are still any threads.
	//5. when there are no threads, print finishing massage and list or prime numbers.
	public static void main(String[] args) {
		readNums();
		ListOfNums list = new ListOfNums(maxNum, processes, _resultList);
		createProc(list);
		
		while(procList.size()!=0) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("*******ALL FINISHED********");
		System.out.println("size of list is:" +_resultList.size());
		System.out.println(_resultList);
	}
	
	//get maximal number to check all primes, and a wanted number of threads
	public static void readNums() {

		boolean correct=false;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hello, choose the highest number to get all primal numbers from 2 to that number:");
		while(!correct) {
			String max = scan.next();
			try {
				maxNum = Integer.parseInt(max);
				if (maxNum<0)
					System.out.println("Please choose a positive number");
				else
					correct=true;
			}catch (NumberFormatException ex )
		    {
		        System.out.println("Thats not a number. please choose a positive number");   
		    }
		}
		
		correct=false;
		
		System.out.println("how many check would you like to run simoltaniously?");
		while(!correct) {
			String proc = scan.next();
			try {
				processes = Integer.parseInt(proc);
				if (maxNum<0)
					System.out.println("Please choose a positive number");
				else
					correct=true;
			}catch (NumberFormatException ex )
		    {
		        System.out.println("Thats not a number. please choose a positive number");   
		    }
		}
		
		scan.close();
	}
	
	//create a thread and add it to thread list
	public static void createProc(ListOfNums list) {
		System.out.println("creating processes");
		for(int i=0; i<processes; i++) {
			CheckProcess proc = new CheckProcess(list, i+1, procList);
			procList.add(proc);
			proc.start();
		}
		System.out.println("finished creating processes");
	}
	
}

