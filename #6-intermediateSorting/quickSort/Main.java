import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the array in any order: ");
		String[] str = scanner.nextLine().split(" ");
		int[] arr = new int[str.length];
		for (int i=0; i<arr.length; i++) {
			arr[i] = Integer.valueOf(str[i]);
		}
		arr = sort(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] sort(int[] arr, int start, int end) {
		if(start>=end) {
			return arr;
		} else {
			int swapIndex = pivotSetter(arr, start, end);
			// System.out.println("1st part");
			sort(arr, start, swapIndex);
			// System.out.println("2nd part");
			sort(arr, swapIndex+1 , end);
			// System.out.println("2nd part out");
			return arr;
		}
	}

	public static int pivotSetter(int[] arr, int start, int end) {
		int pivot = arr[start], swapIndex = start;
		for(int i=start+1; i<end; i++) {
			if(pivot > arr[i]) {
				swapIndex++;
				// if(i!=swapIndex) {
					int temp = arr[i];
					arr[i] = arr[swapIndex];
					arr[swapIndex] = temp;
				// }
			}
		}
		int temp = arr[start];
		arr[start] = arr[swapIndex];
		arr[swapIndex] = temp;
		// System.out.println(Arrays.toString(arr)+" and "+start+", "+end+" "+swapIndex);
		return swapIndex;
	}
}