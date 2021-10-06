package day20linkedlistlength;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */

class Solution {
    
    public int linkedListLength(ListNode node) {

      int len = 0;

      // null checks
      if (node == null) {
        System.out.println("Error: list null");
        return -1;
      } 

      // two nodes a head to return that points to tail that points to l1
      ListNode dummy = node;

      while (dummy != null) {
        len++;
        dummy = dummy.next;
      }
      return len;
    }
    public static void main(String[] args) {
      ListNode head1 = new ListNode(1);
      // ListNode one = new ListNode(3);
      // head1.next = one;
      // ListNode two = new ListNode(5);
      // one.next = two;
      Solution s = new Solution();
      int result = s.linkedListLength(head1);
      // while (result != null) {
      //     System.out.println(result.val);
      //     result = result.next;
      // }
      System.out.println(result);
    }
}