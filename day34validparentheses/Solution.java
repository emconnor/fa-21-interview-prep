package day34validparentheses;
import java.util.*;

/*
Given a string s containing characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
*/

public class Solution {


  public boolean validParentheses(String str) {
    // map to hold paretheses pairs
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    // stack to hold opening brackets
    Stack<Character> stack = new Stack<>();
    int i = 0;

    // while stack is not empty and we haven't iterated through the whole string
    do {
      if (map.containsValue(str.charAt(i))) {
        stack.push(str.charAt(i));
        i++;
      } else if (map.get(str.charAt(i)) == stack.pop()) {
        i++;
        continue;
      } else {
        return false;
      }
    } while (!stack.isEmpty() && i < str.length());
    
    if (stack.isEmpty()) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    // String str = "()";
    // String str2 = "()[]{}";
    // String str3 = "(]";
    // String str4 = "([)]";
    String str5 = "{[]";
    Solution s = new Solution();
    boolean result = s.validParentheses(str5);
    System.out.println(result);
  
  }
}
