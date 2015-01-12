
public class SortedLinkedListInt {
	private Node head;
	private int size;
	
	public SortedLinkedListInt() {
		head = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean contains(int value) {
		Node current = head;
		while(current.value != value) {
			current = current.next;
		}
		if(current.value == value)
			return true;
		return false;
	}
	
	public void add(int value) {
		Node newNode = new Node(value);
		if(head.value == value) {
			head = newNode;
			size++;
			return;
		}
		Node current = head.next;
		Node previous = head;
		while(current.value < value) {
			current = current.next;
			previous = previous.next;
		}
		previous.next = newNode;
		newNode.next = current;
		size++;
	}
	
	public String toString() {
		String str = "";
		Node current = head;
		str += "[ ";
		while (current != null) {
			str += current.value;
			if (current.next != null)
				str += ", ";
			current = current.next;
		}
		str += " ]";
		return str;
	}
	
	
	private class Node {
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value = value;
			next = null;
		}
	}
	

}
