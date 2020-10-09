import java.util.*;
public class Main {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.push(82);
		list.push(11);
		list.push(72);
		list.push(20);
		list.push(73);
		list.push(3);
    list.display();

    list.pushToMakeCycle(15);
    // list.display();

    list.cycleDetection();
	
    list.findStartNodeOfTheLoop();
  }
}

// "NOTE:" From the singlyLinkedList folder this advanced folder has 
//         new following new methods:-
//       -> 1. cycleDetection(): To detect if there exists a cycle in the linked list
//       -> 2. pushToMakeCycle(): To just create a cycle in linked list, this method 
//                               was just created for debugging
//       -> 3. findMiddleOfList(): return the middle element of the linked list
//       -> 4. findMiddleOfListByTwoPointer(): return the middle element of 
//                                           ...the linked list by diff. method.
//       -> 5. deleteNnodesAfterMnodes()
//       -> 6. findStartNodeOfTheLoop()

class Node {
	private int value;
	private Node next;

	public Node(int value) {
		this.value = value;
		this.next = null;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return next;
	}

	public void setVal(int val) {
		this.value = val;
	}

	public int getVal() {
		return value;
	}
}

class SinglyLinkedList {
	private Node head, tail;
	private int length;

	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	public int getLength() {
		return this.length;
	} 

	public void push(int n) {
		Node newNode = new Node(n);
		length++;
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);//current element ka "next" naye node ko point karega. 
			this.tail = newNode;//aur tail element ab naye node pe chale jaega.
		}
	}

	public int pop() {
		if(this.head != null) {
			Node iterator = this.head;
			Node pre = iterator;
			while(iterator.getNext() != null) {
				pre = iterator;
				iterator = iterator.getNext();
			}
			this.tail = pre;//point kare 2nd tail element pe isliye kyuki iterator tail elem.
			//...pe aa jata hai.
			this.tail.setNext(null);//2ndlast ko point karva ke ab tail elemnt null ko point
			//...kare isliye yeh kiya.
			length--;
			if(length==0) {
				this.head = null;
				this.tail = null;
			}
			return iterator.getVal();
		} else {
			return -1;
		}
	} 

	public int shift() {
		if(this.head != null) {
			int value = this.head.getVal();
			this.head = this.head.getNext();
			length--;
			if(length == 0) {
				this.tail = null;
				return value;
			}
			return value;
		} else {
			return -1;
		}
	}

	public void unShift(int value) {
		Node newNode = new Node(value);
		newNode.setNext(this.head);
		this.head = newNode;
		length++;
		if(length==1) {
			this.tail = newNode;
		}
	}

	public int get(int index) { //return element at that index
		if(index<0 || index>=length) {
			return -1;
		} else {
			Node iterator = this.head;
			for(int i=0; i<index; i++) {
				iterator = iterator.getNext();
			}
			return iterator.getVal();
		}
	}

// Changing the value of node based on its postn in linked list.
	public boolean set(int index, int newValue) { 
		if(index<0 || index>=length) {
			return false;
		} else {
			Node iterator = this.head;
			for(int i=0; i<index; i++) {
				iterator = iterator.getNext();
			}
			iterator.setVal(newValue); //replacing oldvalue to new.
			return true;
		}
	}

//insert instead of updating existing value adds a new one
	public boolean insert(int index, int value) {
		if(index < 0 || index > length) {
			return false;
		} else if(index == 0) {
			unShift(value);
			return true;
		} else if(index == length) {
			push(value);
			return true;
		} else {
			Node iterator = this.head;
			Node pre = this.head;
			for(int i=0; i<index; i++) {
				pre = iterator;
				iterator = iterator.getNext();
			}
			length++;
			Node newNode = new Node(value);//newnode
			newNode.setNext(iterator);//newnode->next set kiya
			pre.setNext(newNode);  //pre->next newnode set kiya
			return true;
		}
	}  

//removes the element at the given index
	public int remove(int index) {
		if(index<0 || index>=length) {
			return -1;
		} else if(index == 0) {
			return shift();
		} else if(index == length-1) {
			return pop();
		} else {
			Node iterator = this.head;
			Node pre = this.head;
			for(int i=0; i<index; i++) {
				pre = iterator;
				iterator = iterator.getNext();
			}
			length--;
			pre.setNext(iterator.getNext()); //pre->nextKaNext set kiya bcos beech ka uda diya
			return iterator.getVal();
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
			Node pre = null;
			Node next;
			while(iterator.getNext() != null) {
				System.out.println(iterator.getVal());
				next = iterator.getNext();
				iterator.setNext(pre);
				pre = iterator;
				iterator = next;
			}
			iterator.setNext(pre);

			return true;
		}
	}

  //---=-=-=-=-=-=-=-=-=-=--=-=-=-UPDATED PART-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=

  public void pushToMakeCycle(int n) {
    Node newNode = new Node(n);
    length++;

    //below code for finding the the 3rd node(randomly taken) so that we can attach
    //.. to it to make cycle. and then change the last line and connect with iterator.
    // but currently we are attaching to the head. 
    // Node iterator = this.head;
    // int i=1; 
    // while(i<3) {
    //   iterator = iterator.getNext();
    //   i++;
    // }

    if(this.head == null) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.setNext(newNode);//current element ka "next" naye node ko point karega. 
      this.tail = newNode;//aur tail element ab naye node pe chale jaega.

      //---------Difference from 'push' method--------
      newNode.setNext(this.head);
    }
  }


	public boolean cycleDetection() {
		Node slowNode = this.head;
		Node fastNode = this.head;
		while(slowNode != null && fastNode != null && fastNode.getNext() != null) {
			slowNode = slowNode.getNext();   // tortoise node moves by 1.
      fastNode = fastNode.getNext().getNext();  // Hare Node moves by 2.
		  if(slowNode == fastNode) {
        // System.out.println(slowNode.getVal() + ", " + fastNode.getVal());
        System.out.println("Cycle Exists.");
        return true;
      }
    }
    System.out.println("No cycle detected.");
    return false;
	}


  // this method finds the middle by simply finding th elength of the linked list 
  //... and then traversing again about half the length and returns the current elem.
  public void findMiddleOfList() {
    Node iterator = this.head;
    int counter = 1;

    while(iterator.getNext() != null) {
      iterator = iterator.getNext();
      counter++;
    }

    iterator = this.head;
    int i=1;
    while(i <= counter/2) {
      iterator = iterator.getNext();
      i++;
    }
    System.out.println("The middle element of the linked list is: "+iterator.getVal());
  }

  // we again find the middle element here, the only difference is that we use a
  //... different approach of two pointers here(hare and tortoise method).
  public void findMiddleOfListByTwoPointer() {
    Node slowNode = this.head;
    Node fastNode = this.head;
    while(fastNode!=null && fastNode.getNext()!=null) {
      slowNode = slowNode.getNext();
      fastNode = fastNode.getNext().getNext();
    }
    System.out.println("The middle element of the linked list is: "+slowNode.getVal());
  }

  public void deleteNnodesAfterMnodes(int n, int m) {
    Node iterator = this.head;
    Node previous = iterator;

    int counter = 1;
    while(counter <= n+m) {
      if(counter == n) {
        previous = iterator;        
      }
      iterator = iterator.getNext();
      counter++;
    }
    System.out.println(previous.getVal() + "--" +iterator.getVal());
    previous.setNext(iterator);
  }


  //this will only work if cycle exists
  //--STEP1: Proceed in the usual way, you will use to find the loop, i.e. Have two 
  //  ...pointers, increment one in single step and other in two steps, If they 
  //  ...both meet in sometime, there is a loop.
  //--STEP2: Freeze one pointer where it was and increment the other pointer in one 
  //  ...step counting the steps you make and when they both meet again, the count will
  //  ...give you the length of the loop (this is same as counting the number of 
  //  ...elements in a circular link list).
  //--STEP3: Reset both pointers to the start of the link list, increment one pointer 
  //  ...to the length of loop times and then start the second pointer. 
  //  ...increment both pointers in one step and when they meet again, it will be the
  //  ...start of the loop (this is same as finding the nth element from the end of the
  //  ...link list).
  public void findStartNodeOfTheLoop() {
    Node slowNode = this.head;
    Node fastNode = this.head;
    int lengthOfLoop = 0;

    while(true) {
      slowNode = slowNode.getNext();   // tortoise node moves by 1.
      fastNode = fastNode.getNext().getNext();  // Hare Node moves by 2.
      if(slowNode == fastNode) {
        slowNode = slowNode.getNext();
        lengthOfLoop++;

        while(slowNode != fastNode) {
          slowNode = slowNode.getNext();
          lengthOfLoop++;          
        }
        System.out.println("Length of the loop: " + lengthOfLoop);
        break;
      }
    }

    slowNode = this.head;
    fastNode = this.head;
    for(int i=0; i<lengthOfLoop; i++) {
      slowNode = slowNode.getNext();
    } 

    while(slowNode != fastNode) {
      slowNode = slowNode.getNext();
      fastNode = fastNode.getNext();
    }

    System.out.println("Start of the loop is: " + slowNode.getVal());
  }










	public void display() {
		Node iterator = this.head;
		System.out.print("List: ");
		while(iterator != null) { 
			System.out.print(iterator.getVal()+" -> ");
			iterator = iterator.getNext();
		}
		System.out.println();
	}

	public void delete() {
		this.head = null;
		this.tail = null;
	}

}