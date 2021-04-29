
public class Node<T> {
	
	T value;
	Node next;
	
	//create a node with a value
	public Node(T val) {
		value = val;
		next = null;
	}
	
	//create a node with a pointer to the next
	public Node(T val, Node nextNode) {
		value = val;
		next = nextNode;
	}

	//return value
	public T getVal() {
		return value;
	}
	
	//set value
	public void setVal(T val) {
		value = val;
	}
	
	//return next node
	public Node getNext() {
		return next;
	}
	
	//set next node
	public void setNext(Node nextNode) {
		next = nextNode;
	}

	
	
}
