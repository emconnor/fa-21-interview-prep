package day11linkedlistpalindrome;

import java.util.Stack;

/**
 * Given a linked list, determine if it is a palindrome. Your method would 
 * take in a linked list and return True / False for whether the list is a 
 * palindrome or not.
 */

class Solution {
    public boolean isPalindrome(ListNode node) {
      
        // if null, return null
        if (node == null) {
          System.out.println("null node");
          return false;
        }
        // initialize stack of integers
        Stack<Integer> stack = new Stack<>();
        // push all values from nodes onto stack
        ListNode head = node;
        while (head != null) {
          stack.push(head.val);
          head = head.next; 
        }
        // traverse list again, checking nodes and popping off stack
        head = node;
        int checkVal = 0;
        while (head != null) {
          checkVal = stack.pop();
          if (checkVal != head.val) {
            return false;
          }
          head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        head.next = one;
        ListNode two = new ListNode(1);
        one.next = two;
        // ListNode three = new ListNode(1);
        // two.next = three;
        // ListNode four = new ListNode(3);
        // three.next = four;
        Solution s = new Solution();
        boolean result = s.isPalindrome(head);
        System.out.println(result);
        // while (result != null) {
        //     System.out.println(result.val);
        //     result = result.next;
        // }
    }
}