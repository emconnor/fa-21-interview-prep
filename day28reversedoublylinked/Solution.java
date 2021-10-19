package day28reversedoublylinked;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

class Solution {
    
    public DoubleLink reverseLinkedList(DoubleLink head) {

      if (head == null) {
        System.out.println("Error: null list");
        return head;
      }

      DoubleLink curr = head;
      DoubleLink temp = null;

      while (curr != null) {
        temp = curr.prev;
        curr.prev = curr.next;
        curr.next = temp;
        curr = curr.prev;
      }

      if (temp != null) {
        head = temp.prev;
      }
     return head;
    }
  
    public static void main(String[] args) {
      DoubleLink head = new DoubleLink(1);
      DoubleLink one = new DoubleLink(2);
      head.next = one;
      one.prev = head;
      DoubleLink two = new DoubleLink(3);
      one.next = two;
      two.prev = one;
      DoubleLink three = new DoubleLink(4);
      two.next = three;
      three.prev = two;
      DoubleLink four = new DoubleLink(5);
      three.next = four;
      four.prev = three;
      Solution s = new Solution();
      DoubleLink result = s.reverseLinkedList(head);
      while (result != null) {
        System.out.println(result.val);
        result = result.next;
        }
    }
}