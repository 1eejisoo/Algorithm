import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] adj;
    static int[] parent;

//    static void dfs(int cur) {
//        for (int nxt : adj[cur]) {
//            if (parent[cur] == nxt) continue;
//            parent[nxt] = cur;
//            dfs(nxt);
//        }
//    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : adj[cur]) {
                if (parent[cur] == nxt) continue;
                parent[nxt] = cur;
                q.offer(nxt);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        adj = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        bfs();

        for (int i = 2; i <= n; i++)
            System.out.println(parent[i]);
    }
}