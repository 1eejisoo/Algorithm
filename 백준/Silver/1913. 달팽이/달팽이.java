import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, find, find_x, find_y;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        find = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int dir = 0;
        int nx = 0, ny = 0;
        int number = N * N;
        board[nx][ny] = number--;

        while (number > 0) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] > 0) {
                nx -= dx[dir];
                ny -= dy[dir];
                dir = (dir + 1) % 4;
                continue;
            }
            board[nx][ny] = number--;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == find) {
                    find_x = i + 1;
                    find_y = j + 1;
                }
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(find_x).append(" ").append(find_y);
        System.out.print(sb);
    }
}