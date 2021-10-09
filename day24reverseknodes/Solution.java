

package day24reverseknodes;
import java.util.Stack;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */

class Solution {
    
    public ListNode reverseKNodes(ListNode head, int k) {

      //Create an array of size k or a stack
      Stack<Integer> stack = new Stack<>();

      //Create a Left and Right pointer and initially set them to head node
      ListNode l = head;
      ListNode r = head;

      //Iterate through the LinkedList with two pointers (Left/Right)
      while (true) {
        for (int i = 0; i < k; i++) {
          if (r != null) {
            stack.add(r.val);
            r = r.next;
          } else {
            return head;
          }
        }
        for (int i = 0; i < k; i++) {
          l.val = stack.pop();
          l = l.next;
        }
        l = r;
      }
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
      ListNode result = s.reverseKNodes(head, 2);
      while (result != null) {
        System.out.println(result.val);
        result = result.next;
        }
    }
}