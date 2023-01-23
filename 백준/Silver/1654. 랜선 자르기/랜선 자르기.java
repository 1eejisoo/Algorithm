import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int k, n;
    static int[] LAN_arr;

    public static boolean count(long X) {
        long sum = 0;

        for (int lan : LAN_arr) {
            sum += lan / X;
        }
        return sum >= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        LAN_arr = new int[k];

        for (int i = 0; i < k; i++) {
            LAN_arr[i] = Integer.parseInt(br.readLine());
        }


        Arrays.sort(LAN_arr);

        long start = 1, mid;
        long end = LAN_arr[k - 1];

        while (start < end) {
            mid = (start + end + 1) / 2;
            // 랜선의 길이가 mid일 때 랜선이 N개 이상인가?
            if (count(mid)) start = mid;    // N개 이상 -> 랜선의 길이를 크게
            else end = mid - 1;  // N개 미만 -> 랜선의 개수를 작게
        }
        System.out.print(start);
    }
}
