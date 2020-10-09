public class Main {
	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println(stack.push(2));
		System.out.println(stack.push(4));
		System.out.println(stack.push(9));
		stack.display();
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


class Stack {
	private Node first, last;
	private int size;

	public Stack() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	public int push(int value) { //stack so push here is similar to unshift i.e add in start.
		Node newNode = new Node(value);
		if(this.first == null) {
			this.first = newNode;
			this.last = newNode;
		} else {
			newNode.setNext(this.first);
			this.first = newNode;
		}
		this.size++;
		return this.size;
	}

	//LAST IN FIRST OUT SO POP AND PUSH WORKED DIFFERENTLY.

	public int pop() { //stack so pop here is similar to shift i.e remove from front
		if(this.first == null) {
			return -1;
		} else {
			int value = this.first.getValue();
			this.first = this.first.getNext();
			this.size--;
			if(this.size == 0) { //agar sirf ek elem bachega
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



