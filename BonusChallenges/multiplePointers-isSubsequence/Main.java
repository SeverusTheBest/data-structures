import java.util.*;
public class Main {
	public static void main(String[] args) {
		Subsequence s = new Subsequence();
		System.out.println(s.isSubsequent());
	}
}

class Subsequence {
	private Scanner scanner = new Scanner(System.in);
	private String value1, value2;
	private char[] value1Arr, value2Arr;
	private int i, j;

	public Subsequence() {
		System.out.print("Enter 1st string value: ");
		value1 = scanner.nextLine();
		value1Arr = value1.toCharArray();

		System.out.print("Enter 2nd string value: ");
		value2 = scanner.nextLine();
		value2Arr = value2.toCharArray();
	}

	public boolean isSubsequent() {
		if(value1.length() == 0 && value2.length() == 0) {
			return true;
		} else {
			i=0; j=0;
			while(i<value1.length() && j<value2.length()) {
				if(value1Arr[i] == value2Arr[j]) {
					if(i==value1.length()-1) {
						return true;
					} else {
						i++;
						j++;	
					}
				} else {
					j++;
				}
			}
		}
		
		return false;
	}
}