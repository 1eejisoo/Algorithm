import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int V, E;
    static int[][] graph;
    static int[] parent;
    static int count = 0;
    static long result = 0;

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;
        if (x <= y) parent[y] = x;
        else parent[x] = y;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    public static boolean isDiffGroup(int x, int y) {
        return find(x) != find(y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new int[E][3];
        parent = new int[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph[i][0] = Integer.parseInt(st.nextToken());  // A번 정점
            graph[i][1] = Integer.parseInt(st.nextToken());  // B번 정점
            graph[i][2] = Integer.parseInt(st.nextToken());  // 간선의 가중치 C
        }

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));

        for (int i = 0; i < E; i++) {
            if (count == V - 1) break;
            if (isDiffGroup(graph[i][0], graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                result += graph[i][2];
                count++;
            }
        }
        System.out.println(result);
    }
}