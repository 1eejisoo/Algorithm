import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    static int[][] graph;
    static int result = 0;

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;
        if (x <= y) parent[y] = x;
        else parent[x] = y;
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        return find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  // 컴퓨터의 수(V)
        M = Integer.parseInt(br.readLine());  // 연결할 수 있는 선의 수(E)

        parent = new int[N + 1];
        graph = new int[M][3];

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));

        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < M; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            int cost = graph[i][2];

            if (find(u) != find(v)) {
                union(u, v);
                result += cost;
            }
        }

        System.out.println(result);
    }
}