import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        boolean flag ;
        String str;
        char c;

        for (int i = 0; i < T; i++) {
            flag = true;
            stack.clear();
            str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                c = str.charAt(j);

                if (c == '(') {
                    stack.push('(');
                    continue;
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                    continue;
                }
                flag = false;
                break;
            }
            
            if (!flag) {
                sb.append("NO").append("\n");
                continue;
            }
            if (stack.isEmpty()) {
                sb.append("YES").append("\n");
                continue;
            }
            sb.append("NO").append("\n");
        }
        System.out.print(sb);
    }
}