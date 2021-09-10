package day1partition;

/**
 * Partition: Write code to partition a linked list around a value x, such that
 * all nodes less than x come before equal to x. If x is contained within the
 * list, the values of x only need to be after the elements less than x (see
 * below). The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 */

class Solution {
    public ListNode partition(ListNode node, int p) {
        ListNode dummy = new ListNode();
        dummy.next = node;
        // initialize r pointer to first value >= p
        ListNode r = dummy.next;
        while ((r != null) && (r.val < p)) {
            r = r.next;
        }
        // loop until we run out of unknown values
        ListNode c;
        ListNode t;
        while ((r != null) && (r.next != null)) {
            c = r.next;
            if (c.val >= p) {
                // handle right side value
                r = c;
            } else {
                // handle left side value
                r.next = c.next;
                t = dummy.next;
                dummy.next = c;
                c.next = t;
            }
        }
        // pop off the dummy
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        head.next = one;
        ListNode two = new ListNode(5);
        one.next = two;
        ListNode three = new ListNode(8);
        two.next = three;
        ListNode four = new ListNode(3);
        three.next = four;
        Solution s = new Solution();
        ListNode result = s.partition(head, 5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}