import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the array of integers in sorted order: ");
		String[] arr = scanner.nextLine().split(" ");
		System.out.print("Enter the number to be searched: ");
		int element = scanner.nextInt();
		BinarySearch ls = new BinarySearch();
		System.out.println(ls.search(arr, element));
	}
}
class BinarySearch {
	private int start, end, middle;
	public BinarySearch() {}

	public int search(String[] arr, int element) {
		start = 0; end = arr.length-1; middle = (int)(start+end)/2;
		while(start<=end) {
			if(element < Integer.valueOf(arr[middle])) {
				end=middle-1;
				middle=(int)(start+end)/2;
			} else if(element > Integer.valueOf(arr[middle])) {
				start=middle+1;
				middle=(int)(start+end)/2;
			} else {
				return middle;
			}
		}
		return -1;
	}
}