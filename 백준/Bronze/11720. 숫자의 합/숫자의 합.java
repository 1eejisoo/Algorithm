import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());   
        String str = br.readLine();   
        int sum = 0;

        for (int i=0; i<str.length(); i++) {
            String[] strArr = str.split("");
            sum += Integer.parseInt(strArr[i]);
        }

        System.out.println(sum);
    }
}