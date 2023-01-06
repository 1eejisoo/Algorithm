import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
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
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> q = new LinkedList<>();
    static int answer, count, max = 0;

    public static Node findIrregular() {
        Node node = new Node(-1, -1);

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (i + 1 >= 12) continue;
                if (board[i][j] != '.' && board[i + 1][j] == '.') {
                    node.setX(i);
                    node.setY(j);
                    return node;
                }
            }
        }
        return node;
    }

    public static void replace() {
        char color;
        Node node = findIrregular();

        while (node.getX() != -1 || node.getY() != -1) {
            color = board[node.getX()][node.getY()];
            board[node.getX() + 1][node.y] = color;
            board[node.getX()][node.getY()] = '.';
            node = findIrregular();
        }
    }

    public static void bfs(Queue<Node> q, char color) {
        if (q.isEmpty()) return;
        int x, y;
        List<Node> bomb_list = new ArrayList<>();
        count = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            visited[x][y] = true;

            bomb_list.add(new Node(x, y));

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                if (board[nx][ny] != color || visited[nx][ny]) continue;

                q.offer(new Node(nx, ny));

                visited[nx][ny] = true;

                bomb_list.add(new Node(nx, ny));
                count++;
            }
        }
        if (count >= 4) {
            for (Node node : bomb_list) {
                board[node.getX()][node.getY()] = '.';
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[12][6];
        visited = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            board[i] = br.readLine().toCharArray();
        }

        while (true) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (board[i][j] != '.' && !visited[i][j]) {
                        q.offer(new Node(i, j));
                        bfs(q, board[i][j]);
                        max = Math.max(max, count);
                    }
                }
            }
            if (max < 4) break;
            max = 0;
            answer++;
            replace();
            visited = new boolean[12][6];
        }

        System.out.println(answer);
    }
}