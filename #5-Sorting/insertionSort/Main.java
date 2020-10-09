import java.util.*;
public class Main {
	//INSERTION SORT: 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number array in any unsorted order: ");
		String[] stringArr = scanner.nextLine().split(" "); 
		int[] arr = new int[stringArr.length];
		for(int i=0; i<stringArr.length; i++) {
			arr[i] = Integer.valueOf(stringArr[i]);
		}
		insertionSort(arr);
	}

	public static void insertionSort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int currentVal = arr[i];
			int j=i-1; 
			for(; j>=0 && arr[j] > currentVal; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = currentVal;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}	
		// System.out.println("count:"+count);
	}
}