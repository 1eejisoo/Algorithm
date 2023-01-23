import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// N <= 1000이므로 O(N^4), O(N^3)으로 풀면 시간초과
// => O(N^2logN)
public class Main {

    static int n;
    static int[] U;
    static int[] two_add;

    // O(logN^2) = O(2logN) = O(logN)
    public static boolean binary_search(int target) {
        int st = 0;
        int en = n * n - 1;
        while (st < en) {
            int mid = (st + en) / 2;
            if (two_add[mid] == target) return true;
            if (two_add[mid] < target) st = mid + 1;
            else en = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        U = new int[n];
        two_add = new int[n * n];

        for (int i = 0; i < n; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(U);
        int idx = 0;
        // O(N^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                two_add[idx++] = U[i] + U[j];
            }
        }
        Arrays.sort(two_add);
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (binary_search(U[i] - U[j])) {
                    System.out.println(U[i]);
                    return;
                }
            }
        }
    }
}