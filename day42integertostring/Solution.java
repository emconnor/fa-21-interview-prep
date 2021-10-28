package day42integertostring;

public class Solution {

  public String integerToString(int x) {

    if (x == 0) return "0";
    
    StringBuilder result = new StringBuilder();
    boolean negative = false;

    if (x < 0) {
      negative = true;
    }

    x = Math.abs(x);

    while (x != 0) {
      result.append(x % 10);
      x /= 10;
    }

    if (negative) result.append('-');

    return result.reverse().toString();

  }


  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.integerToString(0));
  }
}