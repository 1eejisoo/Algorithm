import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        String S = br.readLine();
        int size = S.length();

        for (int i = 0; i < S.length(); i++) {
            set.add(String.valueOf(S.charAt(i)));
            for (int j = i + 2; j < size + 1; j++) {
                set.add(S.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}