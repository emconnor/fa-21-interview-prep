package day17add2nums;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single 
 * digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 
 * 0 itself.
 */

class Solution {
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {

      //check for nulls
      if (node1 == null && node2 == null) {
        System.out.println("both lists are null");
        return null;
      } 

      // create a dummy head, must initialize to 0 to avoid crashing program because of null exception
      // in order to not mess up the lists passed to us, we work with copies p and q
      ListNode head = new ListNode(0);
      ListNode p = node1, q = node2, curr = head;

      // initialize x, y, carry, and sum
      int x = 0, carry = 0, y = 0, sum = 0;
       
      while (p != null || q != null) {
        
        // this is a null check, if the node is null, then we have 0
        // means our program won't crash
        x = (p != null) ? p.val : 0;
        y = (q != null) ? q.val : 0;
        // here we add x and y and carry
        sum = x + y + carry;
        // we get the next carry by dividing by 10
        carry = sum / 10;
        // we make a new ListNode and attach it to current 
        // sum mod 10 to make sure we get the remainder if the sum is > 10
        curr.next = new ListNode(sum % 10);
        // move current to curr.next
        // by creating curr.next before we do this, we avoid the null pointer exception
        curr = curr.next;
        // do a null check and then set p to p.next
        if (p != null) p = p.next;
        // do a null check and then set q to q.next
        if (q != null) q = q.next;
      }

      if (carry > 0) {
        curr.next = new ListNode(carry);
      }
      return head.next; 
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode one = new ListNode(4);
        head1.next = one;
        ListNode two = new ListNode(3);
        one.next = two;
        ListNode head2 = new ListNode(5);
        ListNode one2 = new ListNode(6);
        head2.next = one2;
        ListNode two2 = new ListNode(4);
        one2.next = two2;
        Solution s = new Solution();
        ListNode result = s.addTwoNumbers(head1, head2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}