package day2reversestring;

/**
 * Reverse String: Write code to reverse a string.
 */

class Solution {

    public String reverseString(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = len - 1;
        char dummy = ' ';
        while (i != j) {
            dummy = chars[i];
            chars[i] = chars[j];
            chars[j] = dummy;
            i++;
            j--;
        }
        String result = String.valueOf(chars);
        return result;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "";
        System.out.println("test 1: " + s.reverseString(test));
        String test2 = "l";
        System.out.println("test 2: " + s.reverseString(test2));
        String test3 = " ";
        System.out.println("test 3: " + s.reverseString(test3));
        String test4 = "hello";
        System.out.println("test 4: " + s.reverseString(test4));
    }
}
