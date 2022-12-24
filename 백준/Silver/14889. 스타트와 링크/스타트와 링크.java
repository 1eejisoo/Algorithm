import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] team;
    static int[][] S;
    static boolean[] visited;
    static int result = 0;
    static int recur_cnt = 0;

    public static void make_team() {
        int difference;
        int[] index = new int[2];
        int[] stats = new int[2];

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                team[0][index[0]++] = i;
                continue;
            }
            team[1][index[1]++] = i;
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                stats[0] += S[team[0][i]][team[0][j]];
                stats[1] += S[team[1][i]][team[1][j]];
            }
        }

        difference = Math.abs(stats[0] - stats[1]);

        if (recur_cnt == 0)
            result = difference;
        else result = Math.min(result, difference);

        recur_cnt++;
    }

    public static void combination(int start, int r) {
        if (r == 0) {
            make_team();
            return;
        }
        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(i + 1, r - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        team = new int[2][N/2];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, N / 2);

        System.out.print(result);
    }
}