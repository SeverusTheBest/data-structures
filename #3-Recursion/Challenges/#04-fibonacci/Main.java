import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = scanner.nextInt();
		Fibonacci f = new Fibonacci();
		System.out.println(f.findFibonacci(num));
	}
}

class Fibonacci {
	private long firstNum=0, secondNum=1, temp;

	public Fibonacci() {
	}

	// public long findFibonacci(int num) {
	// 	if(num == 0) {
	// 		return firstNum;
	// 	} else if(num == 1) {
	// 		return secondNum;
	// 	}
	// 	helperMethod(num);
	// 	return secondNum;
	// } 

	// public void helperMethod(int num) {
	// 	if(num < 2) {
	// 		return;
	// 	}
	// 	temp = firstNum + secondNum;
	// 	System.out.println(temp);
	// 	firstNum = secondNum;
	// 	secondNum = temp;
	// 	num--;
	// 	helperMethod(num);
	// }

	public long findFibonacci(int num) {
		if(num <= 2) return 1;
		return findFibonacci(num-1) + findFibonacci(num-2);
	}
}



























	// public int findFibonacci(int num) {
	// 	// firstNum = 0; secondNum = 1;
	// 	// if(num == 0) {
	// 	// 	return firstNum;
	// 	// } else if(num == 1) {
	// 	// 	return secondNum;
	// 	// } else {
	// 	// 	for(int i=num; i>=2; i--) {
	// 	// 		temp = firstNum + secondNum;
	// 	// 		firstNum = secondNum;
	// 	// 		secondNum = temp;
	// 	// 	}
	// 	// }
	// 	// return secondNum;
	
	// 	firstNum = 0; secondNum = 1;
	// 	if(num == 0) {
	// 		return firstNum;
	// 	} else if(num == 1){
	// 		return secondNum;
	// 	} else {
	// 		while(num>=2) {
	// 			temp = firstNum+secondNum;
	// 			firstNum = secondNum;
	// 			secondNum = temp;
	// 			num--;
	// 		}
	// 	}
	// 	return secondNum;
	// }