import java.util.*;
public class Main {
	public static void main(String[] args) {
		SubArray sa = new SubArray();	
		System.out.println(sa.findMaxSubarraySum());
	}
}

class SubArray {
	private Scanner scanner;
	private String[] arr;
	private int size, tempSum, maxSum, i, j;

	public SubArray() {
		scanner = new Scanner(System.in);
		System.out.println("Enter the integer array: ");
		arr = scanner.nextLine().split(" ");
		System.out.println("Enter the subarray size: ");
		size = scanner.nextInt();
	}

	public int findMaxSubarraySum() {
		if(arr.length < size) {
			return -1;
		} else {
			tempSum = 0; i = 0; j = size-1; 
			for(int i=0; i<size; i++) {
				tempSum += Integer.valueOf(arr[i]); 
			}
			maxSum = tempSum;
			if(size == arr.length) {
				return maxSum;
			}
			while(j<arr.length-1) {
				j++;
				tempSum = tempSum - Integer.valueOf(arr[i]) + Integer.valueOf(arr[j]);
				if(tempSum>maxSum) {
					maxSum = tempSum;
				}
				i++;
			}
			return maxSum;
		}
	}


}