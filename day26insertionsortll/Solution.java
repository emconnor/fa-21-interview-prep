package day26insertionsortll;

/**
 * Given the head of a singly linked list, sort the list using insertion sort, and return 
 the sorted list's head.
 The steps of the insertion sort algorithm:
 1. Insertion sort iterates, consuming one input element each repetition and 
 growing a sorted output list.
 2. At each iteration, insertion sort removes one element from the input data, 
 3. finds the location it belongs within the sorted list and inserts it there.
 4. It repeats until no input elements remain.
 */

class Solution {
    
    public ListNode insertionSortLinkedList(ListNode head) {

      // Initialize partially sorted list
      ListNode dummy = new ListNode(0), prev = dummy, current = head;

      while(current != null)
      {
          if(prev.val > current.val)
              prev = dummy;

          // Find the right place to insert current node
          while(prev.next != null && prev.next.val < current.val)
              prev = prev.next;

          // Insert current between prev and prev.next
          ListNode nextNode = current.next;
          current.next = prev.next;
          prev.next = current;
          current = nextNode;
      }
      return dummy.next;
    }
  
    public static void main(String[] args) {
      ListNode head = new ListNode(7);
      ListNode one = new ListNode(2);
      head.next = one;
      ListNode two = new ListNode(12);
      one.next = two;
      ListNode three = new ListNode(1);
      two.next = three;
      ListNode four = new ListNode(5);
      three.next = four;
      Solution s = new Solution();
      ListNode result = s.insertionSortLinkedList(head);
      while (result != null) {
        System.out.println(result.val);
        result = result.next;
        }
    }
}