import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        HashSet<String> hashSet = new HashSet<>();
        List<String> results = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String name;

        for (int i = 0; i < N; i++)
            hashSet.add(br.readLine());

        for (int i = 0; i < M; i++) {
            name = br.readLine();
            if (hashSet.contains(name)) {
                results.add(name);
            }
        }

        sb.append(results.size()).append("\n");

        Collections.sort(results);
        
        for (String result : results) {
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}