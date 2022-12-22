import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] paper;
        int[][] coordinate = new int[N][2];
        int size = 100 * N;
        int x, y, max_X = 0, max_Y = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            coordinate[i][0] = Integer.parseInt(st.nextToken());
            coordinate[i][1] = Integer.parseInt(st.nextToken());
            max_X = Math.max(max_X, coordinate[i][1]);
            max_Y = Math.max(max_Y, coordinate[i][0]);
        }

        paper = new int[max_X + 10][max_Y + 10];

        for (int i = 0; i < N; i++) {
            x = coordinate[i][1];
            y = coordinate[i][0];
            for (int j = x; j < 10 + x; j++) {
                for (int k = y; k < 10 + y; k++) {
                    paper[j][k]++;
                }
            }
        }

        for (int[] arr : paper) {
            for (int j = 0; j < paper[0].length; j++) {
                if (arr[j] > 1) size -= arr[j] - 1;
            }
        }

        System.out.print(size);
    }
}