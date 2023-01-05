import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int r, c;

    public static int func(int n, int r, int c) {

        if (n == 0) {
            return 0;
        }
        int half = 1 << (n - 1);
        //(r, c)가 1번 사각형일 때
        if (r < half && c < half) return func(n - 1, r, c);
        // (r, c)가 2번 사각형일 때
        if (r < half) return half * half + func(n - 1, r, c - half);
        // (r, c)가 3번 사각형일 때
        if (c < half) return 2 * half * half + func(n - 1, r - half, c);
        // (r, c)가 4번 사각형일 때
        return 3 * half * half + func(n - 1, r - half, c - half);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(func(n, r, c));
    }
}