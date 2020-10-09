import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.print("Enter the array: ");
		String[] arr = scanner.nextLine().split(" ");
		for(int i=0; i<arr.length; i++) {
			list.add(Integer.valueOf(arr[i]));
		}

		ProductOfArray poa = new ProductOfArray();
		System.out.println(poa.findProductOfArray(list));
		// System.out.println(findProductOfArray(list));
	}
	// static int product;
	// public static int findProductOfArray(ArrayList<Integer> list) {
	// 	product = 1;
		
	// 	helperMethod(list);
	// 	return product;
	// }
	// public static void helperMethod(ArrayList<Integer> anotherList) {
	// 		if(anotherList.size() == 0) {
	// 			return;
	// 		}
	// 		product *= anotherList.get(0);
	// 		anotherList.remove(0);

	// 		helperMethod(anotherList);
	// }
}

class ProductOfArray {
	private int product;
	public ProductOfArray() {
	}

	public int findProductOfArray(ArrayList<Integer> list) {
		product=1;
		helperMethod(list);
		return product;
	}

	private void helperMethod(ArrayList<Integer> anotherList) {
		if(anotherList.size() == 0) {
			return;
		}
		product *= anotherList.get(0);
		System.out.println(anotherList);
		anotherList.remove(0);
		helperMethod(anotherList);
	}	
}