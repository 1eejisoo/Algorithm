import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;
    int virus;
    int time;

    Node(int x, int y, int virus, int time) {
        this.x = x;
        this.y = y;
        this.virus = virus;
        this.time = time;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getVirus() {
        return virus;
    }

    int getTime() {
        return time;
    }
}

public class Main {
    static int n, k;
    static int s, x, y;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Node> virus_list = new ArrayList<>();
    static Queue<Node> q = new LinkedList<>();

    public static void bfs() {
        int x, y, virus, time;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            virus = node.getVirus();
            time = node.getTime();

            if (time == s) return;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] != 0) continue;

                board[nx][ny] = virus;
                q.offer(new Node(nx, ny, virus, time + 1));
            }
        }
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
                    virus_list.add(new Node(i, j, board[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;

        virus_list.sort(Comparator.comparingInt(Node::getVirus));
        q.addAll(virus_list);
        bfs();

        System.out.println(board[x][y]);
    }
}