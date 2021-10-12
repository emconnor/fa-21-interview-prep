package day28reversedoublylinked;

/**
 * Definition for singly-linked list.
 */

public class DoubleLink {

    int val;
    DoubleLink next;
    DoubleLink prev;

    DoubleLink() {
    }

    DoubleLink(int val) {
        this.val = val;
    }

    DoubleLink(int val, DoubleLink prev, DoubleLink next) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
