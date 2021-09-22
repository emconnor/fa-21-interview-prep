package day8longestconsecsub;
import java.util.*;

//import java.util.*;

/**
 * Given an unsorted array of integers, we want to find the length of the longest 
 * subsequence such that elements in the subsequence are consecutive integers. 
 * The consecutive numbers can be in any order.
 */

class Solution {

  public int longestConsecutiveSubsequence(int[] array) {

    // create hash set
    Set<Integer> set = new HashSet<>();
    // add all elements of array to hash set
    for (int num : array) {
      set.add(num);
    }
    // keep track of longest streak 
    int longestStreak = 0;
    int currentStreak = 0;
    int currentNum = 0;
    // loop through the array 
    for (int i = 0; i < array.length; i++) {
      // if set contains array[i]-1, then this is not the beginning of count
      if (set.contains(array[i] - 1)) {
        continue;
      } else {
        currentNum = array[i];
        // while set contains currentNum + 1, increment currentStreak and currentNum
        currentStreak = 0;
        currentStreak++;
        currentNum++;
        while (set.contains(currentNum)) {
          currentStreak++;
          currentNum++;
        }
      }
      // when loop exits check if currentlength is greater than longestStreak, if yes, update longestStreak
      if (currentStreak > longestStreak) {
          longestStreak = currentStreak;
      }
    }
    return longestStreak;
  }
  

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] testArray = new int[] {1, 1, 2, 2, 2, 3, 7, 7, 7, 9};
    int[] testArray2 = new int[] {36, 41, 56, 35, 44, 33, 34, 43, 92, 32, 42};
    int[] testArray3 = new int[] {2};
    int[] testArray4 = new int[] {};
    int[] testArray5 = new int[] {3, 9, 50, 2, 8, 4, 1};
    int[] testArray6 = new int[] {1, 5, 29, 4, 3, 2, 1};
    System.out.println(s.longestConsecutiveSubsequence(testArray));
    System.out.println(s.longestConsecutiveSubsequence(testArray2));
    System.out.println(s.longestConsecutiveSubsequence(testArray3));
    System.out.println(s.longestConsecutiveSubsequence(testArray4));
    System.out.println(s.longestConsecutiveSubsequence(testArray5));
    System.out.println(s.longestConsecutiveSubsequence(testArray6));
  }
}
