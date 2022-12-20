import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] array = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            array[i] = Integer.parseInt(br.readLine());
            sum += array[i];
        }

        Arrays.sort(array);

        System.out.println(sb.append(sum / 5).append("\n").append(array[2]));
    }
}