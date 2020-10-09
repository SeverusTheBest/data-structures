public class Main {
	public static void main(String[] args) {
		Queue q = new Queue();
		System.out.println(q.enQueue(2));
		System.out.println(q.enQueue(4));
		System.out.println(q.enQueue(8));
		q.display();
		System.out.println(q.deQueue());
		q.display();
		System.out.println(q.deQueue());
		q.display();
		System.out.println(q.deQueue());
		q.display();
	}
}


class Node {
	private int value;
	private Node next;

	public Node(int value) {
		this.value = value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public Node getNext() {
		return next;
	}

}

//FIRST IN FIRST OUT FUNDA USED HERE

class Queue {
	private Node first, last;
	private int size;

	public Queue() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}


	//Enter elements at the end and remove from beginning(hence satisfying FIFO).
	public int enQueue(int value) {
		Node newNode = new Node(value);
		if(this.first == null) {
			this.first = newNode;
			this.last = newNode;
		} else {
			this.last.setNext(newNode);
			this.last = newNode;
		}
		this.size++;
		return this.size;
	}


	public int deQueue() {
		if(this.first == null) {
			return -1;
		} else {
			int value = this.first.getValue();
			this.first = this.first.getNext();
			this.size--; 
			if(this.size == 0) {
				this.last = null;
			}

			return value;
		}
	}
	


	public void display() {
		Node iterator = this.first;
		while(iterator != null) {
			System.out.print(iterator.getValue()+ " -> ");
			iterator = iterator.getNext();
		}
		System.out.println();
	}

}
