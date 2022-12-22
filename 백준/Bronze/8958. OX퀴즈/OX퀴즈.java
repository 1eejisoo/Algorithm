import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0, sum = 0;
        String str = "";

        while(n > 0) {
            str = sc.next();
            for (int i = 0; i < str.length() ; i++) {
                if (str.charAt(i) == 'O') {
                    cnt++;
                }
                else if (str.charAt(i) == 'X') {
                   for (int j = 1; j <= cnt; j++) sum += j;
                   cnt = 0;
                }
            }
            for (int j = 1; j <= cnt; j++) sum += j;

            System.out.println(sum);
            sum = 0; cnt = 0;
            n--;
        }

    }
}