import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Main {
	public static void main(String[] args) {
		UnionSet set = new UnionSet();
		set.addVertex("A");	
		set.addVertex("B");	
		set.addVertex("C");	
		set.addVertex("D");	
		set.addVertex("E");

		set.printSet();
		System.out.println("---------------------");
		set.union("A", "C");
		set.union("B", "D");
		set.union("C", "B");
		set.union("C", "D");
		set.union("C", "B");
		set.union("C", "E");
		set.union("D", "E");

		System.out.println("---------------------");
		set.printSet();
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println("---------------------");



		UnionSet set2 = new UnionSet();
		set2.addVertex("E");
		set2.addVertex("F");
		set2.addVertex("I");
		set2.addVertex("D");
		set2.addVertex("C");
		set2.addVertex("A");
		set2.addVertex("J");
		set2.addVertex("L");
		set2.addVertex("G");
		set2.addVertex("K");
		set2.addVertex("B");
		set2.addVertex("H");

		set2.printSet();


		System.out.println("---------------------");
		set2.union("C", "K");
		set2.union("F", "E");
		set2.union("A", "J");
		set2.union("A", "B");
		set2.union("C", "D");
		set2.union("D", "I");
		set2.union("L", "F");
		set2.union("C", "A");
		set2.union("A", "B");
		set2.union("H", "G");
		set2.union("H", "F");
		set2.union("H", "B");
		System.out.println("---------------------");

		set2.printSet();
	}
}


class UnionSet {
	private int counter;
	private Map<String, Integer> map;
	private List<Set> list;

	private Map<Integer, Integer> componentStrength;


	public UnionSet() {
		this(5);
	}

	public UnionSet(int capacity) {
		map = new HashMap<>(capacity);
		list = new ArrayList<>(capacity);
		counter = 0;

		componentStrength = new HashMap<>(capacity);
	}

	public boolean addVertex(String elem) {
		if(map.containsKey(elem))	return false;
		map.put(elem, counter);
		list.add(new Set(elem, counter));
		
		componentStrength.put(counter, 1);

		counter++;
		return true;
	}

	public boolean union(String elem1, String elem2) {
		if(!map.containsKey(elem1) || !map.containsKey(elem2)) {
			System.out.println("Invalid element");
			return false;
		}		
		int root1 = find(elem1), root2 = find(elem2); 
		if(root1 == root2) {
			System.out.println("Both elements from the same component so we ignore"
				+ ", otherwise it would become a cycle");
		} else {
			int strength1 = componentStrength.get(root1),
				strength2 = componentStrength.get(root2);
			if(strength1 > strength2) {
				componentStrength.put(root1, strength1+strength2);
				componentStrength.put(root2, 0);

				list.get(root2).setValue(root1);
			} else {
				componentStrength.put(root2, strength1+strength2);
				componentStrength.put(root1, 0);

				list.get(root1).setValue(root2);
			}
		}
		printSet();
		return true;

	}


	public int find(String elem) {
		int index = map.get(elem);
		Set currentSet = list.get(index);

		int root = index;
		Set tempSet = currentSet;

		// this loop finds the root index.
		while(currentSet.getValue() != root) {
			root = currentSet.getValue();
			currentSet = list.get(root);
		}

		// loop for path compression.
		while(tempSet.getValue() != index) {
			index = tempSet.getValue();
			// setting root values for all the nodes in path.
			tempSet.setValue(root);
			tempSet = list.get(index);
		}

		return root;
	}

	
	public void printMap() {
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			System.out.print(entry.getKey()+","+entry.getValue()+"| ");
		}
	}

	public void printSet() {
		for(int i=0; i<list.size(); i++) {
			System.out.print("["+i+"] "+
							list.get(i).getElem()+"-"+
							list.get(i).getValue()+"\t\t");
		}
		System.out.println();
	}
}



class Set {

	private String elem;
	private int value;

	Set(String elem, int value) {
		this.elem = elem;
		this.value = value;
	} 

	public void setElem(String elem) {
		this.elem = elem;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getElem() {
		return elem;
	}

	public int getValue() {
		return value;
	}

}
