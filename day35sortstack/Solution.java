package day35sortstack;
import java.util.*;

/*
Write a program to sort a stack such that the smallest items are on top. You can use an 
additional temporary stack, but you may not copy elements into any other data structure 
(such as an array).
The stack supports the following operations : push, pop, peek, isEmpty.
*/

/*
1. Create an additional temporary Stack.
2. While input stack is NOT empty do:
3. Pop an element from input stack called stack.
4. While temporary stack is NOT empty and top of temporary stack is greater than stack:
5. Pop from temporary stack and push it to stack.
6. Push stack in temporary stack.
7. In the end, the sorted numbers are in the temporary Stack.
*/

public class Solution {


  public Stack<Integer> sortStack(Stack<Integer> stack) {
   
    // temp stack
    Stack<Integer> tempStack = new Stack<>();
    int temp = 0;

    // while input stack is not empty
    while (!stack.isEmpty()) {
      // pop item from stack and save as temp
      temp = stack.pop();

      // while tempStack is not empty and while tempStack.peek > stack.peek
      while (!tempStack.isEmpty() && tempStack.peek() < temp) {
        stack.push(tempStack.pop());
      }

      tempStack.push(temp);
    }
    return tempStack;
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    // stack.push(10);
    Solution s = new Solution();
    Stack<Integer> result = s.sortStack(stack);
    while (!result.isEmpty()) {
      System.out.print(result.pop() + " ");
    }
    System.out.println("");
    
  }
}
