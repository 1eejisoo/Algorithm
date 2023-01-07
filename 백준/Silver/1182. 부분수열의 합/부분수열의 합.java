import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] arr;
    static boolean[] visited;
    static int answer = 0;

    public static void func(int depth, int sum) {
        if (depth == n) {
            if (sum == s) answer++;
            return;
        }
        func(depth + 1, sum);
        func(depth + 1, sum + arr[depth]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);

        if (s == 0) answer--;
        System.out.println(answer);
    }
}