import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str_N = br.readLine();
        int N_len = str_N.length();
        int N = Integer.parseInt(str_N);
        int result = 0;
        
        for (int i = (N - (N_len) * 9); i < N; i++) {
            int number = i;
            int sum = 0;
            
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            
            if (sum + i == N) {
                result = i;
                break;
            }
        }
        
        System.out.println(result);
    }
}