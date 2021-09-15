package day3nextprime;

/**
 * Next Prime: given an integer return the next smallest prime number
 */

class Solution {

  public boolean isPrime(int n) {

    boolean isPrime = true;
    int i = 2;

    while (i <= Math.floor(Math.sqrt(n))) {
      if (n % i == 0) {
        isPrime = false;
        break;
      }
      i++;
    }
    return isPrime;
  }

  public int nextPrime(int n) {

    // smallest prime number is 2
    if (n < 2) {
      return 2;
    }

    int i = n + 1;
    boolean hitPrime = isPrime(i);

    while (!hitPrime) {
      i++;
      hitPrime = isPrime(i);
    }
    return i;
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    System.out.println(s.isPrime(8));
    System.out.println(s.nextPrime(-10));
    System.out.println(s.nextPrime(101));
    System.out.println(s.nextPrime(0));
    System.out.println(s.nextPrime(28));
    System.out.println(s.nextPrime(693));
  }
}
