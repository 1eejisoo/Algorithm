import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] chessboard;
    static int black_start_min = 0;
    static int white_start_min = 0;

    public static char swap(char color) {
        if (color == 'W') return 'B';
        return 'W';
    }

    public static int count(int y, int x, char color) {
        int count = 0;

        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (color != chessboard[i][j]) {
                    count++;
                }
                color = swap(color);
            }
            color = swap(color);
        }
        return count;
    }

    public static void black_start_repaint(int y, int x) {
        if (y + 8 > N || x + 8 > M)
            return;

        char color = 'B';
        int count = count(y, x, color);

        if (y == 0 && x == 0) {
            black_start_min = count;
        } else {
            if (count < black_start_min) black_start_min = count;
        }
    }

    public static void white_start_repaint(int y, int x) {
        if (y + 8 > N || x + 8 > M)
            return;

        char color = 'W';
        int count = count(y, x, color);

        if (y == 0 && x == 0) {
            white_start_min = count;
        } else {
            if (count < white_start_min) white_start_min = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chessboard = new char[N][M];
        String s;

        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                chessboard[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                white_start_repaint(i, j);
                black_start_repaint(i, j);
            }
        }

        System.out.print(Math.min(white_start_min, black_start_min));
    }
}