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
	private boolean occured;

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
		occured = false;
		resultList = new ArrayList<Integer>();
		i=0; j=0;
		while(i<list.size() && (j<list.size()) ) {
			if(j!=list.size()-1) {
				j++;
			}
			if((i==j) && (j==list.size()-1) && (i==list.size()-1) ) {
				resultList.add(list.get(i));
				break;
			}
			if(list.get(i) != list.get(j) && occured == false) {
				resultList.add(list.get(i));
				i++;
			} else if(list.get(i) != list.get(j) && occured == true) {
				i=j;
				occured = false;	
			} else {
				occured = true;
			}
		}
		System.out.println(resultList+" and total count is "+resultList.size());
	}
}