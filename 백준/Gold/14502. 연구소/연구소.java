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
}

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] newBoard;
    static boolean[][] visited;
    static int answer = 0;
    static List<Node> list = new ArrayList<>();
    static Queue<Node> q = new LinkedList<>();
    static boolean[] combVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs(int i, int j) {
        q.offer(new Node(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (newBoard[nx][ny] != 0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                newBoard[nx][ny] = 2;
                q.offer(new Node(nx, ny));
            }
        }
    }

    public static void setting() {
        q.clear();
        List<Node> selectList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (combVisited[i]) selectList.add(list.get(i));
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(board[i], 0, newBoard[i], 0, M);
        }

        for (Node node : selectList) {
            newBoard[node.x][node.y] = 1;  // 벽으로 설정
        }
    }

    public static void comb(int start, int depth) {
        if (depth == 3) {
            setting();

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (newBoard[i][j] == 2 && !visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (newBoard[i][j] == 0) count++;
                }
            }

            answer = Math.max(answer, count);
            return;
        }

        for (int i = start; i < list.size(); i++) {
            if (combVisited[i]) continue;
            combVisited[i] = true;
            comb(i + 1, depth + 1);
            combVisited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        newBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) list.add(new Node(i, j));
            }
        }

        combVisited = new boolean[list.size()];
        comb(0, 0);

        System.out.println(answer);
    }
}