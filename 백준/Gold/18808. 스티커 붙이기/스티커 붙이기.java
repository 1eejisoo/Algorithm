import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static int r, c;
    static int[][] notebook;
    static int[][] sticker;
    static int answer = 0;

    /**
     * r, c 교체 함수
     */
    static void swap() {
        int tmp = r;
        r = c;
        c = tmp;
    }


    /**
     * 2차원 배열 회전 함수
     * @return sticker
     */
    static int[][] rotate() {
        swap();
        int[][] temp = new int[r][c];

        for (int j = 0; j < r; j++) {
            for (int k = 0; k < c; k++) {
                temp[j][k] = sticker[c - 1 - k][j];
            }
        }
        return temp;
    }

    /**
     * 노트북에 붙일 수 있는지 판단하고, 붙일 수 있다면 붙이는 함수
     */
    static boolean isPastable(int x, int y) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (notebook[x + i][y + j] == 1 && sticker[i][j] == 1)
                    return false;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] == 1)
                    notebook[x + i][y + j] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        notebook = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            sticker = new int[r][c];

            // 스티커 입력 받기
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < c; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 각 스티커를 회전하면서 붙일 수 있는지 판단
            for (int rot = 0; rot < 4; rot++) {
                boolean is_paste = false;
                for (int x = 0; x <= n - r; x++) {
                    if (is_paste) break;
                    for (int y = 0; y <= m - c; y++) {
                        if (isPastable(x, y)) {
                            is_paste = true;
                            break;
                        }
                    }
                }
                if (is_paste) break;
                sticker = rotate();
            }
        }

        // 붙여진 스티커의 개수 세기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer += notebook[i][j];
            }
        }
        System.out.println(answer);
    }
}