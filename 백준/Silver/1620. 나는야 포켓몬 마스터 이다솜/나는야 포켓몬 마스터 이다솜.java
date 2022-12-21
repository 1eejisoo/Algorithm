import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, String> names = new HashMap<>();
        HashMap<String, Integer> numbers = new HashMap<>();
        String input;
        String regExp = "^\\d+$";
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int  i = 1; i <= N; i++) {
            input = br.readLine();
            names.put(i, input);
            numbers.put(input, i);
        }
        for (int i = 0; i < M; i++) {
            input = br.readLine();
            if (input.matches(regExp)) {
                sb.append(names.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(numbers.get(input)).append("\n");
            }
        }

        System.out.print(sb);
    }
}