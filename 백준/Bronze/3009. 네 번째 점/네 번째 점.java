import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> X = new HashMap<>();
        Map<Integer, Integer> Y = new HashMap<>();
        int x, y;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            X.put(x, X.getOrDefault(x, 0) + 1);
            Y.put(y, Y.getOrDefault(y, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: X.entrySet()) {
            if (entry.getValue() == 1) {
                sb.append(entry.getKey()).append(" ");
                break;
            }
        }

        for (Map.Entry<Integer, Integer> entry : Y.entrySet()) {
            if (entry.getValue() == 1) {
                sb.append(entry.getKey());
                break;
            }
        }

        System.out.print(sb);
    }
}