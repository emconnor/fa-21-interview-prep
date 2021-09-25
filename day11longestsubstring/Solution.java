package day11longestsubstring;
import java.util.*;


//import java.util.*;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */

class Solution {

  public int lengthOfLongestSubstring(String s) {
    
    int n = s.length();
    int ans = 0;
        
    Map<Character, Integer> map = new HashMap<>(); 
    
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < n; j++) {
        if (map.containsKey(s.charAt(j))) {
            i = Math.max(map.get(s.charAt(j)), i);
        }
        ans = Math.max(ans, j - i + 1);
        map.put(s.charAt(j), j + 1);
    }
    return ans;
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
