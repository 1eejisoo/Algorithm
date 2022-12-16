import java.util.Stack;

class Solution
{
    public static int solution(String s)
    {
        
        Stack<Character> stack = new Stack<>();
        char c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if (!stack.isEmpty() && c == stack.peek()) stack.pop();
            else stack.push(c);
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}