import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] lc = new int[27];
    static int[] rc = new int[27];

    static void preorder(int cur) {
        System.out.print((char) (cur + 'A' - 1));
        if (lc[cur] != 0) preorder(lc[cur]);
        if (rc[cur] != 0) preorder(rc[cur]);
    }

    static void inorder(int cur) {
        if (lc[cur] != 0) inorder(lc[cur]);
        System.out.print((char) (cur + 'A' - 1));
        if (rc[cur] != 0) inorder(rc[cur]);
    }

    static void postorder(int cur) {
        if (lc[cur] != 0) postorder(lc[cur]);
        if (rc[cur] != 0) postorder(rc[cur]);
        System.out.print((char) (cur + 'A' - 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            if (input[2] != '.') lc[input[0] - 'A' + 1] = input[2] - 'A' + 1;
            if (input[4] != '.') rc[input[0] - 'A' + 1] = input[4] - 'A' + 1;
        }
        preorder(1);
        System.out.println();
        inorder(1);
        System.out.println();
        postorder(1);
    }
}