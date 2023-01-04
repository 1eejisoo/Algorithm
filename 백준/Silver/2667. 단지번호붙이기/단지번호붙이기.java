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
    static List<Integer> house = new ArrayList<>();
    static int[][] board;
    static boolean[][] visited;
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count;

    public static void bfs(int x, int y) {
        int size = 0;
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                if (visited[nx][ny] || board[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
            size++;
        }
        house.add(size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];
        char[] c;

        for (int i = 0; i < n; i++) {
            c = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = c[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0;j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        Collections.sort(house);
        System.out.println(count);
        for (int x : house)
            System.out.println(x);
    }
}