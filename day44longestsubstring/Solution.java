package day44longestsubstring;

import java.util.*;

/*
Given a string, find the length of the longest substring in it with no more than 
K distinct characters.
*/
/*
maintain a window and add elements to the window till it contains less or equal k, 
update our result if required while doing so. If unique elements exceeds than required 
in window, start removing the elements from left side. 
*/

public class Solution {

  public int longestSubstring(String str, int k) {

    int result = 0;
    int i = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int r = 0; r < str.length(); r++) {
      
      if (map.containsKey(str.charAt(r))) {
        int num = map.get(str.charAt(r));
        map.put(str.charAt(r), num + 1);
      } else {
        map.put(str.charAt(r), 1);
      }

      if (map.size() <= k) {
        result = Math.max(result, r-i+1);
      } else {
        while (map.size() > k) {
          char l = str.charAt(i);
          int count = map.get(l);
          if (count == 1) {
            map.remove(l);
          } else {
            map.put(l,map.get(l)-1);
          }
          i++;
        }
      }

    }

    return result;
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    String str1 = "cbbebi";
    System.out.println(s.longestSubstring(str1, 3));
  }
}