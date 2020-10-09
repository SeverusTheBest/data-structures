import java.util.*;
public class Main {
	public static void main(String[] args) {
		HashTable h = new HashTable(10);
		h.set("baba", "black sheep");
		h.set("pink", "color");
		h.set("orange", "color");
		h.set("hello", "hi");
		h.set("bye", "tata");
		h.set("lol", "olo");
		h.set("lol1", "olo1");
		h.set("lo2l", "ol2o");
		h.set("lo3l", "ol2o");
		h.set("lo30l", "ol2000");
		h.set("lo22l", "ol2o");
		h.set("lo3dl", "ol2o");
		h.set("lo3sd0l", "ol2000");

		System.out.println(h.get("lol"));
		System.out.println(h.get("l0000ol"));
		System.out.println(h.get("l000ol"));
		System.out.println(h.get("l00ol"));
		System.out.println(h.get("l0ol"));
		System.out.println(h.get("labaol"));
		System.out.println(h.get("lgjgol"));

		h.allHashMaps();
		h.getAllKeys();
		h.getAllValues();
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
		System.out.print("{ "+key+", "+value+" }");
	}
}



class HashTable {
	// private String[] keyMap;
	private ArrayList<ArrayList<Pair>> list = new ArrayList<ArrayList<Pair>>();
	private int size;

	public HashTable() {
		this(53);
	}

	public HashTable(int size) {
		this.size = size;
		// filler Pair banake sab level pe daalte hai so that we can randomly put 
		// ... data at any level we want.
		Pair fillerPair = new Pair("-", "-");
		for(int i=0; i<this.size; i++) {
			list.add(new ArrayList<Pair>());
			list.get(i).add(fillerPair);
		}
	}

	// 
	private int _hash(String key) {
		int total = 0;
		int weirdPrime = 31;			 // to reduce collisions we use prime number
		char[] keyArr = key.toCharArray();
		// if characters are too long(more than 100) than loop only 100 times.	
		for(int i=0; i<Math.min(key.length(), 100); i++) {
			int value = (int)keyArr[i] - 96;
			// we mod with this.size so that jitne ka size hai usse bada hash(index)
			// ... value na mile
			total = (total * weirdPrime + value) % this.size;
		}
		return total;
	}

	public void set(String key, String value) {
		Pair newPair = new Pair(key, value);
		int hashValue = Math.abs(_hash(key));

		list.get(hashValue).add(newPair);
		// filler pair:- ["-","-"] hai to usko hatane ke liye yeh if statement hai.
		if(list.get(hashValue).get(0).getKey().equals("-")
				 &&	list.get(hashValue).get(0).getValue().equals("-")) {
			list.get(hashValue).remove(0);
			System.out.println("Filler pair removed successfully");
		}
	}

	public boolean get(String key) {
		int hashValue = Math.abs(_hash(key));
		// returns the whole pair.
		for(int i=0; i<list.get(hashValue).size(); i++) {
			if(list.get(hashValue).get(i).getKey().equals(key)) {
				list.get(hashValue).get(i).getPair();
				return true;
			}
		}
		return false;
	}

	// to iterate through all the Pairs stored at all levels.
	public void allHashMaps(){
		System.out.println("=================Hash-Table====================");
		for(int i=0; i<this.size; i++) {
			// niche wala if statement laga do toh empty levels skip karega.
			// if(list.get(i).get(0).getKey().equals("-"))	continue;
			for(int j=0; j<list.get(i).size(); j++) {
				list.get(i).get(j).getPair();
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	public void getAllKeys() {
		ArrayList<String> keyList = new ArrayList<String>();
		System.out.println("=================All-Keys====================");
		for(int i=0; i<this.size; i++) {
			if(list.get(i).get(0).getKey().equals("-"))	continue;
			for(int j=0; j<list.get(i).size(); j++) {
				keyList.add(list.get(i).get(j).getKey());
			}
		}
		System.out.println(keyList);
	}

	public void getAllValues() {
		ArrayList<String> keyList = new ArrayList<String>();
		System.out.println("=================All-Values====================");
		for(int i=0; i<this.size; i++) {
			if(list.get(i).get(0).getValue().equals("-"))	continue;
			for(int j=0; j<list.get(i).size(); j++) {
				keyList.add(list.get(i).get(j).getValue());
			}
		}
		System.out.println(keyList);
	}

}