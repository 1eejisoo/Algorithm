import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

    static int n, m;
    static int answer = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board1 = new int[10][10];    // 입력으로 주어지는 사무실의 모양을 저장할 변수
    static int[][] board2 = new int[10][10];    // cctv의 방향을 정한 후에 cctv의 감시 영역에 걸리는 칸을 표시할 변
    static List<Node> cctv = new ArrayList<>();

    // (a, b)가 범위를 벗어났는지 체크하는 함수 (Out Of Bounds)
    static boolean OOB(int a, int b) {
        return a < 0 || a >= n || b < 0 || b >= m;
    }

    // (x, y)에서 dir 방향으로 진행하면서 벽을 만날 때까지 지나치는 모든 빈칸을 7로 바꿈
    static void upd(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            // 범위를 벗어났거나 벽을 만나면 함수 탈출
            if (OOB(x, y) || board2[x][y] == 6) return;
            // 해당 칸이 빈칸이 아닐 경우 (= cctv가 이미 있을 경우) 넘어감
            if (board2[x][y] != 0) continue;
            board2[x][y] = 7;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());
                if (board1[i][j] != 0 && board1[i][j] != 6)
                    cctv.add(new Node(i, j));
                if (board1[i][j] == 0) answer++;
            }
        }

        // tmp를 4진법으로 나눴을 때 각 자리수를 cctv의 방향으로 생각한다.
        // 1 << (2*cctv.size())는 4의 cctv.size() 승을 의미한다.
        // cf) 1 << 3은 2^3
        for (int tmp = 0; tmp < (1 << (2 * cctv.size())); tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board2[i][j] = board1[i][j];
                }
            }

            int brute = tmp;

            for (Node node : cctv) {
                int dir = brute % 4;    // 자릿수(방향) 추출
                brute /= 4;
                int x = node.getX();
                int y = node.getY();

                if (board1[x][y] == 1) {
                    upd(x, y, dir);
                } else if (board1[x][y] == 2) {
                    upd(x, y, dir);
                    upd(x, y, dir + 2);
                } else if (board1[x][y] == 3) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                } else if (board1[x][y] == 4) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                } else {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                    upd(x, y, dir + 3);
                }
            }
            int val = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board2[i][j] == 0) val++;
                }
            }
            answer = Math.min(answer, val);
        }
        System.out.println(answer);
    }
}