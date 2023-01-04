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

    static Queue<Node> person = new LinkedList<>();
    static Queue<Node> fire = new LinkedList<>();
    static char[][] input;
    static int[][] fire_time;
    static int[][] escape_time;
    static int r, c;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;

    public static int bfs(Queue<Node> q, int[][] time, boolean bfs_mode) {

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 범위를 벗어난 경우
                if (nx < 0 || nx >= c || ny < 0 || ny >= r) {
                    // 불 bfs면 continue
                    if (!bfs_mode) continue;
                    // 지훈 bfs면 탈출 성공 -> 반환
                    else return time[x][y] + 1;
                }

                if (time[nx][ny] >= 0)
                    continue;

                if (bfs_mode && time[x][y] + 1 >= fire_time[nx][ny] && fire_time[nx][ny] != -1)
                    continue;

                time[nx][ny] = time[x][y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        input = new char[c][r];
        fire_time = new int[c][r];
        escape_time = new int[c][r];

        for (int i = 0; i < c; i++) {
            input[i] = br.readLine().toCharArray();
            for (int j = 0; j < r; j++) {
                if (input[i][j] == 'J') {
                    person.offer(new Node(i, j));
                    fire_time[i][j] = -1;
                }
                if (input[i][j] == 'F') {
                    fire.offer((new Node(i, j)));
                }

                if (input[i][j] == '.') {
                    fire_time[i][j] = -1;
                    escape_time[i][j] = -1;
                }
            }
        }

        bfs(fire, fire_time, false);
        answer = bfs(person, escape_time, true);

        if (answer > 0)
            System.out.println(answer);
        else System.out.println("IMPOSSIBLE");
    }
}