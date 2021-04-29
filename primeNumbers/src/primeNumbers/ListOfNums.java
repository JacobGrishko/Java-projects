package primeNumbers;

import java.util.TreeSet;

public class ListOfNums {

	int _highestNum;
	int _processes;
	int _current;
	TreeSet<Integer> _resultList;
	
	
	//constructor
	public ListOfNums(int highestNum, int processes, TreeSet<Integer> resultList) {
		System.out.println("creating listOfNums");
		_highestNum = highestNum;
		_processes = processes;
		_current = 2;
		_resultList = resultList;
	}
	
	//get next number for check. starting with 1. Can be used by only 1 process at a time.
	public synchronized int getNext() {
		
		int next = _current;

		if(_current<_highestNum+1) {
			_current++;
			return next; 
		}else
			return 0;
		
	}
	
	//add new prime number to result list
	public synchronized void addToList(int num) {
		_resultList.add(num);
	}
	
}
