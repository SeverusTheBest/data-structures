import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the listt of words: ");
		ArrayList<String> list = new ArrayList<String>();
		String[] arr = scanner.nextLine().split(" ");
		for (int i=0; i<arr.length; i++) {
			list.add(arr[i]);
		}
		CapitalizeWords cf = new CapitalizeWords();
		System.out.println(cf.capitalizeEveryWord(list));
	}
}
class CapitalizeWords {
	private ArrayList<String> resultList;

	public CapitalizeWords() {}

	public ArrayList<String> capitalizeEveryWord(ArrayList<String> list) {
		resultList = new ArrayList<String>();
		helperMethod(list);
		return resultList;
	}
	private void helperMethod(ArrayList<String> list) {
		if(list.size()==0) return;
		String word = list.get(0);
		String newWord = word.toUpperCase();
		resultList.add(newWord);
		list.remove(0);
		helperMethod(list);
	}
}