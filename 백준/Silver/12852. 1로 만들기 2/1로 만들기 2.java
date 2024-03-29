import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static int[] pre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        pre = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            pre[i] = i - 1;
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                pre[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                pre[i] = i / 2;
            }
        }
        System.out.println(dp[n]);

        int idx = n;
        System.out.print(n + " ");
        while (idx != 1) {
            System.out.print(pre[idx] + " ");
            idx = pre[idx];
        }
    }
}