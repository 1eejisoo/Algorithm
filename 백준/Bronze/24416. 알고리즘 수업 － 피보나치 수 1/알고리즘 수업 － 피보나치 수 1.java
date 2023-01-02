import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int recur_cnt = 0;
    static int dp_cnt = 0;
    static long[] dp = new long[41];

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            recur_cnt++;
            return 1;
        } else return fib(n - 1) + fib(n - 2);
    }

    public static long fibonacci(int n) {
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp_cnt++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        sb.append(recur_cnt).append(" ").append(dp_cnt);

        System.out.print(sb);
    }
}