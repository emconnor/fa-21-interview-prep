package day9pairwithsum;
import java.util.*;

//import java.util.*;

/**
 * Given an array of size n and a number x, determine the first two elements 
 * in the array, if any, whose sum is exactly x.
 */

class Solution {

  public int[] findPairWithSum(int[] array, int sum) {
    
    // check if array is null or empty or of size 1, if so, return null
    if (array == null || array.length == 0 || array.length == 1) {
      System.out.println("Input array is invalid.");
      return null;
    }

    // create array of size 2
    int[] result = new int[2];
    int difference;

    // store elements of given array in hashset
    Set<Integer> set = new HashSet<>();
    for (int num : array) { set.add(num); }

    // iterate over array array
    for (int num : array) {
      difference = sum - num;
      if (set.contains(difference)) {
        result[0] = num;
        result[1] = difference;
        return result;
      }
    }
    return null;
  } 

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] testArray = new int[] {1, 1, 2, 2, 2, 3, 7, 7, 7, 9};
    int[] testArray2 = new int[] {36, 41, 56, 35, 44, 33, 34, 43, 92, 32, 42};
    int[] testArray3 = new int[] {2};
    int[] testArray4 = new int[] {};
    int[] testArray5 = new int[] {3, 9, 50, 2, 8, 4, 1};
    int[] testArray6 = new int[] {1, 5, 29, 4, 3, 2, 1};
    System.out.println(Arrays.toString(s.findPairWithSum(testArray, 10)));
    System.out.println(Arrays.toString(s.findPairWithSum(testArray2, 67)));
    System.out.println(Arrays.toString(s.findPairWithSum(testArray3, 2)));
    System.out.println(Arrays.toString(s.findPairWithSum(testArray4, 89)));
    System.out.println(Arrays.toString(s.findPairWithSum(testArray5, 11)));
    System.out.println(Arrays.toString(s.findPairWithSum(testArray6, 2)));
  }
}
