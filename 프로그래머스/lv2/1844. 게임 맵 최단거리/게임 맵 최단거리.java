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

class Solution {

    static int n, m;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> q = new LinkedList<>();

    static int bfs(int[][] maps) {
        dist[0][0] = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist[nx][ny] != -1 || maps[nx][ny] == 0) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new Node(nx, ny));

                if (nx == n - 1 && ny == m - 1) return dist[nx][ny] + 1;
            }
        }
        return -1;
    }

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }
        q.offer(new Node(0, 0));
        return bfs(maps);
    }
}