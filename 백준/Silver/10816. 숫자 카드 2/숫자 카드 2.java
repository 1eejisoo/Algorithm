import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<Integer, Integer> cards = new LinkedHashMap<>();
        int N = Integer.parseInt(br.readLine());
        int key;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            key = Integer.parseInt(st.nextToken());
            cards.put(key, cards.getOrDefault(key, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            sb.append(cards.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
        }

        System.out.println(sb);
    }
}