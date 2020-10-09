import java.util.*;
public class Main {
	public static void main(String[] args) {
		Duplicates d = new Duplicates();
		System.out.println(d.areThereDupicates());
	}
}

class Duplicates {
	private HashMap<String, Integer> map;
	private Scanner scanner = new Scanner(System.in);
	private String[] arr;

	public Duplicates() {
		arr = scanner.nextLine().split(" ");
		map = new HashMap<String, Integer>();
	}

	public boolean areThereDupicates() {
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				return true;
			} else {
				map.put(arr[i], 0);
				System.out.println(map);
			}
		}
		System.out.println(map);
		return false;
	}
}