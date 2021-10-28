package day41ATOI;

/*
Write a method to convert a string representation of an integer into its equivalent integer number.
*/

public class Solution {

  public int stringToInteger(String str) {

    int result = 0;
    int power = 0;
    int sign = 1;
    int stop = 0;

    //get sign
   if (str.charAt(0) == '-') {
     sign = -1; 
     stop = 1;
   }
    // iterate over string backwards
    for (int i = str.length() - 1; i >= stop; i--) {
      int digit = str.charAt(i) - '0';
      result += (digit * Math.pow(10, power));
      power++;
    }

    return result * sign;
    
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.stringToInteger("-123"));

  }
}


