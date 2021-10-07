package day21palindromell;
import java.util.Stack;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */

class Solution {
    
    public boolean isPalindrome(ListNode node) {

      if (node == null) {
        System.out.println("Error: list null");
        return false;
      } 

      // initilize stack
      Stack<ListNode> stack = new Stack<>();

      // create dummy node
      ListNode dummy = node;
      ListNode temp;
      // add all nodes to stack
      while (dummy != null) {
        stack.push(dummy);
        dummy = dummy.next;
      }
      // iterate over ll and if node.val != stack.pop(), return false
      dummy = node;
      while (dummy != null) {
        temp = stack.pop();
        if (temp.val != dummy.val) {
          return false;
        }
        dummy = dummy.next;
      }
      return true;
    }
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode one = new ListNode(2);
      head.next = one;
      ListNode two = new ListNode(2);
      one.next = two;
      ListNode three = new ListNode(2);
      two.next = three;
      ListNode four = new ListNode(1);
      three.next = four;
      Solution s = new Solution();
      boolean result = s.isPalindrome(head);
      System.out.println(result);
    }
}