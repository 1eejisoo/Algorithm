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
    static int area = 0;

    public static int bfs(int x, int y) {
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
                board[nx][ny] = board[x][y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
        return board[n - 1][m - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] a = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = a[j] - '0';
            }
        }
        
        System.out.println(bfs(0, 0));
    }
}