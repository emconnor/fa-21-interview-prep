package day45maxsubsizek;

public class Solution {

  public static int getMaxSum(List<Integer> input, int k) {
        
    // check that k is greater than size of input array
    if (input.size() < k) return -1;
    
    // first window
    int result = 0;
    for (int i = 0; i < k; i++) {
        result += input.get(i);
    }
    
    // compute sums of remaining windows
    // by removing first element of previous window
    // and adding last element of current window
    int current = result;
    for (int i = k; i < input.size(); i++) {
        current += input.get(i) - input.get(i-k);
        result = Math.max(result, current);
    }
    
    return result;

  
  }
}
