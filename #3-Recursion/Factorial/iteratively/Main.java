import java.util.*;
public class Main {
	public static void main(String[] args) {
		Factorial i = new Factorial();	
		i.factorialIteratively();
	}
}

class Factorial {
	private Scanner scanner;
	private int fact=1, num;

	public Factorial() {
		scanner = new Scanner(System.in);
		System.out.println("Enter the integer value: ");
		num = scanner.nextInt();
		if(num == 0) {
			System.out.println("0");
			return;
		}
	}

	public void factorialIteratively() {
		for(int i=1; i<=num; i++) {
			fact = fact * i;
		}
		System.out.println("The factorial of "+num+" is: "+fact);
	}

}