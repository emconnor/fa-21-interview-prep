package day23rotatelinkedlist;
import java.util.Stack;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */

class Solution {
    
    public ListNode rotateListRight(ListNode head, int k) {

      if (head == null) {
        System.out.println("Error: null list");
        return null;
      }

      int listLength = 1;
      ListNode counter = head;
      while (counter.next != null) {
        listLength++;
        counter = counter.next;
      }

      counter.next = head;

      k = k % listLength;
      ListNode newEnd = head;
      for (int i = 0; i < listLength - k - 1; i++) {
        newEnd = newEnd.next;
      }

      ListNode newStart = newEnd.next;
      newEnd.next = null;
      return newStart;
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
      ListNode result = s.rotateListRight(null, 12);
      while (result != null) {
        System.out.println(result.val);
        result = result.next;
        }
    }
}