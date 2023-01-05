import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    private final int x;
    private final int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}

public class Main {

    static Queue<Node> q = new LinkedList<>();
    static char[][] board;
    static boolean[][] visited1;    // 적록색약이 아닌 사람
    static boolean[][] visited2;    // 적록색약인 사람
    static int n;
    static int count1 = 0;
    static int count2 = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char color;
    static int x, y;

    public static void bfs_no() {
        count1++;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            color = board[x][y];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited1[nx][ny] || board[nx][ny] != color) continue;
                visited1[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
    }

    public static void bfs_yes() {
        count2++;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            color = board[x][y];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited2[nx][ny]) continue;

                if (color == 'R' || color == 'G') {
                    if (board[nx][ny] != 'R' && board[nx][ny] != 'G') continue;
                } else {
                    if (board[nx][ny] != color) continue;
                }

                visited2[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited1[i][j]) {
                    q.offer(new Node(i, j));
                    visited1[i][j] = true;
                    bfs_no();
                }
                if (!visited2[i][j]) {
                    q.offer(new Node(i, j));
                    visited2[i][j] = true;
                    bfs_yes();
                }
            }
        }
        System.out.print(count1 + " " + count2);
    }
}