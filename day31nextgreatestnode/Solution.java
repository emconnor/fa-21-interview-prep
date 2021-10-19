package day31nextgreatestnode;
import java.util.Arrays;

/**
 * We are given a linked list with head as the first node. Let's number the nodes in the list: 
 * node_1, node_2, node_3, ... etc.
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val 
 * such that j > i, node_j.val > node_i.val, and j is the smallest possible choice. If such a 
 * j does not exist, the next larger value is 0.
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 */

class Solution {
    
    public int[] nextGreatestNode(ListNode head) {

      //if ll is null, return empty array
      if (head == null) {
        int[] arr = new int[0];
        return arr;
      }

      // dummy node to count length of ll
      ListNode dummy = head;
      int len = 0;
      while (dummy != null) {
        len++;
        dummy = dummy.next;
      }
      // initialize array to length of ll
      int[] result = new int[len];
      
      //Create a Left and Right pointer and initially set them to head node
      ListNode l = head;
      ListNode r = head;
      int i = 0;
      // Iterate through the LinkedList with two pointers (Left/Right)
      // while r is not null
      while (r != null) {
        //compare r.val to l.val to find next greatest node
        if (r.val <= l.val) {
          // if r.next is null, we are at the end of the list and there is no greater node
          if (r.next == null) {
            // set result[i] to zero 
            result[i] = 0;
            // move l up
            l = l.next;
            // put r back to l
            r = l;
            i++;
            continue;
          }
          // otherwise, move r forward to find the next greatest node
          r = r.next;
        } else {
          // if it is greater, set result[i] to this value and keep going
          result[i] = r.val;
          l = l.next;
          r = l;
          i++;
        }
      }
      return result;
    }
  
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode one = new ListNode(7);
      head.next = one;
      ListNode two = new ListNode(5);
      one.next = two;
      ListNode three = new ListNode(1);
      two.next = three;
      ListNode four = new ListNode(9);
      three.next = four;
      ListNode five = new ListNode(2);
      four.next = five;
      ListNode six = new ListNode(5);
      five.next = six;
      ListNode seven = new ListNode(1);
      six.next = seven;
      Solution s = new Solution();
      int[] result = s.nextGreatestNode(head);
      System.out.println(Arrays.toString(result));
      
    }
}