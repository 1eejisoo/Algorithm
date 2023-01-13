import java.util.Stack;

class Solution {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] input = s.toCharArray();
        stack.push(input[0]);

        for (int i = 1; i < input.length; i++) {
            if (input[i] == ')' && !stack.isEmpty()) {
                stack.pop();
                continue;
            }
            stack.push(input[i]);
        }

        return stack.isEmpty();
    }
}