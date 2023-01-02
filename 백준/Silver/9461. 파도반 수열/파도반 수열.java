import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n;

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            if (dp[n] != 0) {
                sb.append(dp[n]).append("\n");
                continue;
            }
            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}