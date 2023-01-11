import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, v;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static void dfs(int cur) {
        visited[cur] = true;

        System.out.print(cur + " ");
        for (Integer a : adj.get(cur)) {
            if (visited[a]) continue;
            dfs(a);
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
            for (Integer a : adj.get(cur)) {
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

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adj.get(i));
        }
        
        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();
        bfs();
    }
}