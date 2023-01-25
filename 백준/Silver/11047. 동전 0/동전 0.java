import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] coin;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coin = new int[n];

        for (int idx = n - 1; idx >= 0; idx--) {
            coin[idx] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        while (k != 0) {
            if (k / coin[idx] > 0) {
                answer += k / coin[idx];
                k %= coin[idx];
            }
            idx++;
        }
        System.out.println(answer);
    }
}