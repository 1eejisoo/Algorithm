import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] p_arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;

        for (int i = 0; i < N; i++) {
            p_arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p_arr);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                sum += p_arr[j];
            }
        }
        System.out.print(sum);
    }
}