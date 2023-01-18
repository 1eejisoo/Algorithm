import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static int findNotSelfNumber(int num) {
        int nxt = num;
        while(num != 0) {
            nxt += num % 10;
            num /= 10;
        }
        return nxt;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<Integer> not_self_numbers = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            not_self_numbers.add(findNotSelfNumber(i));
        }

        Collections.sort(not_self_numbers);

        for (int i = 1; i <= 10000; i++) {
            if (not_self_numbers.contains(i)) continue;
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}