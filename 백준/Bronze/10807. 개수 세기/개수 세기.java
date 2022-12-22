import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> frequency = new HashMap<>();
        int n;

        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(st.nextToken());
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }

        int v = Integer.parseInt(br.readLine());

        if (frequency.containsKey(v))
            System.out.print(frequency.get(v));
        else System.out.print(0);
    }
}