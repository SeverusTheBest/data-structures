import java.util.*;
public class Main {
	public static void main(String[] args) {
		SubArray sa =  new SubArray();
		System.out.println(sa.findMinSubArrayLen());
	}
}

class SubArray {
	private Scanner scanner;
	private String[] arr;
	private boolean forward;
	private int sumOfSubArray, tempSumOfSubArray, i, j, size;
	private ArrayList<Integer> list;

	public SubArray() {
		scanner = new Scanner(System.in);
		System.out.println("Enter the array of integers: ");
		arr = scanner.nextLine().split(" ");
		System.out.println("Enter the numberSum");
		sumOfSubArray = scanner.nextInt();
		forward = true; 
		list = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			list.add(Integer.valueOf(arr[i]));
		}
	}

	public int findMinSubArrayLen() {
		if(arr.length == 0) {
			return 0;
		} else if(arr.length == 1) {
			tempSumOfSubArray = list.get(0);
			if(tempSumOfSubArray >= sumOfSubArray) {
				return 1;
			} else {
				return 0;
			}
		} else {
			i=0; j=0;
			tempSumOfSubArray = list.get(i+j);
			System.out.println(tempSumOfSubArray);
			while(i<arr.length && j<arr.length) {
				if(tempSumOfSubArray >= sumOfSubArray) {
					if(i==j) {
						return 1;
					}
					if(size == 0 || size > j-i+1) {
						size = j-i+1;
					}
					tempSumOfSubArray -= list.get(i);
					i++;
				} else if(tempSumOfSubArray < sumOfSubArray) {
					if(j!=arr.length-1) {
						j++;
						tempSumOfSubArray += list.get(j);
					} else if(i!=arr.length-1) {
						if(size < j-i+1) {
							break;
						} else {
							tempSumOfSubArray -= list.get(i);
							i++;
						}
					} else {
						break;
					}
				}
			}
			return size;
		}
	} 


}