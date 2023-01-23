import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[] A;

    static int min = Integer.MAX_VALUE;
    static TreeSet<Integer> set = new TreeSet<>();

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

        int end = 0;
        for (int start = 0; start < n; start++) {
            while(end < n && A[end] - A[start] < m) end++;
            if (end == n) break;
            min = Math.min(min, A[end] - A[start]);
        }
        System.out.println(min);
    }
}
