import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] square;
    static int[] cnt = new int[2];

    public static boolean isSameColor(int y, int x, int N) {
        int color = square[y][x];

        for (int i = y; i < y + N; i++) {
            for (int j = x; j < x + N; j++) {
                if (color != square[i][j]) return false;
            }
        }

        return true;
    }

    public static void divide(int y, int x, int N) {
        // 같은 사각형 안에 모두 같은 색만 존재하는 것이 아니면
        // 또는 사각형 1개로만 이루어졌으면
        if (isSameColor(y, x, N) || N == 1) {
            cnt[square[y][x]]++;
            return;
        }

        divide(y, x, N / 2);
        divide(y, x + N / 2, N / 2);
        divide(y + N / 2, x, N / 2);
        divide(y + N / 2, x + N / 2, N / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        square = new int[N][N];
        StringTokenizer st;
        int n;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.print(cnt[0] + "\n" + cnt[1]);
    }
}