import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");  
        int cnt = s.length;

        for (int i = 0; i < s.length; i++) {
            if (s[i].isEmpty()) cnt -= 1;
        }

        System.out.println(cnt);
    }
}
