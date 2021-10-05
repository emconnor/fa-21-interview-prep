package day18removenthnode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */

class Solution {
    
    public ListNode removeNode(ListNode node, int n) {

      // temp nodes
      ListNode dummy = new ListNode(0);
      dummy.next = node;
      ListNode first = dummy;
      ListNode second = dummy;
      // advance first pointer to be n away from the beginning

      for (int i = 1; i <= n + 1; i++) {
        first = first.next;
      }
      
      while (first != null) {
        first = first.next;
        second = second.next;
      }
      second.next = second.next.next;
      return dummy.next; 
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
        ListNode result = s.removeNode(head, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}