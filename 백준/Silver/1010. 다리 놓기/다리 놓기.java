import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t;
    static int[][] test_case;
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        test_case = new int[t][2];
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            test_case[i][0] = Integer.parseInt(st.nextToken());
            test_case[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= 30; i++) {
            dp[1][i] = i;
            dp[i][i] = 1;
        }

        for (int i = 2; i <= 30; i++) {
            for (int j = i + 1; j <= 30; j++) {
                for (int k = 1; k <= j - i + 1; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println(dp[test_case[i][0]][test_case[i][1]]);
        }
    }
}