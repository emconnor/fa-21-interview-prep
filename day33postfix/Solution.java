package day33postfix;
import java.util.*;

/**
  Write a function to evaluate the value of an expression in postfix notation represented 
  by a string with numbers between 0 and 9 and operators separated by whitespace. The 
  expression supports 4 binary operators '+', '*', '-' and '/'.
 */

class Solution {
    
    public int evalPostfix(String[] tokens) {

      // inputs: string of "tokens", all tokens are integers or 1 of 4 binary operators +, *, and /
      // output: integer (the evaluation of the postfix expression)
      // "1", "2", "*", "3" "-" = 6
      // rules
      // binary operations, only working with two integers at a time
      // whenever there is an operator, using it to operate on the last two integeres added to the stack
      // when the while loop is over, the last item in the stack will be the result

      // variables to store stack pops (just two since this is binary)
      // stack
      // while loop

      Stack<Integer> stack = new Stack<>();

      int firstOperand = 0;
      int secondOperand = 0;
      int result = 0;
      int index = 0;

      while (index < tokens.length) {
        switch (tokens[index]) {
          case "+":
            secondOperand = stack.pop();
            firstOperand = stack.pop();
            result = firstOperand + secondOperand;
            stack.push(result);
            index++;
            break;
          case "-":
            secondOperand = stack.pop();
            firstOperand = stack.pop();
            result = firstOperand - secondOperand;
            stack.push(result);
            index++;
            break;
          case "/":
            secondOperand = stack.pop();
            firstOperand = stack.pop();
            result = firstOperand / secondOperand;
            stack.push(result);
            index++;
            break;
          case "*":
            secondOperand = stack.pop();
            firstOperand = stack.pop();
            result = firstOperand * secondOperand;
            stack.push(result);
            index++;
            break;
          default:
            stack.push(Integer.parseInt(tokens[index]));
            index++;
        }
      }
      return stack.pop();
    }
  
    public static void main(String[] args) {
      String[] tokens = {"2","1","+","3","*"};
      String[] tokens2 = {"4","13","5","/","+"};
      String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
      Solution s = new Solution();
      int result = s.evalPostfix(tokens3);
      System.out.println(result);
      
    }
}