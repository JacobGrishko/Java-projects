
public class genericList<T> {
	
	private static final Exception EmptyListException = null;
	Node head;
	Node tail;
	
	//initiate the list
	public genericList() {
		head = null;
		tail = null;
	}
	
	//return head node (0) or tail node(1)
	public Node returnHeadTail(int option) {
		if(option==0)
			return head;
		else if(option==1)
			return tail;
		else {
			System.out.println("choose 0 for head, or 1 for tail. reterning head as default");
			return head;
		}
	}
	
	//add a value to end of the list
	public void add(T value) {	
		Node node = new Node(value);
		
		if(head==null) {
			head = node;
			tail = node;
		}
		
		tail.next = node;
		tail = node;
	}
	
	//remove the first node
	public T remove() throws Exception {
		if (head == null)
			throw EmptyListException;
	
		T tempVal = (T) head.value;
		
		if (head == tail) {
			head = null;
			tail = null;
		}else {
			head = head.next;
		}

		return tempVal;
	}
	
	//return string of all the values
	public String toString() {
		String str = "";
		Node tempNode = head;
		
		while(tempNode!=null) {
			str+=tempNode.value + "\n";
			tempNode = tempNode.next;
		}
		return str;
	}
}
