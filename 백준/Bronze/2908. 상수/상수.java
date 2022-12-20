import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        List<Integer> numbers = new ArrayList<>();

        while(st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString()));
        }

        System.out.println(Collections.max(numbers));
    }
}