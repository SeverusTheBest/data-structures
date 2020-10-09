import java.util.*;	
public class Main {
	public static void main(String[] args) {
		AveragePair ap = new AveragePair();
		System.out.println(ap.findAveragePair());
	}

}

class AveragePair {
	private String[] arr; 
	private Scanner scanner;
	private ArrayList<Integer> list;
	private float averageValue;
	private int i, j;

	public AveragePair() {
		scanner = new Scanner(System.in);
		//For empty string put a space atleast.
		System.out.println("Enter the array in sorted order: ");
		arr = scanner.nextLine().split(" ");
		list = new ArrayList<Integer>();
		for(int i = 0; i<arr.length; i++) {
			list.add(Integer.valueOf(arr[i]));
		}
		System.out.println("Enter the average value: ");
		averageValue = scanner.nextFloat();
	}

	public boolean findAveragePair() {
		if(list.size() == 0) {
			return false;
		} else {
			i=0; j=list.size()-1;
			while(i<j) {
				int value1 = (int)list.get(i);
				int value2 = (int)list.get(j);
				float result = (float)(value1+value2) / 2; 
				if(result == averageValue) {
					System.out.println("Index values are:- i="+i+" and j="+j);
					return true;
				} else if(result > averageValue) {
					j--;
				} else if(result < averageValue) {
					i++;
				}
			}
		}
		return false;
	} 

}