package day27wordfrequency;

/**
 * Given the head of a singly linked list, sort the list using insertion sort, and return 
 the sorted list's head.
 The steps of the insertion sort algorithm:
 1. Insertion sort iterates, consuming one input element each repetition and 
 growing a sorted output list.
 2. At each iteration, insertion sort removes one element from the input data, 
 3. finds the location it belongs within the sorted list and inserts it there.
 4. It repeats until no input elements remain.
 */

class Solution {
    
    public int wordFrequency(String[] arr, String word) {

      // null check
      if (arr == null || word == null) {
        return -1;
      }

      int count = 0;

      for (String str : arr) {
        String temp = str.toLowerCase().trim();
        if (temp == word) {
          count++;
        }
      }

      return count;

    }
  
    public static void main(String[] args) {

      String[] test1 = {" The", "dog", "jumped", "in", "the", "dog", "house"};
      String word1 = "dog";
      Solution s = new Solution();
      int result = s.wordFrequency(test1, word1);
      System.out.println(result);

    }
}