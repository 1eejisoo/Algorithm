import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private final int x;
    private final int y;

    public Node(int x, int y) {
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

    static int n, k, l;
    static Queue<Node> q = new LinkedList<>();
    static int[][] board;
    static boolean[][] snake;
    static int[][] direction_info;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 우, 하, 좌, 상

    public static int move() {
        int time_idx = 0, idx = 0, time = 0;
        int nx = 0, ny = 0;
        int[] dir = direction[idx];   // 첫 방향은 오른쪽

        q.offer(new Node(0, 0));
        snake[0][0] = true;

        while (true) {
            time++;
            nx += dir[0];
            ny += dir[1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;  // 벽을 만나면 탈출
            if (snake[nx][ny]) break;  // 자기자신의 몸과 부딪히면 탈출

            if (time_idx < l && time == direction_info[time_idx][0]) {
                if (direction_info[time_idx][1] == -1)  // 왼쪽 90도 회전
                    dir = idx - 1 < 0 ? direction[idx = 3] : direction[--idx];
                if (direction_info[time_idx][1] == -2)  // 오른쪽 90도 회전
                    dir = idx + 1 > 3 ? direction[idx = 0] : direction[++idx];
                time_idx++;
            }
            snake[nx][ny] = true;
            q.offer(new Node(nx, ny));

            // 사과를 만나면 꼬리를 줄이지 않음
            if (board[nx][ny] == -1) {
                board[nx][ny] = 0;
                continue;
            }
            // 사과를 만나지 않으면 꼬리를 줄임
            if (!q.isEmpty()) {
                Node node = q.poll();
                snake[node.getX()][node.getY()] = false;
            }
        }
        return time;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        board = new int[n][n];
        snake = new boolean[n][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = -1;
        }

        l = Integer.parseInt(br.readLine());
        direction_info = new int[l][2];

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            String dir_str = st.nextToken();

            int dir = dir_str.equals("L") ? -1 : -2;  // L(왼쪽)이면 -1, D(오른쪽)이면 -2
            direction_info[i][0] = time;
            direction_info[i][1] = dir;
        }
        System.out.print(move());
    }
}