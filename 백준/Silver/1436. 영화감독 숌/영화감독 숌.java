import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] endNumberArr;

    public static boolean isEndNumber(int x) {
        return String.valueOf(x).contains("666");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        endNumberArr = new int[n + 1];

        int idx = 1;
        for (int i = 666; true; i++) {
            if (idx == n + 1) break;
            if (isEndNumber(i)) endNumberArr[idx++] = i;
        }
        System.out.println(endNumberArr[n]);
    }
}