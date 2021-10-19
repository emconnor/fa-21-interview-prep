package day15removeduplicates;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */

class Solution {
    public ListNode removeDuplicates(ListNode node) {

      if (node == null) {
        System.out.println("null node");
        return null;
      }

      ListNode l = node;
      ListNode r = null;
      //ListNode dup = null;
       
      while (l != null && l.next != null) {
        r = l;
        while (r.next != null) {
          if (l.val == r.next.val) {
            //dup = r.next;
            r.next = r.next.next;
          } else {
            r = r.next;
          }
        }
        l = l.next;
      }
      return node; 
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        // ListNode one = new ListNode(1);
        // head.next = one;
        // ListNode two = new ListNode(1);
        // one.next = two;
        // ListNode three = new ListNode(8);
        // two.next = three;
        // ListNode four = new ListNode(3);
        // three.next = four;
        Solution s = new Solution();
        ListNode result = s.removeDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}