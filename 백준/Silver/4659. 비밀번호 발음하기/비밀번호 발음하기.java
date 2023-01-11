import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] input;
    static char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

    static boolean checkVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static boolean checkConsonants(char c) {
        for (char c1 : consonants) {
            if (c1 == c) {
                return true;
            }
        }
        return false;
    }

    static boolean conditionNumber1() {
        for (char c : input) {
            if (checkVowels(c)) return true;
        }
        return false;
    }

    static boolean conditionNumber2() {
        char start, mid, end;

        for (int i = 0; i < input.length - 2; i++) {
            start = input[i];
            mid = input[i + 1];
            end = input[i + 2];

            if (checkVowels(start)) {
                if (checkVowels(mid) && checkVowels(end)) return false;
            } else {
                if (checkConsonants(mid) && checkConsonants(end)) return false;
            }
        }
        return true;
    }

    static boolean conditionNumber3() {
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == input[i + 1] && input[i] != 'e' && input[i + 1] != 'e' && input[i] != 'o' && input[i + 1] != 'o') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input_str = br.readLine();

        while (!input_str.equals("end")) {
            sb.append("<").append(input_str).append("> is");
            input = input_str.toCharArray();

            if (!conditionNumber1() || !conditionNumber2() || !conditionNumber3())
                sb.append(" not");

            sb.append(" acceptable.").append("\n");
            input_str = br.readLine();
        }
        System.out.print(sb);
    }
}