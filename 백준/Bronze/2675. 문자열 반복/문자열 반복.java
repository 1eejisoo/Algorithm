import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int r = 0;
        String s = "";

        while (testcase > 0) {
            st = new StringTokenizer(br.readLine(), " ");   
            r = Integer.parseInt(st.nextToken());   
            s = st.nextToken();   

            for (int i = 0; i < s.length(); i++)
                sb.append(String.valueOf(s.charAt(i)).repeat(r));

            System.out.println(sb);
            sb.delete(0, sb.length());
            testcase--;
        }

    }
}
