package day10intersectionofarrays;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


//import java.util.*;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must be unique and you may return the result in any order.
 */

class Solution {

  public int[] intersection(int[] array1, int[] array2) {
    
    if (array1 == null || array2 == null) return null;

    Set<Integer> set1 = new HashSet<>();
    for (int num : array1) {
      set1.add(num);
    }
    Set<Integer> set2 = new HashSet<>();
    for (int num : array2) {
      set2.add(num);
    }

    // iterate over array1, checking to see each int is in the hash set
    set1.retainAll(set2);

    // convert arraylist to array and return
    int[] result = new int[set1.size()];
    int i = 0;
    for (int num : set1) {
      result[i] = num;
      i++;
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] testArray = new int[] {1, 1, 2, 2, 2, 3, 7, 7, 7, 9};
    int[] testArray2 = new int[] {36, 41, 56, 35, 44, 33, 34, 43, 92, 32, 42};
    int[] testArray3 = new int[] {2};
    // int[] testArray4 = new int[] {};
    int[] testArray5 = new int[] {3, 9, 50, 2, 8, 4, 1};
    int[] testArray6 = new int[] {1, 5, 29, 4, 3, 2, 1};
    System.out.println(Arrays.toString(s.intersection(testArray, testArray2)));
    System.out.println(Arrays.toString(s.intersection(testArray, testArray3)));
    System.out.println(Arrays.toString(s.intersection(testArray5, testArray6)));
    System.out.println(Arrays.toString(s.intersection(null, null)));
  }
}
