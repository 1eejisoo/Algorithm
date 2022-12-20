import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;
    public static void blackJack(int[] arr, boolean[] visited, int M) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }

        if (sum > max && sum <= M)
            max = sum;
    }

    public static void comb(int[] arr, boolean[] visited, int start, int r, int M) {
        if (r == 0) {
            blackJack(arr, visited, M);
        } else {
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb(arr, visited, i + 1, r - 1, M);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        comb(arr, visited, 0, 3, M);

        System.out.print(max);
    }
}