import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the 1st number: ");
		String n1 = scanner.nextLine();
		System.out.print("Enter the 2nd number: ");
		String n2 = scanner.nextLine();
		FrequencyCounter fc = new FrequencyCounter(n1, n2);
		System.out.println(fc.isSameFrequency());
	}
}

class FrequencyCounter {
	private HashMap<String, Integer> map1, map2;
	private char[] arr1, arr2;

	public FrequencyCounter(String n1, String n2) {
		arr1 = n1.toCharArray();
		map1 = new HashMap<String, Integer>();
		for(int i=0; i<arr1.length; i++) {
			map1.put(String.valueOf(arr1[i]), 0);
		}
		arr2 = n2.toCharArray();
		map2 = new HashMap<String, Integer>();
		for(int i=0; i<arr2.length; i++) {
			map2.put(String.valueOf(arr2[i]), 0);
		}	
	}

	public boolean isSameFrequency() {
		if(arr1.length != arr2.length) {
			return false;
		} else {
			for(int i=0; i<arr1.length; i++) {
				String value = String.valueOf(arr1[i]);
				map1.put(value, map1.get(value)+1);
			}
			for(int i=0; i<arr2.length; i++) {
				String value = String.valueOf(arr2[i]);
				map2.put(value, map2.get(value)+1);
			}

		}
		if(map1.equals(map2)) {
			return true;
		}
		return false;

	}
}