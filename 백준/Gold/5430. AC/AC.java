import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int t;
    static char[] funcP;
    static int n;
    static boolean isReverse = false;
    static Deque<Integer> deque = new LinkedList<>();
    static Deque<Integer> reverse_dq = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void switch_flag() {
        isReverse = !isReverse;
    }
    public static boolean AC(char[] cmd) {
        for (char c : cmd) {
            if (c == 'D') {
                if (deque.isEmpty()) {
                    return false;
                }
                if(isReverse) deque.pollLast();
                else deque.pollFirst();
                continue;
            }
            switch_flag();
        }
        return true;
    }

    public static void print() {
        if (isReverse) {
            sb.append("[");
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
                if (deque.size() > 0) sb.append(",");
            }
            sb.append("]").append("\n");
            return;
        }
        sb.append("[");
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
            if (deque.size() > 0) sb.append(",");
        }
        sb.append("]").append("\n");
    }

    public static String remove_bracket(String input) {
        input = input.replace("[", "");
        input = input.replace("]", "");
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            isReverse = false;
            deque.clear();
            funcP = br.readLine().toCharArray();
            n = Integer.parseInt(br.readLine());
            String[] numbers = remove_bracket(br.readLine()).split(",");

            for (String number : numbers) {
                if(number.equals("")) continue;
                deque.add(Integer.parseInt(number));
            }

            if (AC(funcP)) {
                print();
                continue;
            }
            sb.append("error").append("\n");
        }
        System.out.print(sb);
    }
}