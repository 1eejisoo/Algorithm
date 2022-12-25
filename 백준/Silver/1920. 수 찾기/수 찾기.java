import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int binarySearch(int[] A, int target, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (target == A[mid]) return mid;
        else if (target > A[mid]) return binarySearch(A, target, mid + 1, end);
        else return binarySearch(A, target, start, mid - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int target_number;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            target_number = Integer.parseInt(st.nextToken());
            if (binarySearch(A, target_number, 0, A.length - 1) >= 0)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}