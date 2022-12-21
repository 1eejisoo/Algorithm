import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void permutation(int[] arr, boolean[] visited, int cnt, int N, int M) {
        if (cnt == M) {
            for (int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    arr[cnt] = i;
                    permutation(arr, visited, cnt + 1, N, M);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        boolean[] visited = new boolean[N + 1];

        permutation(arr, visited, 0, N, M);

        System.out.print(sb);
    }
}