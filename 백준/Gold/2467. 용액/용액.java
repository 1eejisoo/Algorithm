import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = n - 1;
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;

        while (start < end && end < n) {
            int sum = arr[start] + arr[end];

            if (Math.abs(sum) == 0) {
                result[0] = arr[start];
                result[1] = arr[end];
                break;
            } else if (Math.abs(min) > Math.abs(sum)) {
                result[0] = arr[start];
                result[1] = arr[end];
                min = sum;
            }
            if (sum > 0) end--;
            else start++;
        }
        System.out.println(result[0] + " " + result[1]);
    }
}