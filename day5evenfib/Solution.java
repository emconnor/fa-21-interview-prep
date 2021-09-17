package day5evenfib;

/**
 * Even Fibonacci numbers: return the sum of all even fibonacci numbers that do
 * not exceed n.
 */

class Solution {

  public int sumEvenFib(int n) {

    if (n < 0) {
      System.out.println("Enter a number greater than or equal to 0");
      return -1;
    }

    int sum = 0;
    int fib1 = 0;
    int fib2 = 1;
    int fibSum = 0;

    while (fibSum <= n) {
      fibSum = fib1 + fib2;
      if (fibSum % 2 == 0) {
        sum += fibSum;
      }
      fib1 = fib2;
      fib2 = fibSum;
    }

    return sum;

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.sumEvenFib(10));
    System.out.println(s.sumEvenFib(0));
    System.out.println(s.sumEvenFib(1));
    System.out.println(s.sumEvenFib(2));
    System.out.println(s.sumEvenFib(4000000));
    System.out.println(s.sumEvenFib(-1));
  }
}
