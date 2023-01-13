import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] adj;
    static int[] deg;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    static void topological_sort() {
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for (int nxt : adj[cur]) {
                deg[nxt]--;
                if (deg[nxt] == 0) q.offer(nxt);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        deg = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int in, out;
            in = Integer.parseInt(st.nextToken());
            out = Integer.parseInt(st.nextToken());
            adj[in].add(out);
            deg[out]++;
        }

        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) q.offer(i);
        }

        topological_sort();
        System.out.println(sb);
    }
}