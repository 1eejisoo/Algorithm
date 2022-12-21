import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] users = new int[N][2];
        int result;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            users[i][0] = Integer.parseInt(st.nextToken());
            users[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            result = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (users[i][0] < users[j][0] && users[i][1] < users[j][1]) {
                    result++;
                }
            }
            sb.append(result).append(" ");
        }

        System.out.print(sb);
    }
}