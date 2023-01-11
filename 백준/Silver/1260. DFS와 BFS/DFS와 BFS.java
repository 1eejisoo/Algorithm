import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, v;
    static boolean[] visited;
    static List<Integer>[] adj;    // 방법 1, 2와 다른 부분

    // 비재귀 DFS
    public static void dfs() {
        visited = new boolean[n + 1];
        Stack<Integer> s = new Stack<>();
        s.push(v);
        while(!s.isEmpty()) {
            int cur = s.pop();
            if (visited[cur]) continue;
            visited[cur] = true;
            System.out.print(cur + " ");

            // 스택의 특성상 정점을 역순으로 넣어야 한다.
            for (int i = 0; i < adj[cur].size(); i++) {
                int nxt = adj[cur].get(adj[cur].size() - 1 - i);
                if (visited[nxt]) continue;
                s.push(nxt);
            }
        }
    }

    public static void bfs() {
        visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for (Integer a : adj[cur]) {
                if (visited[a]) continue;
                q.offer(a);
                visited[a] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        int a, b;

        // 방법 1, 2와 다른 부분
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        // 작은 순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(adj[i]);
        }

        visited = new boolean[n + 1];
        dfs();
        System.out.println();
        bfs();
    }
}