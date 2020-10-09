import java.util.*;
public class Main {
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		// System.out.println(f.recFib(8));
		// System.out.println(f.fib(8));
		ArrayList<Integer> memoList = new ArrayList<>();
		System.out.println(f.memoFib(4, memoList));
	}
}


class Fibonacci {

	public int fib(int n) {
		if(n==1) {
			return 0;
		} else if(n==2) {
			return 1;
		}
		int a = 0, b = 1, count = 1;
		int current = 0;
		while(count<n-1) {
			current = a+b;
			a = b;
			b = current;
			count++;
		}
		return current;
	}


	public int recFib(int n) {
		if(n==1) {
			return 0;
		} else if(n==2) {
			return 1;
		}
		return recFib(n-1) + recFib(n-2);
	}


	public int memoFib(int n, ArrayList<Integer> memoList) {
		if(n==1) {
			memoList.add(0);
			return 0;
		} else if(n==2) {
			memoList.add(1);
			return 1;
		} else {
			if(memoList.size() >= n) {
				return memoList.get(n-1);
			}
		}	
		int val = memoFib(n-1, memoList) +memoFib(n-2, memoList);
		memoList.add(val);
		System.out.println(memoList);
		return val;
	}
}
