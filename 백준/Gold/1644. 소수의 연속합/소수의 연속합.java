import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n;
    static int answer = 0;
    static List<Boolean> primeList;
    static int[] primeArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        primeList = new ArrayList<>(n + 1);

        primeList.add(false);
        primeList.add(false);

        for (int i = 2; i <= n; i++) {
            primeList.add(i, true);
        }

        for (int i = 2; (i * i) <= n; i++) {
            if (primeList.get(i)) {
                for (int j = i * i; j <= n; j += i) primeList.set(j, false);
            }
        }
        int size = 0;
        for (int i = 0; i <= n; i++) {
            if (primeList.get(i)) {
                size++;
            }
        }

        int idx = 0;
        primeArr = new int[size + 1];
        for (int i = 0; i <= n; i++) {
            if (primeList.get(i)) {
                primeArr[idx++] = i;
            }
        }

        int st = 0, en = 0, sum = primeArr[0];
        while (st <= en && en <= size - 1) {
            if (sum < n) {
                en++;
                sum += primeArr[en];
            } else {
                if (sum == n) {
                    answer++;
                }
                sum -= primeArr[st];
                st++;
            }
        }
        System.out.println(answer);
    }
}