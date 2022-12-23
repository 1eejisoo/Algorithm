import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] temperature = new int[N];
        int max = 0, sum;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            sum = 0;
            if (i + K > temperature.length) break;
            for (int j = i; j < i + K; j++) {
                sum += temperature[j];
            }
            if (i == 0) max = sum;
            if (max < sum) max = sum;
        }
        System.out.print(max);
    }
}