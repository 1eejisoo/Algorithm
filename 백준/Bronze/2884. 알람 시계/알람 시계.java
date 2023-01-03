import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int original_time = h * 60 + m;
        int change_time = original_time - 45;

        if (change_time < 0) {
            h = 23;
            m = 60 + change_time;
        } else {
            h = change_time / 60;
            m = change_time % 60;
        }
        sb.append(h).append(" ").append(m);
        System.out.print(sb);
    }
}