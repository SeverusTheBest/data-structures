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
		CapitalizeFirst cf = new CapitalizeFirst();
		System.out.println(cf.capitalizeFirstLetterOfEveryWord(list));
	}
}
class CapitalizeFirst {
	private ArrayList<String> resultList;

	public CapitalizeFirst() {}

	public ArrayList<String> capitalizeFirstLetterOfEveryWord(ArrayList<String> list) {
		resultList = new ArrayList<String>();
		helperMethod(list);
		return resultList;
	}
	private void helperMethod(ArrayList<String> list) {
		if(list.size()==0) return;
		String word = list.get(0);
		String newWord = String.valueOf(Character.toUpperCase(list.get(0).charAt(0)))
							+ word.substring(1);
		resultList.add(newWord);
		list.remove(0);
		helperMethod(list);
	}
}