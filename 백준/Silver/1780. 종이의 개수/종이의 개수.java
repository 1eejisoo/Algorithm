import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] paper;
    static int minus_one_count = 0;
    static int zero_count = 0;
    static int one_count = 0;

    public static boolean isSameNumber(int y, int x, int N) {
        int number = paper[y][x];

        for (int i = y; i < y + N; i++) {
            for (int j = x; j < x + N; j++) {
                if (number != paper[i][j]) return false;
            }
        }

        return true;
    }

    public static void paperCount(int y, int x, int N) {
        if (isSameNumber(y, x, N) || N == 1) {
            if (paper[y][x] == -1) {
                minus_one_count++;
                return;
            }
            if (paper[y][x] == 0) {
                zero_count++;
                return;
            }
            if (paper[y][x] == 1) {
                one_count++;
                return;
            }
        }
        paperCount(y, x, N / 3);
        paperCount(y, x + N / 3, N / 3);
        paperCount(y, x + (N / 3) * 2, N / 3);

        paperCount(y + N / 3, x, N / 3);
        paperCount(y + N / 3, x + N / 3, N / 3);
        paperCount(y + N / 3, x + (N / 3) * 2, N / 3);

        paperCount(y + (N / 3) * 2, x, N / 3);
        paperCount(y + (N / 3) * 2, x + N / 3, N / 3);
        paperCount(y + (N / 3) * 2, x + (N / 3) * 2, N / 3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paperCount(0, 0, N);

        System.out.print(minus_one_count + "\n" + zero_count + "\n" + one_count);
    }
}