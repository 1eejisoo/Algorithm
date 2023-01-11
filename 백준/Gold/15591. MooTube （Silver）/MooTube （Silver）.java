import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
    int weight;
    int v;

    Edge(int v, int weight) {
        this.weight = weight;
        this.v = v;
    }
}

public class Main {
    static int n, q;
    static boolean[] visited;
    static ArrayList<Edge>[] graph;

    /**
     * <1과 4의 USADO를 굳이 구해서 집어넣지 않아도 되는 이유>
     * (1과 4의 USADO) = min(1과 2의 USADO, 2와 4의 USADO)
     * 1. 1과 2의 USADO가 k보다 작은 경우 => 1과 4의 USADO는 어차피 k 이상이 될 수 없으므로 패스
     * 2. 1과 2의 USADO가 k보다 큰 경우 => 1과 4의 USADO는 적어도 k 이상은 되므로 count++ 처리
     */
    public static int bfs(int k, int v) {
        int count = 0;
        visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Edge edge : graph[cur]) {
                int cur_v = edge.v;
                int cur_weight = edge.weight;

                if (visited[cur_v] || cur_weight < k) continue;
                q.offer(cur_v);
                visited[cur_v] = true;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[n1].add(new Edge(n2, w));
            graph[n2].add(new Edge(n1, w));
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int count = bfs(k, v);
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}