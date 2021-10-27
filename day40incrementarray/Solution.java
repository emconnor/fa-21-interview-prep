package day40incrementarray;

import java.util.Arrays;

/*
Implement a function to increment an arbitrary precision integer represented in the form of 
an array, where each element in the array corresponds to a digit.
*/

public class Solution {

  public int[] incrementArray(int[] arr) {

    if (arr.length == 0) return arr;
    
    int index = arr.length - 1;
    int sum = arr[index] + 1;
    int carry = sum / 10;
    arr[index] = sum % 10;

    for (int i = arr.length - 2; i >= 0; i--) {
      sum = arr[i] + carry;
      carry = sum / 10;
      arr[i] = sum % 10;
    }
   
    if (carry > 0) {
      int[] arrLonger = new int[arr.length + 1];
      arrLonger[0] = carry;
      for (int i = 1; i < arrLonger.length; i++) {
        arrLonger[i] = arr[i-1];
      } 
      return arrLonger;      
    }

    return arr;
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr1 = {9,9};
    System.out.println(Arrays.toString(s.incrementArray(arr1)));

  }
}


