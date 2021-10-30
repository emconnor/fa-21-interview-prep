package day43reversestringarray;

import java.util.Arrays;

public class Solution {

  public String reverseStringArray(String str) {

    String[] arr = str.split(" ");

    int i = 0;
    int j = arr.length - 1;
    String temp = "";
    StringBuilder build = new StringBuilder();

    while (i != j) {
      temp = arr[i];
      arr[i] = arr[j];
      i++;
      j--;
    }

    for (i = 0; i < arr.length; i++) {
      build.append(arr[i]);
      if (i < arr.length - 1) {
        build.append(" ");
      }
    }
    return build.toString();
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    String str1 = "hello";
    System.out.println(s.reverseStringArray(str1));
  }
}