import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, x;
    static int[] A;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            A[i] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        x = Integer.parseInt(br.readLine());

        int start = 0, end = n - 1;
        while (start < end) {
            int tot = A[start] + A[end];
            if (tot > x) {
                end--;
            } else {
                start++;
            }
            if (tot == x) {
                result++;
            }
        }
        System.out.println(result);
    }
}