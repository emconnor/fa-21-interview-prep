package day22removeduplicates;
import java.util.Stack;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */

class Solution {
    
    public ListNode removeDuplicates(ListNode node) {

       
      ListNode first = node;
      ListNode temp = null;

      while (first != null && first.next != null) {
        if (first.val == first.next.val) {
          temp = first.next.next;
          if (temp == null) {
            first.next = null;
            break;
          }
          first.next = temp;
        }
        if (first.val != first.next.val) {
          first = first.next;
        }
      }
      return node;
    }
  
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
        ListNode one = new ListNode(1);
        head.next = one;
        ListNode two = new ListNode(1);
        one.next = two;
        ListNode three = new ListNode(8);
        two.next = three;
        ListNode four = new ListNode(3);
        three.next = four;
        Solution s = new Solution();
        ListNode result = s.removeDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}