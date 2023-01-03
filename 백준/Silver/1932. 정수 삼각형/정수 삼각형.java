import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Integer[][] dp;
    static int[][] arr;

    public static int calc(int depth, int idx) {
        if (depth == n - 1)
            return dp[depth][idx];

        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(calc(depth + 1, idx), calc(depth + 1, idx + 1)) + arr[depth][idx];
        }
        return dp[depth][idx];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new Integer[n][n];
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }

        System.out.print(calc(0, 0));
    }
}