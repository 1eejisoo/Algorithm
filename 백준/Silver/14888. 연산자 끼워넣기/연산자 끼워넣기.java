import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> results = new ArrayList<>();

    public static int calc(char op, int left, int right) {
        if (op == '+') {
            return left + right;
        }
        if (op == '-') {
            return left - right;
        }
        if (op == '*') {
            return left * right;
        }
        if (op == '/') {
            return left / right;
        }
        return 0;
    }

    public static void permutation(int[] expression, char[] out, boolean[] visited, int depth, char[] have_op, int r) {
        if (depth == r) {
            int result = expression[0];

            for (int i = 0; i < out.length; i++) {
                result = calc(out[i], result, expression[i+1]);
            }
            results.add(result);
            return;
        }
        for (int i = 0; i < have_op.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = have_op[i];
                permutation(expression, out, visited, depth + 1, have_op, r);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        char[] op = {'+', '-', '*', '/'};      // 연산자 종류 
        int[] expression = new int[N];         // 수식
        char[] have_op = new char[N-1];        // 가지고 있는 연산지
        char[] out = new char[N-1];            // 연산자 순열을 저장할 배열
        boolean[] visited = new boolean[N-1];  // 중복으로 연산자를 뽑는 것을 방지하기 위한 방문 처리 배열
        int o, index = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            expression[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i <4; i++) {
            o = Integer.parseInt(st.nextToken());
            if (o == 0) continue;
            for (int j = 0; j < o; j++) {
                have_op[index++] = op[i];
            }
        }

        permutation(expression, out, visited,0, have_op, N-1);

        System.out.println(Collections.max(results));
        System.out.println(Collections.min(results));
    }
}