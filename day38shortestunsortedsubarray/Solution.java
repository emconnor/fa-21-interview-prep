package day38shortestunsortedsubarray;
import java.util.*;

/*
Given an array, find the length of the smallest subarray in it which when 
sorted will sort the whole array.
*/

public class Solution {

  public int shortestUnsorted(int[] arr) {
    // input array of ints
    // output: int, the size of the smallest subarray we need to sort to sort the whole array
    // 1. Initialize LeftPtr at the start index and RightPtr at the last index
    if (arr.length == 1) return 0;
    int left = 0;
    int right = arr.length - 1;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int result = 0;
    // 2. Iterate LeftPtr from left -> right as long as it points to elements in the increasing order. 
          // Break when arr[LeftPtr] < arr[index] (that's when you've spotted the first element that 
          // is out of order from left)
    while (left < arr.length - 1 && arr[left] < arr[left + 1]) {
      left++;
    }
    // System.out.println("first left: " + left);
    // 3. Iterate RightPtr from right -> left as long as it points to elements in the decreasing order. 
          // Break when arr[RightPtr] > arr[index] (that's when you've spotted the first element from 
          // right, that is out of order)
    while (right >= 1 && arr[right] > arr[right - 1]) {
      right--;
    }
    // System.out.println("first right: " + right);
    if (right == 0 && left == arr.length - 1) return arr.length;
    // 4. We now have found a candidate sub-array. Find the local min and local max in this sub array
    for (int i = left; i <= right; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    // System.out.println("min: " + min);
    // System.out.println("max: " + max);    

    // 5. Extend the sub-array from LeftPtr to the beginning of the array to include elements greater 
          // than the local min. This is to make sure that all the remaining elements to the left are 
          // indeed less than all elements in the subarray
    while (left >= 0 && min < arr[left]) {
      left--;
    }
    // 6. Extend the sub-array from RightPtr to the end of the array to include elements smaller than 
          // the local max. This is to make sure that all the remaining elements to the right are indeed 
          // greater than all elements in the subarray
    while (right < arr.length && max > arr[right]) {
      right++;
    }
    
    result = (right - 1) - (left + 1) + 1;
    // System.out.println(left);
    // System.out.println(right);

    return result;
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr1 = {1, 2, 5, 3, 7, 10, 9, 12};
    int[] arr2 = {1, 3, 2, 0, -1, 7, 10};
    int[] arr3 = {1,2,3};
    int[] arr4 = {3, 2, 1};
    int[] arr5 = {3};
    System.out.println(s.shortestUnsorted(arr5));
  }
}

