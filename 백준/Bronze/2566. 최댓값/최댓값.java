import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] array = new int[9][9];
        int[] location = new int[2];
        int max = -1;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if (max < array[i][j]) {
                    max = array[i][j];
                    location[0] = i + 1;
                    location[1] = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.print(location[0] + " " + location[1]);
    }
}