import java.util.*;
public class Main {
	//BUBBLE SORT: COMPARE AND SWAP
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number array in any unsorted order: ");
		String[] stringArr = scanner.nextLine().split(" "); 
		int[] arr = new int[stringArr.length];
		for(int i=0; i<stringArr.length; i++) {
			arr[i] = Integer.valueOf(stringArr[i]);
		}
		bubbleSort(arr);
	}

	public static void bubbleSort(int[] arr) {
		boolean noSwaps;
		for(int i=arr.length; i>0; i--) {
			noSwaps = true;
			for(int j=0; j<i-1; j++) {
				if(arr[j] > arr[j+1]) {
					System.out.println(arr[j]+", "+arr[j+1]);
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					noSwaps = false;
				}
			}
			if(noSwaps) {
				break;
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}