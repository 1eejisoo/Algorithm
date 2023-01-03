import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ascending = "1 2 3 4 5 6 7 8";
        String descending = "8 7 6 5 4 3 2 1";

        String s = br.readLine();

        if (s.equals(ascending))
            System.out.print("ascending");
        else if (s.equals(descending))
            System.out.print("descending");
        else
            System.out.print("mixed");
    }
}