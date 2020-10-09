import java.util.*;
public class Main {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.enqueue(21, 4);
		pq.enqueue(99, 2);
		pq.enqueue(1, 12);
		pq.enqueue(9900, 30);
		pq.enqueue(82, 3);
		pq.enqueue(15, 1);
		pq.display();
		pq.dequeue();
		pq.display();
		pq.dequeue();
		pq.display();
		pq.dequeue();
		pq.display();
		pq.dequeue();
		pq.display();
		pq.dequeue();
		pq.display();
		pq.dequeue();
		pq.display();
		pq.dequeue();
		pq.display();
		pq.dequeue();
		pq.display();
		pq.dequeue();
		pq.display();
	}

}

class Node {
	private int val, priority;

	public Node(int val, int priority) {
		this.val = val;
		this.priority = priority;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getVal() {
		return this.val;
	}

	public int getPriority() {
		return this.priority;
	}
}


//isko minBinaryHeap ke jaise implement karenge only difference is that there is a new
//Node class with two values(int val, int priority) and values are set as per the priority
//smaller the number(of priority), higher is the priority.
class PriorityQueue {
	private ArrayList<Node> values;

	public PriorityQueue() {
		values = new ArrayList<>();
	}

	public void enqueue(int val, int priority) {
		Node newNode = new Node(val, priority);
		int parentIndex, newNodeIndex;
		values.add(newNode);
		while(values.size() > 1) {
			newNodeIndex = values.indexOf(newNode);
			parentIndex = (int)Math.floor((newNodeIndex - 1) / 2);
			//parentPriority < newValPriority (priority value kam matlab high priority).
			if(values.get(parentIndex).getPriority() > newNode.getPriority()) {   
				values.set(newNodeIndex, values.get(parentIndex));
				values.set(parentIndex, newNode);
			} else {
				return;
			}
		} 		
	}



	public int dequeue() {
		if(values.size() == 0) {
			System.out.println("No elements to remove.");
			return -1;
		} else {
			int rootElement = values.get(0).getVal();
			int len = values.size();
			if(len > 1) {
				values.set(0, values.get(len - 1));
				sinkDown(values);
			}
			values.dequeue(len - 1);
			return rootElement;
		}
	}

	private void sinkDown(ArrayList<Node> values) {
		int parentIndex = 0, child1Index, child2Index;
		Node parentValue, child1Value, child2Value;
		while(true) {
			parentValue = values.get(parentIndex); 
			child1Index = 2 * parentIndex + 1;
			child2Index = 2 * parentIndex + 2;

			//both child indexes are valid i.e.., less than total array size
			if(child1Index < values.size() && child2Index < values.size()) {
				child1Value = values.get(child1Index);
				child2Value = values.get(child2Index);
				
				//atleast one child is bigger than parent
				if(( child1Value.getPriority() < parentValue.getPriority() ) ||
					( child2Value.getPriority() < parentValue.getPriority()) ) {
					
					if(child1Value.getPriority() < child2Value.getPriority()) {
						values.set(child1Index, parentValue); //swap child1-parent
						values.set(parentIndex, child1Value);
						parentIndex = child1Index;
					} else if(child2Value.getPriority() < child1Value.getPriority()){
						values.set(child2Index, parentValue); //swap child2-parent
						values.set(parentIndex, child2Value);
						parentIndex = child2Index;
					}

				} else {
					break;
				}

				//only one child is valid
			} else if(child1Index < values.size()) {
				child1Value = values.get(child1Index);
				
				//child one is bigger than parent
				if(child1Value.getPriority() < parentValue.getPriority()) {
					values.set(child1Index, parentValue); //swap child1-parent
					values.set(parentIndex, child1Value);
					parentIndex = child1Index;
				} else {
					break;
				}

			} else {
				break;
			}
		}
	}


	//display karte time priorities aur unke childrens ko min heap ke format mein dekh.
	// ki right hai ki nahi
	public void display() {
		System.out.print("Queue:- ");
		for(int i=0; i<values.size(); i++) {
			System.out.print(values.get(i).getVal()+" '"+values.get(i).getPriority()+"' ---> ");
		}
		System.out.println();
	}


}