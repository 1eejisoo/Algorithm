import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private final int x;
    private final int y;


    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    static int n, m;
    static int[][] board;
    static int[][] dist;
    static int answer;
    // 하, 우, 상, 좌,  대각선 왼쪽 위, 대각선 오른쪽 위, 대각선 왼쪽 밑, 대각선 오른쪽 밑
    static int[] dx = {1, 0, -1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};

    public static int bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        dist = new int[n][m];
        q.offer(new Node(i, j));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            for (int dir = 0; dir < 8; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if ((nx == x && ny == y) || dist[nx][ny] != 0) continue;

                dist[nx][ny] = dist[x][y] + 1;
                if (board[nx][ny] == 1) {
                    return dist[nx][ny];
                }
                q.offer(new Node(nx, ny));
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    answer = Math.max(bfs(i, j), answer);
                }
            }
        }

        System.out.println(answer);
    }
}