public class Main {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.push(2);
		list.push(4);
		list.push(5);
		list.push(17);
		list.push(81);
		list.push(33);
		list.display();
		list.reverse();
		list.display();

		// list.displayFromTail();
	}
}


class Node {
	private Node prev, next;
	private int value;

	public Node(int value) {
		this.value = value;
		this.prev = null;
		this.next = null;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getPrev() {
		return this.prev;
	}

	public Node getNext() {
		return this.next;
	}

	public int getValue() {
		return this.value;
	}
}


class DoublyLinkedList {
	private Node head, tail;
	private int length;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	public void push(int value) {
		Node newNode = new Node(value);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			newNode.setPrev(this.tail);
			this.tail = newNode;
		}
		length++;
	}

	public int pop() {
		if(this.head == null) {
			return -1;
		} else {
			int value = this.tail.getValue(); //agar ek hi value hai toh(head ko bhi null isliye special)
			if(this.head == this.tail) {
				this.head = null;
				this.tail = null; 
			} else {
				Node newTail = this.tail.getPrev(); //but ek se jyada value hai toh
				// this.tail.setPrev(null);
				this.tail = newTail;
				this.tail.setNext(null);
			}
			length--;
			return value;
		}
	}

	public int shift() {
		if(this.head == null) {
			return -1;
		} else {
			int value = this.head.getValue();
			if(this.head == this.tail) { //for only one element.
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.getNext(); //more than one elem. cutting connect. with head.
				this.head.setPrev(null);
			}
			length--;
			return value;
		}
	}

	public void unShift(int value) {
		Node newNode = new Node(value);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.setNext(this.head);
			this.head.setPrev(newNode);
			this.head = newNode;
		}
		length++;
	}

	public int get(int index) {	//access by position/index.
		if(index < 0 || index >= this.length) {
			return -1;
		} else {
			Node iterator;
			int count;
			if(index <= this.length / 2) { //iterate from start as index near to head
				iterator = this.head;
				count = 0;
				while(count < index) {
					iterator = iterator.getNext();
					count++;
				}
			} else {					//iterate from end as index near to tail
				iterator = this.tail;
				count = this.length - 1;
				while(count > index) {
					iterator = iterator.getPrev();
					count--;
				}
			}
			return iterator.getValue();
		}
	}

	//one can use get method here as well to find the node and replace with the desired newValue.
	public boolean set(int index, int newValue) { //replace existing node value
		if(index < 0 || index >= this.length) {
			return false;
		} else {
			Node iterator;
			int count;
			if(index <= this.length / 2) { //iterate from start as index near to head
				iterator = this.head;
				count = 0;
				while(count < index) {
					iterator = iterator.getNext();
					count++;
				}
			} else {					//iterate from end as index near to tail
				iterator = this.tail;
				count = this.length - 1;
				while(count > index) {
					iterator = iterator.getPrev();
					count--;
				}
			}
			iterator.setValue(newValue);
			return true;
		}
	} 


	public boolean insert(int index, int newValue) {
		if(index < 0 || index > this.length) {
			return false;
		} else if(index == 0) {
			unShift(newValue);
			return true;
		} else if(index == this.length) {
			push(newValue);
			return true;
		} else {
			Node newNode = new Node(newValue);
			Node iterator;
			int count;
			if(index <= this.length / 2) { //iterate from start as index near to head
				iterator = this.head;
				count = 0;
				while(count < index) {
					iterator = iterator.getNext();
					count++;
				}
			} else {					//iterate from end as index near to tail
				iterator = this.tail;
				count = this.length - 1;
				while(count > index) {
					iterator = iterator.getPrev();
					count--;
				}
			}

			Node prev = iterator.getPrev();
			
			iterator.setPrev(newNode);		//newNode ka with nextNode connection
			newNode.setNext(iterator);

			prev.setNext(newNode);			//newNode ka with prevNode connection
			newNode.setPrev(prev);

			this.length++;
			return true;
		}
	} 

	public int remove(int index) {
		if(index < 0 || index >= this.length) {
			return -1;
		} else if(index == 0) {
			return shift();
		} else if(index == this.length - 1) {
			return pop();
		} else {
			Node iterator;
			int count;
			if(index <= this.length / 2) { //iterate from start as index near to head
				iterator = this.head;
				count = 0;
				while(count < index) {
					iterator = iterator.getNext();
					count++;
				}
			} else {					//iterate from end as index near to tail
				iterator = this.tail;
				count = this.length - 1;
				while(count > index) {
					iterator = iterator.getPrev();
					count--;
				}
			}

			Node prev = iterator.getPrev();
			Node next = iterator.getNext();
			
			prev.setNext(next);			//bichka iterator ko nikalke naye connections
			next.setPrev(prev);			//..between prev <-> next.

			this.length--;
			return iterator.getValue();
		}
	}

	public boolean reverse() {
		if(length == 0) {
			System.out.println("No linked list present.");
			return false;
		} else {
			Node iterator = this.head;
			this.head = this.tail;
			this.tail = iterator;
			Node prev = iterator.getPrev();
			Node next = iterator.getNext();
			while(iterator.getNext() != null) {
				iterator.setNext(prev);
				iterator.setPrev(next);
				prev = iterator;
				iterator = next;
				next = next.getNext(); 
			}
			iterator.setNext(prev);
			iterator.setPrev(next);

			return true;
		}
		
	}


	public void display() {
		Node iterator = this.head;
		while(iterator != null) {
			System.out.print(iterator.getValue() + " -> ");
			iterator = iterator.getNext();
		}
		System.out.println("\t:Beg ");
	}

	public void displayFromTail() {
		Node iterator = this.tail;
		while(iterator != null) {
			System.out.print(iterator.getValue() + " -> ");
			iterator = iterator.getPrev();
		}
		System.out.println("\t:End");
	}

	// public void modifiedDisplayFromTail() {
	// 	Node iterator = this.tail;
	// 	while(iterator != null) {
	// 		if(iterator.getPrev() != null) {
	// 			System.out.print("P:"+iterator.getPrev().getValue() + " , ");
	// 		}
	// 		if(iterator.getNext() != null) {
	// 			System.out.print("N:"+iterator.getNext().getValue() + " , ");
	// 		}
	// 		System.out.print(iterator.getValue() + " -> ");
	// 		iterator = iterator.getPrev();
	// 	}
	// 	System.out.println();
	// }

}