package day37stackwithqueue;
import java.util.*;

/*
Given a Queue data structure that supports standard operations like push, top, pop, 
and empty. Implement a Stack data structure using only instances of Queue and queue 
operations allowed on the instances.

Implement a Stack class:

void push(int x): Pushes element x to the top of the stack.
int pop(): Removes the element on the top of the stack and returns it.
int top(): Returns the element on the top of the stack.
boolean empty(): Returns true if the stack is empty, false otherwise.
*/

public class Solution {

  //instance var
  Queue<Integer> q = new LinkedList<Integer>();
  Queue<Integer> temp;
  int result;

  // pushes element to back of queue
  void sPush(int x) {
    q.add(x);
  }

  // Removes the element from the front of the queue and returns it.
  int sPop() {
    this.temp = new LinkedList<Integer>();
    while (this.q.size() > 1) {
      this.temp.add(this.q.remove());
    }
    this.result = this.q.remove();
    while (!this.temp.isEmpty()) {
      this.q.add(this.temp.remove());
    }
    return this.result;
  }

  // Returns the element at the front of the queue.
  int sTop() {
    this.temp = new LinkedList<Integer>();
    while (this.q.size() > 1) {
      this.temp.add(this.q.remove());
    }
    this.result = this.q.peek();
    temp.add(this.result);
    while (!this.temp.isEmpty()) {
      this.q.add(this.temp.remove());
    }
    return this.result;
  }

  // Returns true if the stack is empty, false otherwise.
  boolean sEmpty() {
    return this.q.size() == 0;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.sPush(1);
    s.sPush(2);
    System.out.println(s.sTop());
    System.out.println(s.sPop());
  }
}

