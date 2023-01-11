import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 인접 리스트
public class Main {
    static int n, m;
    static boolean[] visited = new boolean[1005];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static int bfs() {
        int num = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            num++;

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited[i] = true;

            while(!q.isEmpty()) {
                int cur = q.poll();
                for (Integer a : adj.get(cur)) {
                    if (visited[a]) continue;
                    q.offer(a);
                    visited[a] = true;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int u, v;

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        System.out.println(bfs());
    }
}