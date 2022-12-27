import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = arr[n - 1];
        long count;
        int result = 0, mid;

        while (start <= end) {
            count = 0;
            mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {
                if (arr[i] > mid)
                    count += arr[i] - mid;
            }

            if (count < m) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.print(result);
    }
}
