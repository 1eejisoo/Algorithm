import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void combination(int[] out, int depth, int start, int n, int r) {
        if (depth == r) {
            for (int o : out) {
                sb.append(o).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            out[depth] = i + 1;
            combination(out, depth + 1, i + 1, n, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] out = new int[M];

        combination(out, 0, 0, N, M);

        System.out.print(sb);
    }
}