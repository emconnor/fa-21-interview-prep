package day16mergesortedll;

/**
 * Merge two sorted linked lists.
 */

class Solution {
    public ListNode mergeLinkedLists(ListNode node1, ListNode node2) {

      //check for nulls
      if (node1 == null && node2 == null) {
        System.out.println("both lists are null");
        return null;
      } else if (node1 == null) {
        return node2;
      } else if (node2 == null) {
        return node1;
      }

      ListNode head = new ListNode();
      ListNode tail = new ListNode();

      if (node1.val <= node2.val) {
        head = tail = node1;
        node1 = node1.next;
      } else {
        head = tail = node2;
        node2 = node2.next;
      }
       
      while (node1 != null && node2 != null) {
        if (node1.val <= node2.val) {
          tail.next = node1;
          tail = node1;
          node1 = node1.next;
        } else {
          tail.next = node2;
          tail = node2;
          node2 = node2.next;
        }
      }

      if (node1 == null) {
        tail.next = node2;
      } else {
        tail.next = node1;
      }

      return head; 
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode one = new ListNode(3);
        head1.next = one;
        ListNode two = new ListNode(5);
        one.next = two;
        ListNode head2 = new ListNode(2);
        ListNode one2 = new ListNode(4);
        head2.next = one2;
        Solution s = new Solution();
        ListNode result = s.mergeLinkedLists(head1, head2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}