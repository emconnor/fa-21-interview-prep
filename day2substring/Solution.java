package day2substring;

/**
 * Substring: Write a function that takes in two strings and returns true if the
 * second string is substring of the first, and false otherwise.
 */

class Solution {

  public boolean substring(String largeStr, String potentialStr) {

    // if potentialStr is 0 or empty, return true
    if (potentialStr.length() == 0)
      return true;

    char[] charArrayLong = largeStr.toCharArray();
    char[] charArrayShort = largeStr.toCharArray();

    for (int i = 0; i < largeStr.length(); i++) {
      int largeStrIndex = i;
      int j = 0;
      while (j < potentialStr.length() && largeStrIndex < largeStr.length()
          && charArrayLong[largeStrIndex] == charArrayShort[j]) {
        j++;
        largeStrIndex++;
      }
      if (j + 1 == potentialStr.length()) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {

    Solution s = new Solution();

    System.out.println(s.substring("yesokay", "yes"));
    System.out.println(s.substring("yesokay", ""));
    System.out.println(s.substring("yesokay", "y"));
    System.out.println(s.substring("yesokay", " "));
    System.out.println(s.substring("yesokay", "t"));
    System.out.println(s.substring("yesokay", "yesokayokay"));

  }
}
