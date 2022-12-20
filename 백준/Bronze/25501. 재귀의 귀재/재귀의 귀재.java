import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;
    
    public static int recursion(char[] s, int l, int r) {
        count++;
        if (l >= r) return 1;
        else if (s[l] != s[r]) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    public static int isPalindrome(char[] s) {
        return recursion(s, 0, s.length - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            count = 0;
            sb.append(isPalindrome(br.readLine().toCharArray())).append(" ").append(count).append("\n");
        }
        
        System.out.println(sb);
    }
}