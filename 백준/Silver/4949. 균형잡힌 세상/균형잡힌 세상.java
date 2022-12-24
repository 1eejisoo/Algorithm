import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();

    public static String getResult(boolean flag) {
        if (stack.isEmpty() && flag)
            return "yes";
        return "no";
    }

    public static boolean isParenthesisOrBracket(char c) {
        return c == '(' || c == ')' || c == '[' || c == ']';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuffer result_sb = new StringBuffer();
        String input = br.readLine();
        String result, str;
        boolean flag;
        char c;

        while (input.charAt(0) != '.') {
            sb.delete(0, sb.length());
            flag = true;

            for (int i = 0; i < input.length(); i++) {
                if (isParenthesisOrBracket(input.charAt(i))) {
                    sb.append(input.charAt(i));
                }
            }

            if (sb.length() > 0) {
                str = sb.toString();
                stack.clear();

                for (int i = 0; i < str.length(); i++) {
                    c = str.charAt(i);

                    if (c == '(' || c == '[') {
                        stack.push(c);
                        continue;
                    }
                    if (!stack.isEmpty()) {
                        if (c == ')' && stack.peek() == '(') {
                            stack.pop();
                            continue;
                        }
                        if (c == ']' && stack.peek() == '[') {
                            stack.pop();
                            continue;
                        }
                    }
                    result = "no";
                    flag = false;
                    break;
                }
                result = getResult(flag);
            }
            // 괄호가 하나도 없는 경우
            else result = "yes";

            result_sb.append(result).append("\n");
            input = br.readLine();
        }
        System.out.print(result_sb);
    }
}