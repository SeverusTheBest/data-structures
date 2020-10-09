import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] str = scanner.nextLine().split(" ");
		int[] arr = new int[str.length];
		for (int i=0; i<arr.length; i++) {
			arr[i] = Integer.valueOf(str[i]);
		}
		// System.out.println(Arrays.toString(arr));
		arr = radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] radixSort(int[] arr) {
		ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
		int maxDigits = mostDigits(arr);
		// System.out.println(maxDigits);
		
		for(int i=0; i<maxDigits; i++) {
			for(int k=0; k<10; k++) {	
				mainList.add(new ArrayList<Integer>());
			}	
			// System.out.println("i"+i);
			for(int j=0; j<arr.length; j++) {
				int digit = getDigit(arr[j], i);
				// System.out.println(digit);
				mainList.get(digit).add(arr[j]);
			}
			copyArray(arr, mainList);
			// System.out.println(mainList);
			// System.out.println("ORIGINAL ARRAY:- "+Arrays.toString(arr));
			mainList.clear();
		}
		return arr;
	}

	public static void copyArray(int[] arr, ArrayList<ArrayList<Integer>> list) {
		int count = 0;
		for(int i=0; i<10; i++) {
			for(int j=0; j<list.get(i).size(); j++) {
				arr[count] = list.get(i).get(j);
				count++;
			}
		}
	}

	public static int getDigit(int num, int place) {
		return (int)Math.floor(Math.abs(num) / Math.pow(10, place)) % 10;
	}

	public static int digitCount(int num) {
		return String.valueOf(Math.abs(num)).length();
	}

	public static int mostDigits(int[] arr) {
		int maxDigit = 0;
		for(int i=0; i<arr.length; i++) {
			int value = digitCount(arr[i]); 
			if(maxDigit < value) {
				maxDigit = value;
			}
		}
		return maxDigit;
	}
}

	//THIS WOULDN'T WORK FOR -VE NUMBERS AS IT MAY RETURN "-" FOR A PRATICULAR POSITION TOO.
	// public static char getDigit(String num, int place) {
	// 	if(place>=num.length()) {
	// 		return '0';
	// 	}
	// 		int pos = num.length()-1-place;
	// 		return num.charAt(pos);
	// }