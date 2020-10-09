import java.util.*;
public class Main {
    public static void main(String[] args) {
        SmartSame smartsame = new SmartSame();
        smartsame.interfaceWithHashMap();
        System.out.println(smartsame.isSame());
    }
}
//2 arrays 1 with numbers and one with square of the data of array1.
//check whether above condition is true or false
class SmartSame {
    private HashMap<String, Integer> map1, map2;
    private Scanner scanner = new Scanner(System.in);
    private String[] arr1, arr2;

    public SmartSame() {
        map1 = new HashMap<>();
        System.out.println("Enter the first array:");
        arr1 = scanner.nextLine().split(" ");
        for (int i = 0; i < arr1.length; i++) {
            if(!map1.containsKey(arr1[i])) {
                map1.put(arr1[i], 1);
            } else {
                int value = map1.get(arr1[i]);
                map1.replace(arr1[i], ( value + 1) );
            }
        }
        // -------------------------------------------------------------
        map2 = new HashMap<>();
        System.out.println("Enter the second array:");
        arr2 = scanner.nextLine().split(" ");
        for (int i = 0; i < arr2.length; i++) {
            if(!map2.containsKey(arr2[i])) {
                map2.put(arr2[i],1);
            } else {
                int value = map2.get(arr2[i]);
                map2.replace(arr2[i], ( value + 1) );
            }
        }
    } 

    public void interfaceWithHashMap() {
        System.out.println("Map 1 is: "+map1);
        System.out.println("Map 2 is: "+map2);
    }

    public boolean isSame() {
        for(String key : map1.keySet()) {
            int value = (int)Math.pow(Integer.valueOf(key), 2);
            String stringValue = String.valueOf(value);
            if(!map2.containsKey(stringValue)) {
                return false;
            }
            if(map2.get(stringValue) != map1.get(key)) {
                return false;
            }
        }
        return true;
    }

}