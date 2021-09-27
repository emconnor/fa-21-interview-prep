package day12detectcycle;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, determine if it is a palindrome. Your method would 
 * take in a linked list and return True / False for whether the list is a 
 * palindrome or not.
 */

class Solution {
    public boolean detectCycle(ListNode node) {
      
        // if null, return null
        if (node == null) {
          System.out.println("null node");
          return false;
        }

        Set<ListNode> set = new HashSet<>();

        ListNode temp = node;

        while (temp != null) {
          if (set.contains(temp)) {
            return true;
          }
          set.add(temp);
          temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        head.next = one;
        // one.next = head;
        ListNode two = new ListNode(1);
        one.next = two;
        // two.next = one;
        ListNode three = new ListNode(1);
        two.next = three;
        three.next = head;
        // ListNode four = new ListNode(3);
        // three.next = four;
        Solution s = new Solution();
        boolean result = s.detectCycle(head);
        System.out.println(result);
        // while (result != null) {
        //     System.out.println(result.val);
        //     result = result.next;
        // }
    }
}