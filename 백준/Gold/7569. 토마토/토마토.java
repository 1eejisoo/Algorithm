import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private final int x;
    private final int y;
    private final int z;

    Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getZ() {
        return z;
    }
}

public class Main {

    static Queue<Node> q = new LinkedList<>();
    static int[][][] dist;
    static int m, n, h;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int answer = -1;

    public static void bfs() {
        int x, y, z;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            z = node.getZ();

            for (int dir = 0; dir < 6; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int nz = z + dz[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;
                if (dist[nz][nx][ny] >= 0) continue;

                dist[nz][nx][ny] = dist[z][x][y] + 1;
                q.offer(new Node(nx, ny, nz));
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        dist = new int[h][n][m];
        int input;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    input = Integer.parseInt(st.nextToken());
                    if (input == 0)
                        dist[i][j][k] = -1;
                    if (input == 1) {
                        q.offer(new Node(j, k, i));
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (dist[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, dist[i][j][k]);
                }
            }
        }
        System.out.println(answer);
    }
}