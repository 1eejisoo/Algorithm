import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] croatia = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String threeLetters = "dz=";
        String blank = "#";
        int count = 0;

        if (input.contains(threeLetters)) {
            count += (input.length() - input.replace(threeLetters, "").length()) / threeLetters.length();
            input = input.replace(threeLetters, blank);
        }

        String remove = input;

        for (String c : croatia) {
            if (input.contains(c)) {
                count += (input.length() - input.replace(c, "").length()) / c.length();
                remove = remove.replace(c, blank);
            }
        }

        count += remove.replace(blank, "").length();

        System.out.println(count);
    }
}