import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		getList();
	
		System.out.println("creating list of people...");
		genericList<Person> persons =createPersonList();
		System.out.println("checking oldest...");
		Person oldest = max(persons);
		System.out.println("Oldest person is: "+oldest.getPersonName());
	}
	
	//create a list and then invert it
	public static void getList() {
		genericList<String> list = new genericList<String>();
		
		Scanner myObj = new Scanner(System.in);
		
		for(int i=1; i<7; i++) {
			System.out.println("Enter String number "+i+" out of 6:");
			String input = myObj.nextLine();
			list.add(input);
		}
		
		System.out.println("Finished scanning.");
		String listStr = list.toString();
		System.out.println("printing list");
		System.out.println(listStr);
		
		System.out.println("***************************");
		System.out.println("now inverted:");
		
		genericList<String> listInverted = new genericList<String>();
		Node currNode = list.returnHeadTail(1);
		Node temp = list.returnHeadTail(0);
		String val;
		
		while(list.returnHeadTail(0)!=currNode) {
			while(temp.next!=currNode) {
				temp = temp.next;
			}
			val = (String) currNode.getVal();
			listInverted.add(val);
			currNode = temp;
			temp = list.returnHeadTail(0);
		}
		
		val = (String) currNode.getVal();
		listInverted.add(val);
		currNode = temp;
		
		System.out.println("Finished Inverting.");
		listStr = listInverted.toString();
		System.out.println("printing inverted list");
		System.out.println(listStr);
		
		System.out.println("***************************");
		
		
	}
	
	//choose max value
	static <T> T max(genericList<T> list) {	
		Node currNode = list.head;
		Node nextNode = list.head.next;
		
		T currMax = (T) currNode.getVal();
		
		T currVal = (T) currNode.getVal();
		T nextVal = (T) nextNode.getVal();

		 do{
			if(currMax.equals(nextVal)) {
				currMax = nextVal;
				
			}else if(!currMax.equals(nextVal))
			
			nextNode = nextNode.next;
			if(nextNode!=null)
				nextVal = (T) nextNode.getVal();
			
		}while(nextNode!=null);
		
		return currMax;
	}
	
	//initiate a list
	static genericList<Person> createPersonList() {

		Person p1 = new Person("jacob",123456789,1992);
		Person p2 = new Person("alex",111222333,2000);
		Person p3 = new Person("dima",222333444,1800);
		Person p4 = new Person("yosi",333444555,2020);
		
		genericList<Person> personList = new genericList<Person>();
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		return personList;
		
	}

	
}
