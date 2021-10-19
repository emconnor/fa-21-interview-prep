package day13removeinstances;

/**
 * Given a linked list and a value x, remove all instances of x from the linked list
 */

class Solution {
    public ListNode removeInstances(ListNode node, int x) {
      
      // check if head.val = x, if so, move head along until it does not
      while (node != null && node.val == x) {
        node = node.next;
      }
      // if null, return null
      if (node == null) {
        System.out.println("null node");
        return null;
       }

       ListNode prev = new ListNode();
       prev.next = node;
       ListNode curr = node;
       ListNode next = curr.next;

       while(next != null) {
         if (next.val == x) {
          next = next.next;
          curr.next = next;
          prev = curr;
         } else {
           prev = curr;
           curr = next;
           next = next.next;
         }
       }
      return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        // ListNode one = new ListNode(1);
        // head.next = one;
        // ListNode two = new ListNode(1);
        // one.next = two;
        // ListNode three = new ListNode(1);
        // two.next = three;
        // ListNode four = new ListNode(3);
        // three.next = four;
        Solution s = new Solution();
        ListNode result = s.removeInstances(head, 1);
        //System.out.println(result);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}