import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void func(int a, int b, int n) {
        count++;
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        func(a, 6 - a - b, n - 1);
        sb.append(a).append(" ").append(b).append("\n");
        func(6 - a - b, b, n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        func(1, 3, n);
        System.out.println(count);
        System.out.print(sb);
    }
}