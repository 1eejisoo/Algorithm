import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] input;
    static Integer[] arr;
    static TreeSet<Integer> set = new TreeSet<>();

    public static int binary_search(int target) {
        int st = 0;
        int en = arr.length;

        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] < target) st = mid + 1;
            else if (arr[mid] > target) en = mid - 1;
            else return mid;
        }
        return st;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            set.add(input[i]);
        }

        arr = new Integer[set.size()];
        int idx = 0;
        for (Integer integer : set) {
            arr[idx++] = integer;
        }

        for (int i = 0; i < n; i++) {
            sb.append(binary_search(input[i])).append(" ");
        }
        System.out.println(sb);
    }
}