import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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

    static Queue<Node> water_q = new LinkedList<>();
    static Queue<Node> hedgehog_q = new LinkedList<>();
    static int[][] water_time;
    static int[][] hedgehog_time;
    static int r, c;
    static int escape_x, escape_y;
    static int answer;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int bfs(Queue<Node> q, int[][] dist, boolean mode) {
        int x, y;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;

                if (mode && nx == escape_x && ny == escape_y)
                    return dist[x][y] + 1;

                if (mode && water_time[nx][ny] != -1 && dist[x][y] + 1 >= water_time[nx][ny]) continue;

                if (dist[nx][ny] >= 0) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
        return -1;
    }

    // 1. 불이 퍼지는 시간 구하기
    // 2. 고슴도치 이동 시간 구하기 (1과 비교)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        water_time = new int[r][c];
        hedgehog_time = new int[r][c];
        char[] input;

        for (int i = 0; i < r; i++) {
            input = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (input[j] == '.') {
                    water_time[i][j] = -1;
                    hedgehog_time[i][j] = -1;
                }
                if (input[j] == 'D') {
                    escape_x = i;
                    escape_y = j;
                }
                if (input[j] == 'S')
                    hedgehog_q.offer(new Node(i, j));
                if (input[j] == '*')
                    water_q.offer(new Node(i, j));
            }
        }
        bfs(water_q, water_time, false);
        answer = bfs(hedgehog_q, hedgehog_time, true);

        if (answer < 0) System.out.println("KAKTUS");
        else System.out.println(answer);
    }
}