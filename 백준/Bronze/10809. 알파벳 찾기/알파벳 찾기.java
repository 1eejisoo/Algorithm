import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        for (int i=0; i < alpha.length(); i++){
            int num = s.indexOf(alpha.charAt(i));
            if ( num >= 0)  System.out.print(num + " ");
            else System.out.print(-1 + " ");
        }
    }
}
