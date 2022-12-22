import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine()); 
        StringTokenizer st;
        int[] arr;

        while(c > 0) {
            int sum = 0, cnt = 0;
            
            st = new StringTokenizer(br.readLine(), " ");  
            int n = Integer.parseInt(st.nextToken());   
            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            for (int i = 0; i<n; i++) if ((double)arr[i] > (double)sum/n) cnt++;

            String result = String.format("%.3f", ((double)cnt/n) * 100);
            System.out.println(result + "%");

            c--;
        }
    }
}