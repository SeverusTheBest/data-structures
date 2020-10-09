import java.util.*;
import java.lang.Math.*;
public class Main {
	public static void main(String[] args) {
		Same same = new Same();
		same.naiveSame();
	}
	
}

class Same {
	private String[] arr1, arr2;
	private ArrayList<Integer> list2; 
	private Scanner scanner = new Scanner(System.in);

	public Same() {
		System.out.println("Enter the integer data of array1:-");
		arr1 = scanner.nextLine().split(" ");
		System.out.println("Enter the integer data of array2:-");
		arr2 = scanner.nextLine().split(" ");
		if(arr1.length != arr2.length) {
			System.out.println("As the length of both arrays is not same. Exiting..");
			return;
		}
		list2 = new ArrayList<Integer>();
		for(int i=0; i<arr2.length; i++) {
			list2.add(Integer.valueOf(arr2[i]));
		}
	}
	
	
	public void naiveSame() {
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<list2.size(); j++) {
				if(Math.pow(Integer.valueOf(arr1[i]) , 2) == list2.get(j)) {
					list2.remove(j);
				}
			}
			
		}
		if(list2.size() > 0) {
			System.out.println("The arrays are not same."+ list2);
		} else {
			System.out.println("The arrays are same.");
		}

		// for (int i=0; i<arr1.length; i++) {
		// 	int value = (int)Math.pow(Integer.valueOf( arr1[i] ), 2);
		// 	if(list2.contains(value)) {
		// 		int index = list2.indexOf(value);
		// 		list2.remove(index);
		// 	} else {
		// 		System.out.println("Not same.");
		// 		return;	
		// 	}  
		// }
		// if(list2.size() > 0) {
		// 	System.out.println("not same"+list2);
		// } else {
		// 	System.out.println("same");
		// }
	}
	


	
}