import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());    // 가지고 있는 카드의 개수
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        // 상근이가 가지고 있는 숫자 카드에 적혀있는 정수 저장
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());    // 가지고 있는 숫자 카드인지 아닌지 구해야 할 개수

        st = new StringTokenizer(br.readLine(), " ");
        // 상근이가 가지고 있는 숫자 카드인지 아닌지 구해야 할 정수 저장
        for (int i = 0; i < M; i++) {
            result.put(Integer.parseInt(st.nextToken()), 0);
        }

        // result의 키 값으로 존재하면 1
        for (int i = 0; i < N; i++) {
            if (result.containsKey(cards[i])) {
                result.put(cards[i], 1);
            }
        }

        for (Integer value : result.values()) {
            sb.append(value).append(" ");
        }
        System.out.println(sb);
    }
}