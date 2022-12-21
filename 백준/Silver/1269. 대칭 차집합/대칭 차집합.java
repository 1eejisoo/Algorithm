import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        int size_A = Integer.parseInt(st.nextToken());
        int size_B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size_A; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        HashSet<Integer> A_minus_B = new HashSet<>(A);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size_B; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }
        HashSet<Integer> B_minus_A = new HashSet<>(B);

        A_minus_B.removeAll(B);
        B_minus_A.removeAll(A);

        System.out.print(A_minus_B.size() + B_minus_A.size());
    }
}