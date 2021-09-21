package day7elementwithfreqk;
import java.util.*;

//import java.util.*;

/**
 * Find the element that appears k number of times in an array.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {

  public int findElement(int[] array, int freq) {
    // if freq <= 0
    if (freq <= 0) {
      System.out.println("Invalid input");
      return -1;
    }
    // if freq == 1
    if (array == null || array.length == 0) {
      System.out.println("Empty or null array");
      return -1;
    } 
    // create hashmap
    Map<Integer, Integer> map = new HashMap<>();
    // iterate over array, adding elements and their counts to hashmap
    int count = 0;
    for (int num : array) {
      if (map.containsKey(num)) {
        count = map.get(num);
        map.put(num, count + 1);
      } else {
        map.put(num, 1);
      }
    }
    // iterate over hashmap; as soon as you get to the freq, return the element at that index
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == freq) {
        return entry.getKey();
      }
    }
    // else return -1 and not found message
    System.out.println("Element with k frequency not found.");
    return -1;
  }
  

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] testArray = new int[] {1, 1, 2, 2, 2, 3, 7, 7, 7, 9};
    System.out.println(s.findElement(testArray, 1));
    System.out.println(s.findElement(testArray, -11));
    System.out.println(s.findElement(testArray, 0));
    System.out.println(s.findElement(testArray, 7));
    System.out.println(s.findElement(testArray, 3));
    System.out.println(s.findElement(testArray, 1));
  }
}
