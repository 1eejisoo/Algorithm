import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> students = new ArrayList<>();

        for (int i = 0; i < 28; i++) {
            students.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 1; i <= 30; i++) {
            if (!students.contains(i))
                sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}