package day6romantointeger;

import java.util.HashMap;
import java.util.Map;

//import java.util.*;

/**
 * Given a roman numeral, convert it to an integer.
 */

class Solution {

  public int romanToInteger(String roman) {

    Map<Character, Integer> map = new HashMap<>();
    map.put('M', 1000);
    map.put('D', 500);
    map.put('C', 100);
    map.put('L', 50);
    map.put('X', 10);
    map.put('V', 5);
    map.put('I', 1);

    char[] charArray = roman.toCharArray();
    int result = 0;
    int i = 0;

    while (i < charArray.length) {
      if (charArray.length - i >= 2 && map.get(charArray[i]) < map.get(charArray[i + 1])) {
        result += map.get(charArray[i + 1]) - map.get(charArray[i]);
        i += 2;
      } else {
        result += map.get(charArray[i]);
        i++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.romanToInteger("XII"));
    System.out.println(s.romanToInteger("I"));
    System.out.println(s.romanToInteger("IM"));
    System.out.println(s.romanToInteger("II"));
  }
}
