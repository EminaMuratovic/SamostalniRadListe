
public class DoubleLinkedList {
	private Node head;
	private double size;
	
	public DoubleLinkedList() {
		head = null;
		size = 0;
	}
	
	public boolean contains(double value) {
		Node current = head;
		while(current.value != value) {
			current = current.next;
		}
		if(current.value == value)
			return true;
		return false;
	}

	public void add(double value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		newNode.previous = current;
		size++;
	}
	
	public void add(double value, int index) {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("...");
		Node newNode = new Node(value);
		if(index == 0) {
			head = newNode;
			size++;
			return;
		}
		Node current = head.next;
		Node previous = head;
		int counter = 1;
		while(counter < index) {
			current = current.next;
			previous = previous.next;
			counter++;
		}
		previous.next = newNode;
		newNode.next = current;
		newNode.previous = previous;
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

	public void remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("...");
		if (index == 0) {
			head = head.next;
			size--;
			return;
		}
		Node current = head.next;
		Node previous = head;
		int counter = 1;
		while (counter < index) {
			current = current.next;
			previous = previous.next;
			counter++;
		}
		previous.next = current.next;
		current.next = null;
		size--;

	}

	private class Node {
		public double value;
		public Node next;
		public Node previous;

		public Node(double value) {
			this.value = value;
			next = null;
			previous = null;
		}
	}

}

