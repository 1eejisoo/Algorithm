import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;

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
    static int n, k;
    static int s, x, y;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static HashMap<Integer, Queue<Node>> map = new HashMap<>();

    public static void bfs(Queue<Node> q, int number) {
        int x, y;
        List<Node> offer_list = new ArrayList<>();

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] != 0) continue;

                board[nx][ny] = number;
                offer_list.add(new Node(nx, ny));
            }
        }
        for (Node node : offer_list)
            q.offer(node);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0) {
                    if (!map.containsKey(board[i][j])) {
                        map.put(board[i][j], new LinkedList<>());
                    }
                    map.get(board[i][j]).offer(new Node(i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < s; i++) {
            for (int j = 1; j <= k; j++) {
                if (map.get(j) == null) continue;
                bfs(map.get(j), j);
            }
        }

        if (board[x][y] == 0) System.out.println(0);
        else System.out.println(board[x][y]);
    }
}