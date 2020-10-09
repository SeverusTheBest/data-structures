import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the string to search: ");
		String[] searchString = scanner.nextLine().split("");
		System.out.print("Enter the string to be searched from: ");
		String[] mainString = scanner.nextLine().split("");
		StringSearch s = new StringSearch(searchString, mainString);
		s.naiveStringSearch();
	}

}

class StringSearch {
	private ArrayList<String> searchString, mainString;


	public StringSearch(String[] searchString, String[] mainString) {
		this.searchString = new ArrayList<>();
		for(int i=0; i<searchString.length; i++) {
			this.searchString.add(searchString[i]);
		}
		this.mainString = new ArrayList<>();
		for(int i=0; i<mainString.length; i++) {
			this.mainString.add(mainString[i]);
		}
	}


	public void naiveStringSearch() {
		int i=0, j=0, count=0;
		int mainLen = mainString.size(), searchLen = searchString.size();
			while(j < searchLen && i < mainLen) {
				if(mainString.get(i).equals(searchString.get(j))) {
					if(j==searchLen-1) {
						j=0; count++; i++;
					} else {
						i++; j++;
					}
				} else {
					i++; j=0;
				}
		
			}
		System.out.print("Total count is: "+count);
	}

}