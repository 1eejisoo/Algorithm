import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[] A;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        int start = 0, end = 0;
        while (end < n) {
            int cur = A[end] - A[start];

            if (cur < m) {
                end++;
                continue;
            }
            if (cur == m) {
                min = cur;
                break;
            }
            min = Math.min(min, cur);
            start++;
        }
        System.out.println(min);
    }
}
