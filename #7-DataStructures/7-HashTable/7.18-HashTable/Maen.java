import java.util.*;
class Maen {
	public static void main(String[] args) {
		Hash h = new Hash();
		h.sampleSet();
		h.ogSet();
		// h.arrSet();
	}
}


class Pair {
	private String key, value;

	public Pair(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public void getPair() {
		System.out.println("{ "+key+", "+value+" }");
	}
}


class Hash {
	private ArrayList<ArrayList<Integer>> list1 = new ArrayList<ArrayList<Integer>>();
	private ArrayList<ArrayList<Pair>> list2 = new ArrayList<ArrayList<Pair>>();
	// private ArrayList<Pair>[] list3 = new ArrayList<Pair>[20];

	public Hash() {

	}

	// public void sampleSet() {
	// 	for(int i=0; i<20; i++) {
	// 		list1.add(new ArrayList<Integer>());
	// 	}
	// 	for(int i=0; i<20; i++) {
	// 		for(int j=0; j<3; j++) {
	// 			int val = (int)(Math.random() * 20) + 1;
	// 			list1.get(i).add(val);
	// 		}
	// 	}
	// 	for(int i=0; i<20; i++) {
	// 		System.out.println(list1.get(i));
	// 	}
	// }

	public void sampleSet() {
		for(int i=0; i<20; i++) {
			list1.add(new ArrayList<Integer>());
			list1.get(i).add(0);
		}
		for(int i=19; i>=0; i--) {
			for(int j=0; j<3; j++) {
				int val = (int)(Math.random() * 20) + 1;
				list1.get(i).add(val);
			}
			list1.get(i).remove(0);
		}
		for(int i=0; i<20; i++) {
			System.out.println(list1.get(i));
		}
	}

		// O/P:-
		// 	[7, 4, 20]
		// 	[10, 9, 1]
		// 	[14, 13, 8]
		// 	[19, 7, 3]
		// .... so on 20 times


	public void ogSet() {
		for(int i=0; i<20; i++) {
			int val = i;
			list2.add(new ArrayList<Pair>());
		}
		for(int i=0; i<20; i++) {
			Pair val = new Pair("2", "8");
			// int val = (int)(Math.random() * 20) + 1;
			list2.get(i).add(val);
		}
		for(int i=0; i<20; i++) {
			System.out.println(list2.get(i).get(0).getValue());
		}
	}

		// O/p:- 
		// 		8
		// 		8
		// .... so on 20 times


	// public void arrSet() {
	// 	for(int i=0; i<20; i++) {
	// 		int val = i;
	// 		list2.add(new ArrayList<Pair>());
	// 	}
	// 	Pair val = new Pair("key", "value");
	// 	list3[4].add(val);
	// }


}