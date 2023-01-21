import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Deque<Integer> deque = new LinkedList<>();

    public static void push(String cmd, int x) {
        if (cmd.equals("push_front")) {
            deque.addFirst(x);
            return;
        }
        deque.addLast(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];

            if (input.length > 1) {
                push(cmd, Integer.parseInt(input[1]));
                continue;
            }
            if (cmd.equals("pop_front")) {
                if (deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollFirst()).append("\n");
                continue;
            }
            if (cmd.equals("pop_back")) {
                if (deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollLast()).append("\n");
                continue;
            }
            if (cmd.equals("size")){
                sb.append(deque.size()).append("\n");
                continue;
            }
            if (cmd.equals("empty")) {
                if(deque.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
                continue;
            }
            if (cmd.equals("front")) {
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peekFirst()).append("\n");
                continue;
            }
            if (cmd.equals("back")) {
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}