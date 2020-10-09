import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the array of strings: ");
		String[] arr = scanner.nextLine().split(" ");
		System.out.print("Enter the string to search: ");
		String element = scanner.nextLine();
		LinearSearch ls = new LinearSearch();
		System.out.println(ls.search(arr, element));
	}
}
class LinearSearch {
	public LinearSearch() {}

	public int search(String[] arr, String element) {
		for(int i=0; i<arr.length; i++) {
			if(element.equals(arr[i])) {
				return i;
			}
		}
		return -1;
	}
}