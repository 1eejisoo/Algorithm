import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int answer = 99;
    static List<Integer> dist_list = new ArrayList<>();

    public static boolean check(int n) {
        dist_list.clear();
        int target = n;

        while(target != 0) {
            dist_list.add(target % 10);
            target /= 10;
        }

        int diff = dist_list.get(1) - dist_list.get(0);
        for (int i = 2; i < dist_list.size(); i++) {
            int cur = dist_list.get(i) - dist_list.get(i - 1);
            if (diff != cur) return false;
            diff = cur;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N < 100) {
            System.out.println(N);
            return;
        }

        for (int i = 100; i <= N; i++) {
            if (check(i)) answer++;
        }

        System.out.println(answer);
    }
}