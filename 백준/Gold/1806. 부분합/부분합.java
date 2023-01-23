import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, s;
    static int[] A;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        A = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0, sum = A[0];
        for (int start = 0; start < n; start++) {
            while(end < n && sum < s) {
                end++;
                if (end != n) sum += A[end];
            }
            if (end == n) break;
            min = Math.min(min, end - start + 1);
            sum -= A[start];
        }
        if (min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}
