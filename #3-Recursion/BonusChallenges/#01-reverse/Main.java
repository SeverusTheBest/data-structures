// import java.util.*;
// public class Main {
// 	public static void main(String[] args) {
// 		Scanner scanner = new Scanner(System.in);
// 		System.out.println("Enter the string: ");
// 		String[] arr = scanner.nextLine().split("");
// 		Reverse r = new Reverse();
// 		System.out.println("Reversed Array: "+r.findReverse(arr));
// 	}
// }

// class Reverse {
// 	private ArrayList<String> list, reversedList;
// 	private int count=0, len;

// 	public Reverse() {
// 		list = new ArrayList<String>();
// 		reversedList = new ArrayList<String>();
// 	}


// 	public ArrayList<String> findReverse(String[] arr) {
// 		len = arr.length-1;
// 		System.out.print("Original Array: ");
// 		for (int i=0; i<arr.length; i++) {
// 			System.out.print(arr[i]+" ");
// 		}
// 		helperMethod(arr);
// 		return list;
// 	}

// 	private void helperMethod(String[] arr) {
// 		if(len < 0) {
// 			return;
// 		}
// 		list.add(arr[len]);
// 		len--;	
// 		helperMethod(arr);
// 	}


// }




import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String[] arr = scanner.nextLine().split("");
		Reverse r = new Reverse();
		System.out.println("\tReversed Array: "+r.findReverse(arr));
	}
}

class Reverse {
	private ArrayList<String> list, reversedList;
	private int count=0, len;

	public Reverse() {
		list = new ArrayList<String>();
		reversedList = new ArrayList<String>();
	}


	public ArrayList<String> findReverse(String[] arr) {
		for (int i=0; i<arr.length; i++) list.add(arr[i]);
		// len = arr.length-1;
		System.out.print("Original Array: ");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		helperMethod(list);
		return reversedList;
	}

	private void helperMethod(ArrayList<String> list) {
		if(list.size() == 0) {
			return;
		}
		reversedList.add(list.get(list.size()-1));
		list.remove(list.size()-1);
		helperMethod(list);
	}


}