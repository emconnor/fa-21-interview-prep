package day25reverselinkedlist;
import java.util.Stack;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

class Solution {
    
    public ListNode reverseLinkedList(ListNode head) {

      if (head == null) {
        System.out.println("Error: null list");
        return head;
      }

      ListNode prev = null;
      ListNode curr = head;
      ListNode next = curr.next;

      while (curr.next != null) {
        curr.next = prev;
        prev = curr;
        curr = next;
        next = curr.next;
      }
      curr.next = prev;
      return curr;
    }
  
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode one = new ListNode(2);
      head.next = one;
      ListNode two = new ListNode(3);
      one.next = two;
      ListNode three = new ListNode(4);
      two.next = three;
      ListNode four = new ListNode(5);
      three.next = four;
      Solution s = new Solution();
      ListNode result = s.reverseLinkedList(head);
      while (result != null) {
        System.out.println(result.val);
        result = result.next;
        }
    }
}