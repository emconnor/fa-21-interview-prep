package day4multiplesof3or5;

/**
 * Multiples of 3 or 5: If we list all the natural numbers below 10 that are
 * multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000 natural numbers: the
 * positive integers (whole numbers) 1, 2, 3, etc., and sometimes zero as well.
 */

class Solution {

  public int sumBelow(int n) {

    int sum = 0;

    if (n < 3 && n >= 0) {
      return 0;
    }

    if (n < 0) {
      System.out.println("Enter a natural number.");
      return -1;
    }

    for (int i = 3; i < n; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }

    return sum;

  }

  public static void main(String[] args) {

    Solution s = new Solution();
    System.out.println(s.sumBelow(0));
    System.out.println(s.sumBelow(3));
    System.out.println(s.sumBelow(5));
    System.out.println(s.sumBelow(100));
    System.out.println(s.sumBelow(20));
    System.out.println(s.sumBelow(-1));
    System.out.println(s.sumBelow(1000));
  }
}
