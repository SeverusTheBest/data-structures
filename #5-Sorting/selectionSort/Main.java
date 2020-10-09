import java.util.*;
public class Main {
	//SELECTION SORT: COMPARE AND SWAP BUT THIS TIME PUT MIN VALUE IN SORTED POSITION(BEGINNING)
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number array in any unsorted order: ");
		String[] stringArr = scanner.nextLine().split(" "); 
		int[] arr = new int[stringArr.length];
		for(int i=0; i<stringArr.length; i++) {
			arr[i] = Integer.valueOf(stringArr[i]);
		}
		selectionSort(arr);
	}

	public static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int minIndex = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}		
	}
}