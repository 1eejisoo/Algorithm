import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int x;

        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());

            if (x > 0) {
                pq.add(x);
                continue;
            }
            if (pq.isEmpty()) {
                sb.append(0).append("\n");
                continue;
            }
            sb.append(pq.poll()).append("\n");
        }

        System.out.print(sb);
    }
}