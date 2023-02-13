import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void comb(int[] arr, boolean[] visited, int start, int r) {
        if(r == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            comb(arr, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] arr = new int[n];
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            comb(arr, visited, 0, 6);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}