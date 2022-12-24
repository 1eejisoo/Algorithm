import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    enum Command {
        pop {
            @Override
            public int command(Stack<Integer> stack) {
                return stack.empty() ? -1 : stack.pop();
            }
        },
        size {
            @Override
            public int command(Stack<Integer> stack) {
                return stack.size();
            }
        },
        empty {
            @Override
            public int command(Stack<Integer> stack) {
                return stack.empty() ? 1 : 0;
            }
        },
        top {
            @Override
            public int command(Stack<Integer> stack) {
                return stack.empty() ? -1 : stack.peek();
            }
        };

        abstract public int command(Stack<Integer> stack);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        String command;
        int n;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();

            if (command.equals("push")) {
                n = Integer.parseInt(st.nextToken());
                stack.push(n);
                continue;
            } 
            sb.append(Command.valueOf(command).command(stack)).append("\n");
        }
        System.out.print(sb);
    }
}