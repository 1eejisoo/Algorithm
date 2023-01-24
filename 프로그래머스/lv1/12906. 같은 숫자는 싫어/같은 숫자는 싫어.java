import java.util.Stack;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int n : arr) {
            if (stack.isEmpty() || stack.peek() != n) {
                stack.push(n);
            }
        }
        int size = stack.size();
        int[] answer = new int[size];

        size--;
        while(!stack.isEmpty()) {
            answer[size--] = stack.pop();
        }
        return answer;
    }
}