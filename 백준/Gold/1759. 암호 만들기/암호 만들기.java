import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] alphabet;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static final HashSet<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static boolean isCorrect() {
        int v_cnt = 0, c_cnt = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (!visited[i]) continue;
            if (vowel.contains(alphabet[i])) v_cnt++;
            else c_cnt++;
        }
        return v_cnt >= 1 && c_cnt >= 2;
    }

    public static void comb(int start, int r) {
        if (r == 0) {
            if (!isCorrect()) return;
            for (int i = 0; i < C; i++) {
                if (visited[i]) sb.append(alphabet[i]);
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < C; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            comb(i + 1, r - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabet = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);
        comb(0, L);
        System.out.print(sb);
    }
}