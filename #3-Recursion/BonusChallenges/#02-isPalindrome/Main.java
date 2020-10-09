import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String[] arr = scanner.nextLine().split("");
		Palindrome p = new Palindrome();
		System.out.println(p.isPalindrome(arr));
	}
}

class Palindrome {
	private int count;
	private boolean palindrome=true;
	public Palindrome() {
	}

	public boolean isPalindrome(String[] arr) {
		count=0;
		if(arr.length == 1) {
			return true;
		}
		helperMethod(arr, count);
		if(palindrome) {
			return true;
		} else {
			return false;
		}
	} 

	private void helperMethod(String[] arr, int count) {
		if( count >= (arr.length-1-count) ) {
			return;
		}
		if(!arr[count].equals(arr[arr.length-1-count])) {
			palindrome = false;
			return;
		}
		count++;
		helperMethod(arr, count);
	} 

}