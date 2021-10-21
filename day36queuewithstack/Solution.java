package day36queuewithstack;
import java.util.*;

/*
We are given a stack data structure that supports standard operations like 
(push, pop, peek, and empty), implement a queue using instances of stack data 
structure and operations on them.

Implement a Queue class with the following methods:

void push(int x): Pushes element x to the back of the queue.
int pop(): Removes the element from the front of the queue and returns it.
int peek(): Returns the element at the front of the queue.
boolean empty(): Returns true if the queue is empty, false otherwise.
*/

public class Solution {

  //instance var
  Stack<Integer> stack = new Stack<>();
  Stack<Integer> temp;
  int result;

  // pushes element to back of queue
  void qPush(int x) {
    stack.push(x);
  }

  // Removes the element from the front of the queue and returns it.
  int qPop() {
    this.temp = new Stack<>();
    while (!this.stack.empty()) {
      this.temp.push(this.stack.pop());
    }
    this.result = this.temp.pop();
    while (!this.temp.empty()) {
      this.stack.push(this.temp.pop());
    }
    return this.result;
  }

  // Returns the element at the front of the queue.
  int qPeek() {
    this.temp = new Stack<>();
    while (!this.stack.empty()) {
      this.temp.push(this.stack.pop());
    }
    this.result = this.temp.peek();
    while (!this.temp.empty()) {
      this.stack.push(this.temp.pop());
    }
    return this.result;
  }

  // Returns true if the queue is empty, false otherwise.
  boolean qEmpty() {
    return this.stack.empty();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.qPush(1);
    s.qPush(2);
    //s.qPop();
    System.out.println(s.qPeek());

    
  }
}

