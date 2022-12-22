import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int cnt = 0;
    static boolean[] isused1;    // 행을 차지하고 있는지
    static boolean[] isused2;    // / 방향 대각선을 차지하고 있는지
    static boolean[] isused3;    // \ 방향 대각선을 차지하고 있는지

    public static void nQueen(int cur) {    // cur번째 행에 말을 배치할 예정
        if (cur == n) {  // n개를 놓는데 성공했다면
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {      // (cur, i)에 퀸을 놓을 예정
            if (isused1[i] || isused2[cur + i] || isused3[cur - i + n - 1])  // 조건에 어긋나 퀸을 놓을 수 없는 경우
                continue;
            isused1[i] = true;
            isused2[cur + i] = true;
            isused3[cur - i + n - 1] = true;
            nQueen(cur + 1);
            isused1[i] = false;
            isused2[cur + i] = false;
            isused3[cur - i + n - 1] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isused1 = new boolean[n];
        isused2 = new boolean[40];
        isused3 = new boolean[40];

        nQueen(0);
        System.out.print(cnt);
    }
}