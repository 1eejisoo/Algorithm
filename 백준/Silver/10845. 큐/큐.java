import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String cmd;
        int x, back_num = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if (!st.hasMoreTokens()) break;
            cmd = st.nextToken();

            if (cmd.equals("push")) {
                x = Integer.parseInt(st.nextToken());
                queue.add(x);
                back_num = x;
                continue;
            }
            if (cmd.equals("pop")) {
                if (!queue.isEmpty())
                    sb.append(queue.poll()).append("\n");
                else sb.append("-1").append("\n");
                continue;
            }
            if (cmd.equals("size")) {
                sb.append(queue.size()).append("\n");
                continue;
            }
            if (cmd.equals("empty")) {
                if (queue.isEmpty())
                    sb.append("1").append("\n");
                else sb.append("0").append("\n");
                continue;
            }
            if (cmd.equals("front")) {
                if (!queue.isEmpty())
                    sb.append(queue.peek()).append("\n");
                else sb.append("-1").append("\n");
                continue;
            }
            if (cmd.equals("back")) {
                if (!queue.isEmpty())
                    sb.append(back_num).append("\n");
                else sb.append("-1").append("\n");
            }
        }
        System.out.print(sb);
    }
}