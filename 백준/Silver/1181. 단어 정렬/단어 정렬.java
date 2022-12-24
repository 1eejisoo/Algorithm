import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashSet<String> words = new HashSet<>();

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        words.stream().sorted((o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);
            return o1.length() - o2.length();
        }).forEach(s -> sb.append(s).append("\n"));
        
        System.out.print(sb);
    }
}