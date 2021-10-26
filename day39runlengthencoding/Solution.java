package day39runlengthencoding;
import java.util.*;

/*
Given an input string, write a function that returns the run-length encoded string 
for the input string.*
*/

public class Solution {

  public String runLength(String str) {
    // two pointers
    // while pointers point to equal chars, advance and increment a counter
    // when right pointer hits a char that does not equal the left pointer, stop
    // add the char at the right pointer to a result string and convert counter to string and add it

    String result = "";
    if (str.length() == 0) return result;
    int left = 0;
    int right = 0;
    int count = 0;

    while (right < str.length()) {
      if (str.charAt(left) == str.charAt(right)) {
        right++;
        count++; 
      } else {
        result += str.charAt(left) + String.valueOf(count);
        left = right;
        count = 0;
      }
    } 
    result += str.charAt(left) + String.valueOf(count);
    return result;
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    String str1 = "";
    System.out.println(s.runLength(str1));
  }
}

