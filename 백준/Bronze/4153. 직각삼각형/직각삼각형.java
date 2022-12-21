import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] sides = new int[3];

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            sides[0] = Integer.parseInt(st.nextToken());
            sides[1] = Integer.parseInt(st.nextToken());
            sides[2] = Integer.parseInt(st.nextToken());

            if (sides[0] == 0)
                break;

            Arrays.sort(sides);

            if ((sides[0] * sides[0] + sides[1] * sides[1]) == sides[2] * sides[2]) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }

        System.out.print(sb);
    }
}