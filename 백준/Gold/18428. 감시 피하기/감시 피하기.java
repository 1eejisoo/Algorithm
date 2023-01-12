import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// S: 학생
// T: 선생님
// O: 장애물
// X: Nothing
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

    static int n;
    static int available_count = 0;
    static char[][] board;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static boolean bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] == 'S') return false;
                if (board[nx][ny] == 'O') continue;


                if (dir == 0) { // 우
                    for (int i = nx + 1; i < n; i++) {
                        if (board[i][ny] == 'O' || board[i - 1][ny] == 'O' || board[i - 1][ny] == 'S') continue;
                        if (board[i][ny] == 'S') {
                            if (available_count < 3) {
                                board[i - 1][ny] = 'O';
                                available_count++;
                            } else return false;
                        }
                    }
                } else if (dir == 1) {  // 하
                    for (int i = ny + 1; i < n; i++) {
                        if (board[nx][i] == 'O' || board[nx][i -1] == 'O' || board[nx][i -1] == 'S') continue;
                        if (board[nx][i] == 'S') {
                            if (available_count < 3) {
                                board[nx][i - 1] = 'O';
                                available_count++;
                            } else return false;
                        }
                    }
                } else if (dir == 2) {   // 좌
                    for (int i = nx - 1; i >= 0; i--) {
                        if (board[i][ny] == 'O' || board[i + 1][ny] == 'O' || board[i + 1][ny] == 'S') continue;
                        if (board[i][ny] == 'S') {
                            if (available_count < 3) {
                                board[i + 1][ny] = 'O';
                                available_count++;
                            } else return false;
                        }
                    }
                } else {   // 상
                    for (int i = ny - 1; i >= 0; i--) {
                        if (board[nx][i] == 'O' || board[nx][i + 1] == 'O' ||  board[nx][i + 1] == 'S') continue;
                        if (board[nx][i] == 'S') {
                            if (available_count < 3) {
                                board[nx][i + 1] = 'O';
                                available_count++;
                            } else return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = st.nextToken().charAt(0);
                if (board[i][j] == 'T') q.offer(new Node(i, j));
            }
        }

        if (!bfs()) System.out.println("NO");
        else System.out.println("YES");
    }
}