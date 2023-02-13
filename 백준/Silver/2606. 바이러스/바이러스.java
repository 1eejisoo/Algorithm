import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, T;
    static List<Integer>[] graph;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int answer = 0;

    public static void solution() {
        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : graph[cur]) {
                if (visited[nxt]) continue;
                visited[nxt] = true;
                q.offer(nxt);
                answer++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        q.offer(1);
        visited[1] = true;
        solution();

        System.out.print(answer);
    }
}