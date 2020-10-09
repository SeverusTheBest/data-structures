import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int base, exponent;
		System.out.print("Enter the base value: ");
		base = scanner.nextInt();
		System.out.print("Enter the exponent value: ");
		exponent = scanner.nextInt();
		Power power = new Power();
		System.out.println(power.findPowerValue(base, exponent));
		scanner.close();
	}

}

class Power {
	public Power() {
	}

	public int findPowerValue(int base, int exponent) {
		if(exponent == 0) {
			return 1;
		}
		return base * findPowerValue(base, exponent - 1);
	}
}