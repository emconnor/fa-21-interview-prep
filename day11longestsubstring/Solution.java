package day11longestsubstring;
import java.util.*;


//import java.util.*;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */

class Solution {

  public int lengthOfLongestSubstring(String s) {
    
    int result = 0;
    // hash table to store lengths of the string up to that index
    Map<Character, Integer> map = new HashMap<>();

    // for loop: if map contains the char, then set i to be the max of i or the length of the last instance
    // of that char in the string. if map does not contain char. set result to be the max of
    // result or the length - i
    for (int j = 0, i = 0; j < s.length(); j++) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(map.get(s.charAt(j)), i);
      }
      result = Math.max(result, j - i + 1);
      map.put(s.charAt(j), j + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String s1 = "abcabcbb";
    String s2 = "bbbbb";
    String s3 = "pwwkew";
    String s4 = "";
    String s5 = "dvdf";
    System.out.println(s.lengthOfLongestSubstring(s1));
    System.out.println(s.lengthOfLongestSubstring(s2));
    System.out.println(s.lengthOfLongestSubstring(s3));
    System.out.println(s.lengthOfLongestSubstring(s4));
    System.out.println(s.lengthOfLongestSubstring(s5));
  }
}
