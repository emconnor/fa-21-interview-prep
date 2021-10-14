package day30intersectionofarrays;
import java.util.*;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must appear as many times as it shows in both arrays 
 * and you may return the result in any order.
 */

class Solution {
    
    public int[] arrayIntersection(int[] arr1, int[] arr2) {

      if (arr1 == null || arr2 == null) return null;

      int[] result = new int[arr1.length + arr2.length];
      Map<Integer, Integer> map1 = new HashMap<>();
      Map<Integer, Integer> map2 = new HashMap<>();
      int i = 0;
      int j = 0;
      // add arr1 to map
      for (int num : arr1) {
        if (map1.containsKey(num)) {
          int val = map1.get(num);
          map1.put(num, val + 1);
        } else {
          map1.put(num,1);
        }
      }
      for (int num : arr2) {
        if (map2.containsKey(num)) {
          int val = map2.get(num);
          map2.put(num, val + 1);
        } else {
          map2.put(num,1);
        }
      }
      for (Map.Entry<Integer, Integer> entry: map1.entrySet()) {
        if (map2.containsKey(entry.getKey())) {
          j = Math.min(map1.get(entry.getKey()), map2.get(entry.getKey()));
          while (j > 0) {
            result[i] = entry.getKey();
            i++;
            j--;
          } 
        }
      }
      return result;
    }
    public static void main(String[] args) {
      int[] arr1 = {4,4,4};
      int[] arr2 = {9,4,9,8,4};
      Solution s = new Solution();
      int[] result = s.arrayIntersection(arr1, arr2);
      // for (int i = 0; i < result.length; i++) {
      //   System.out.println(result[i]);
      // }
      System.out.println(Arrays.toString(result));
      
    }
}