import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    static int t;
    static int m, n, k;
    static int count = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void bfs() {
        count++;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || board[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x, y;
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            board = new int[n][m];
            visited = new boolean[n][m];
            count = 0;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (board[j][l] == 1 && !visited[j][l]) {
                        q.offer(new Node(j, l));
                        visited[j][l] = true;
                        bfs();
                    }
                }
            }
            System.out.println(count);
        }
    }
}