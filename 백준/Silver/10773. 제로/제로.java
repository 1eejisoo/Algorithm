import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0, n;

        for (int i = 0; i < K; i++) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                stack.pop();
                continue;
            }
            stack.push(n);
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.print(sum);
    }
}