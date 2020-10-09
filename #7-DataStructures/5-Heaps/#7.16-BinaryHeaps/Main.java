import java.util.*;
public class Main {
	public static void main(String[] args) {
		MaxBinaryHeap maxHeap = new MaxBinaryHeap();
		System.out.println(maxHeap.insert(41));
		System.out.println(maxHeap.insert(39));
		System.out.println(maxHeap.insert(33));
		System.out.println(maxHeap.insert(18));
		System.out.println(maxHeap.insert(27));
		System.out.println(maxHeap.insert(12));
		System.out.println(maxHeap.insert(55));
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();

		System.out.println("-----------------------------");

		MinBinaryHeap minHeap = new MinBinaryHeap();
		System.out.println(minHeap.insert(2));
		System.out.println(minHeap.insert(12));
		System.out.println(minHeap.insert(9));
		System.out.println(minHeap.insert(100));
		System.out.println(minHeap.insert(4));
		System.out.println(minHeap.insert(35));
		System.out.println(minHeap.insert(29));
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
	}
}
/*
Input:	MaxBinaryHeap maxHeap = new MaxBinaryHeap();
		System.out.println(maxHeap.insert(41));
		System.out.println(maxHeap.insert(39));
		System.out.println(maxHeap.insert(33));
		System.out.println(maxHeap.insert(18));
		System.out.println(maxHeap.insert(27));
		System.out.println(maxHeap.insert(12));
		System.out.println(maxHeap.insert(55));
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();
		System.out.println("Removed: "+maxHeap.remove());
		maxHeap.display();

		System.out.println("-----------------------------");

		MinBinaryHeap minHeap = new MinBinaryHeap();
		System.out.println(minHeap.insert(2));
		System.out.println(minHeap.insert(12));
		System.out.println(minHeap.insert(9));
		System.out.println(minHeap.insert(100));
		System.out.println(minHeap.insert(4));
		System.out.println(minHeap.insert(35));
		System.out.println(minHeap.insert(29));
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
		System.out.println("Removed: "+minHeap.remove());
		minHeap.display();
Output:
		[41]
		[41, 39]
		[41, 39, 33]
		[41, 39, 33, 18]
		[41, 39, 33, 18, 27]
		[41, 39, 33, 18, 27, 12]
		[55, 39, 41, 18, 27, 12, 33]
		Removed: 55
		[41, 39, 33, 18, 27, 12]
		Removed: 41
		[39, 27, 33, 18, 12]
		Removed: 39
		[33, 27, 12, 18]
		Removed: 33
		[27, 18, 12]
		Removed: 27
		[18, 12]
		Removed: 18
		[12]
		Removed: 12
		[]
		No elements to remove.
		Removed: -1
		[]
		-----------------------------
		[2]
		[2, 12]
		[2, 12, 9]
		[2, 12, 9, 100]
		[2, 4, 9, 100, 12]
		[2, 4, 9, 100, 12, 35]
		[2, 4, 9, 100, 12, 35, 29]
		Removed: 2
		Tree:- [4, 12, 9, 100, 29, 35]
		Removed: 4
		Tree:- [9, 12, 35, 100, 29]
		Removed: 9
		Tree:- [12, 29, 35, 100]
		Removed: 12
		Tree:- [29, 100, 35]
		Removed: 29
		Tree:- [35, 100]
		Removed: 35
		Tree:- [100]
		Removed: 100
		Tree:- []
		No elements to remove.
		Removed: -1
		Tree:- []
*/


//child smaller than parent
class MaxBinaryHeap {
	private ArrayList<Integer> values;

	public MaxBinaryHeap() {
		values = new ArrayList<>();
	}

	public ArrayList<Integer> insert(int newVal) {
		int parentIndex, newValIndex;
		values.add(newVal);
		while(values.size() > 1) {
			newValIndex = values.indexOf(newVal);
			parentIndex = (int)Math.floor((newValIndex - 1) / 2);
			if(values.get(parentIndex) < newVal) {	//parent < newVal
				values.set(newValIndex, values.get(parentIndex));
				values.set(parentIndex, newVal);
			} else {
				return values;
			}
		} 		
		return values;
	}


	//extractMax i.e.., removing node element.
	public int remove() {
		if(values.size() == 0) {
			System.out.println("No elements to remove.");
			return -1;
		} else {
			int rootElement = values.get(0);
			int len = values.size();
			if(len > 1) {
				values.set(0, values.get(len - 1));
				sinkDown(values);
			}
			values.remove(len - 1);
			return rootElement;
		}
	}

	private void sinkDown(ArrayList<Integer> values) {
		int parentIndex = 0, child1Index, child2Index;
		int parentValue, child1Value, child2Value;
		while(true) {
			parentValue = values.get(parentIndex); 
			child1Index = 2 * parentIndex + 1;
			child2Index = 2 * parentIndex + 2;

			//both child indexes are valid i.e.., less than total array size
			if(child1Index < values.size() && child2Index < values.size()) {
				child1Value = values.get(child1Index);
				child2Value = values.get(child2Index);
				
				//atleast one child is bigger than parent
				if(child1Value > parentValue || child2Value > parentValue) {
					
					if(child1Value > child2Value) {
						values.set(child1Index, parentValue);
						values.set(parentIndex, child1Value);
						parentIndex = child1Index;
					} else if(child2Value > child1Value){
						values.set(child2Index, parentValue);
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
				if(child1Value > parentValue) {
					values.set(child1Index, parentValue);
					values.set(parentIndex, child1Value);
					parentIndex = child1Index;
				} else {
					break;
				}

			//Second child ke liye 1st wale jaisa akela condition nahi aaega because
			//2nd child ka index valid hoga toh 1st child ka index bhi valid hoga
			//and this condition is already tested in the first "if".

			} else {
				break;
			}
		}
	}

	public void display() {
		System.out.println(values);
	}

}

//child bigger than parent
class MinBinaryHeap {
	private ArrayList<Integer> values;

	public MinBinaryHeap() {
		values = new ArrayList<Integer>();
	}

	public ArrayList<Integer> insert(int newVal) {
		int index, newValIndex;
		values.add(newVal);
		while(values.size() > 1) {
			newValIndex = values.indexOf(newVal);
			index = (int)Math.floor((newValIndex - 1) / 2);
			if(values.get(index) > newVal) {	//parent < newVal
				values.set(newValIndex, values.get(index));
				values.set(index, newVal);
			} else {
				return values;
			}
		} 		
		return values;
	}

	//extractMin i.e.., removing node element.(similar to extract max)
	public int remove() {
		if(values.size() == 0) {
			System.out.println("No elements to remove.");
			return -1;
		} else {
			int rootElement = values.get(0);
			int len = values.size();
			if(len > 1) {
				values.set(0, values.get(len - 1));
				sinkDown(values);
			}
			values.remove(len - 1);
			return rootElement;
		}
	}

	private void sinkDown(ArrayList<Integer> values) {
		int parentIndex = 0, child1Index, child2Index;
		int parentValue, child1Value, child2Value;
		while(true) {
			parentValue = values.get(parentIndex); 
			child1Index = 2 * parentIndex + 1;
			child2Index = 2 * parentIndex + 2;

			//both child indexes are valid i.e.., less than total array size
			if(child1Index < values.size() && child2Index < values.size()) {
				child1Value = values.get(child1Index);
				child2Value = values.get(child2Index);
				
				//atleast one child is bigger than parent
				if(child1Value < parentValue || child2Value < parentValue) {
					
					if(child1Value < child2Value) {
						values.set(child1Index, parentValue); //swap child1-parent
						values.set(parentIndex, child1Value);
						parentIndex = child1Index;
					} else if(child2Value < child1Value){
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
				if(child1Value < parentValue) {
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

	public void display() {
		System.out.println("Tree:- "+values);
	}
}