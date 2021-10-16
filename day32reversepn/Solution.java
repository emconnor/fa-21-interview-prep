package day32reversepn;
import java.util.*;

/**
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
Note that division between two integers should truncate toward zero.
It is guaranteed that the given RPN expression is always valid. That means the expression would 
always evaluate to a result, and there will not be any division by zero operation.
 */

class Solution {
    
    public int evalPRN(String[] tokens) {

      int result = 0;
      int first = 0;
      int second = 0;

      Stack<Integer> stack = new Stack<>();
      int i = 0;

      while (i < tokens.length) {
        switch (tokens[i]) {
          case ("+"):
           second = stack.pop();
           first = stack.pop();
           result = first + second;
           stack.push(result);
           i++;
           break;
          case ("-"):
            second = stack.pop();
            first = stack.pop();
            result = first - second;
            stack.push(result);
            i++;
            break;
          case ("*"):
            second = stack.pop();
            first = stack.pop();
            result = first * second;
            stack.push(result);
            i++;
            break;
          case ("/"):
            second = stack.pop();
            first = stack.pop();
            result = first / second;
            stack.push(result);
            i++;
            break;
          default:
            stack.push(Integer.parseInt(tokens[i]));
            i++;
        }
      }
      return stack.pop();
    }
  
    public static void main(String[] args) {
      String[] tokens = {"2","1","+","3","*"};
      String[] tokens2 = {"4","13","5","/","+"};
      String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
      Solution s = new Solution();
      int result = s.evalPRN(tokens);
      System.out.println(result);
      
    }
}