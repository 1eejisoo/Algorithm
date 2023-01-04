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

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}

public class Main {

    static Queue<Node> q = new LinkedList<>();
    static int[][] board;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static int max = 0;

    public static void bfs(int x, int y) {
        int area = 0;

        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            area++;

            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (visited[nx][ny] || board[nx][ny] == 0)
                    continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
        max = Math.max(area, max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || board[i][j] == 0)
                    continue;
                bfs(i, j);
                count++;
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}