import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static boolean isSameNumber(int y, int x, int N) {
        int number = video[y][x];

        for (int i = y; i < y + N; i++) {
            for (int j = x; j < x + N; j++) {
                if (number != video[i][j]) return false;
            }
        }

        return true;
    }

    public static void quadTree(int y, int x, int N) {
        if (isSameNumber(y, x, N) || N == 1) {
            sb.append(video[y][x]);
            return;
        }

        sb.append("(");
        quadTree(y, x, N / 2);
        quadTree(y, x + N / 2, N / 2);
        quadTree(y + N / 2, x, N / 2);
        quadTree(y + N / 2, x + N / 2, N / 2);
        sb.append(")");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        video = new int[N][N];
        String s;

        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = s.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N);

        System.out.print(sb);
    }
}