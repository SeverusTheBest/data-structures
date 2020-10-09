import java.util.Scanner;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] arr1 = scanner.nextLine().split(" ");
		String[] sortedArray = sort(arr1);
		System.out.println(Arrays.toString(sortedArray));
	}

	public static String[] sort(String[] arr) {
		if(arr.length>1) {
			String[] arr1 = Arrays.copyOfRange(arr, 0, arr.length/2);
			// System.out.println("Breaking array- "+Arrays.toString(arr1));
			String[] arr2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
			// System.out.println("Breaking array- "+Arrays.toString(arr2));
			arr1 = sort(arr1);
			// System.out.println("Array1: "+Arrays.toString(arr1));
			arr2 = sort(arr2);
			// System.out.println("Array2: "+Arrays.toString(arr2));

			String[] newArray = merger(arr1, arr2);
			return newArray;
		} else {
			return arr;
		}
	}

	public static String[] merger(String[] arr1, String[] arr2) {
		String[] merger = new String[arr1.length+arr2.length];
		int i=0, j=0, count=0;
		while(i<arr1.length && j<arr2.length) {
			if(Integer.valueOf(arr1[i])<=Integer.valueOf(arr2[j])) {
				merger[count] = arr1[i];
				count++; i++;
			} else {
				merger[count] = arr2[j];
				count++; j++;
			}
			if(i==arr1.length && j==arr2.length) {
				break;
			} else if(i==arr1.length) {
				while(j<arr2.length) {
					merger[count] = arr2[j];
					count++; j++;
				}
				break;
			} else if(j==arr2.length) {
				while(i<arr1.length) {
					merger[count] = arr1[i];
					count++; i++;
				}
				break;
			}
		}
		// System.out.print("After sorting & merging: ");
		// for(int k=0; k<merger.length; k++) {
		// 	System.out.print(merger[k]+" ");
		// }
		// System.out.println();
		return merger;
	}
}
