import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int t, n, m;
    static int[] A, B;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            A = new int[n];
            B = new int[m];

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            Arrays.sort(B);

            answer = 0;
            int en1 = n-1, en2 = m-1;
            while(en1 >= 0 && en2 >= 0) {
                int sum = A[en1] - B[en2];

                if (sum <= 0) {
                    en2--;
                } else {
                    answer += en2 + 1;
                    en1--;
                }
            }
            System.out.println(answer);
        }
    }
}