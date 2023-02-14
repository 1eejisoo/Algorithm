import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int max_height = 0;
    static int result = 1;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs(Queue<Node> q, boolean[][] visited, int height) {
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (board[nx][ny] <= height || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
    }

    public static int solution(int height) {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > height && !visited[i][j]) {
                    q.offer(new Node(i, j));
                    visited[i][j] = true;
                    bfs(q, visited, height);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max_height = Math.max(board[i][j], max_height);
            }
        }

        for (int i = 0; i <= max_height; i++) {
            result = Math.max(result, solution(i));
        }

        System.out.println(result);
    }
}