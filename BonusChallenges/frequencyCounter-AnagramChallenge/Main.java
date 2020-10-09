import java.util.*;
public class Main {
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        anagram.interfaceWithHashMap();
        System.out.println(anagram.validAnagram());
    }
}
 //enter two words and see whether they are anagram.
class Anagram {
    private HashMap<String, Integer> map1, map2;
    private Scanner scanner = new Scanner(System.in);
    private String arr1, arr2;
 
    public Anagram() {
        map1 = new HashMap<>();
        System.out.println("Enter the first word:");
        arr1 = scanner.nextLine();
        char[] charArr1 = arr1.toCharArray();
        for (int i = 0; i < arr1.length(); i++) {
            String key1 = String.valueOf(charArr1[i]);
            if(!map1.containsKey(key1)) {
                map1.put(key1,1);
            } else {
                int value = map1.get(key1);
                map1.replace(key1, ( value + 1) );
            }
        }
        // -------------------------------------------------------------
        map2 = new HashMap<>();
        System.out.println("Enter the second word:");
        arr2 = scanner.nextLine();
        char[] charArr2 = arr2.toCharArray();
        for (int i = 0; i < arr2.length(); i++) {
            String key2 = String.valueOf(charArr2[i]);
            if(!map2.containsKey(key2)) {
                map2.put(key2,1);
            } else {
                int value = map2.get(key2);
                map2.replace(key2, ( value + 1) );
            }
        }
    } 
 
    public void interfaceWithHashMap() {
        System.out.println("Map 1 is: "+map1);
        System.out.println("Map 2 is: "+map2);
    }
 
    public boolean validAnagram() {
        if(arr1.length() == arr2.length()) {
            if(map1.equals(map2)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
 
}