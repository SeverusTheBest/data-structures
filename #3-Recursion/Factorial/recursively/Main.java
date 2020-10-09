import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the integer value: ");
		int num = scanner.nextInt();
		Factorial i = new Factorial();	
		System.out.println("The factorial of "+num+" is: "+i.factorialIteratively(num));
	}
}

class Factorial {
	private int fact=1;

	public Factorial() {
	}

	public int factorialIteratively(int num) {
		if(num==1) {
			return 1;
		} else {
			return num * factorialIteratively(num-1);
		}

	}

}