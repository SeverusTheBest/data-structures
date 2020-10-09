import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the num: ");
		int num = scanner.nextInt();
		RecursiveRange rr = new RecursiveRange();
		System.out.println(rr.findRecursiveRange(num));
	}
}

class RecursiveRange {


	public RecursiveRange() {
	}

	public int findRecursiveRange(int num) {
		if(num == 0) {
			return 0;
		}
		return num + findRecursiveRange(num-1);
	}
}