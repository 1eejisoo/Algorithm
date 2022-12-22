import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] data = new int[N];
        int[] sum_arr = new int[N + 1];
        int left, right, sum = 0;

        sum_arr[0] = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            sum += data[i];
            sum_arr[i + 1] = sum;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());

            sb.append(sum_arr[right] - sum_arr[left - 1])
                    .append("\n");
        }

        System.out.print(sb);
    }
}