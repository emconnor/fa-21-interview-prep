package day29stringisomorphs;
import java.util.*;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

class Solution {
    
    public boolean isIsomorpic(String str1, String str2) {

      //check for different lengths && nulls
      if (str1 == null || str2 == null || str1.length() != str2.length()) return false;

      //initialize hash map and hash set for keeping track of mappings
      Map<Character, Character> map = new HashMap<>();
      Set<Character> set = new HashSet<>();

      //iterate over strings
      //check if char from str1 is in map, if not add to map
      //check if char from str2 is in set, if it is, check the mapping, if not, map and add to set
      for (int i = 0; i < str1.length(); i++) {
        char c1 = str1.charAt(i);
        char c2 = str2.charAt(i);
        // if map doesn't contain 
        if (!map.containsKey(c1)) {
          // if set doesn't contain c2 (this means it has not been mapped to another letter)
          if (!set.contains(c2)) {
            // then put the letters in as a mapping
            map.put(c1, c2);
          } else {
            // otherwise, the strings are not isomorphic
            return false;
          }
        } else {
          // if it does contain the key, 
          // make sure that its value == c2, else return false
          if (map.get(c1) != c2) {
            return false;
          }
        }
      }

      return true;
    }
  
    public static void main(String[] args) {
      String str1 = "aasdf";
      String str2 = "B";
      Solution s = new Solution();
      System.out.println(s.isIsomorpic(str1, str2));
     
    }
}