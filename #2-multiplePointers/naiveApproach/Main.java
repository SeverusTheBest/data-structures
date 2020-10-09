import java.util.*;
public class Main {
	public static void main(String[] args) {
		MultiplePointers mp = new MultiplePointers();
		mp.countUniqueValues();
	}

}

class MultiplePointers {
	private ArrayList<Integer> list, resultList;
	private Scanner scanner = new Scanner(System.in);
	private int i, j;
	private String[] arr;

	public MultiplePointers() {
		System.out.println("Enter the numbers in sorted form:");
		String value = scanner.nextLine();
		if(value.length() == 0) {
			System.out.println(0);
			return;
		} else if(value.length() == 1) {
			System.out.println(value);
			return;
		}
		arr = value.split(" ");
		list = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			list.add(Integer.valueOf(arr[i]));
		}
		System.out.println(list);
	}


	//To count unique values in a sorted array(entered by the user). 
	public void countUniqueValues() {
		resultList = new ArrayList<Integer>();
		for(i=0; i<list.size(); i++) {
			for (j=i+1; j<list.size(); j++) {
				if(list.get(i)!=list.get(j)) {
					resultList.add(list.get(i));
				} else {
					break;
				}
			}
		}
		System.out.println(resultList);
	}
}