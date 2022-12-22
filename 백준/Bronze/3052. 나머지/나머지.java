import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[10];
        List<Integer> remainder = new ArrayList<>();
        int cnt = 10;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
            if (remainder.contains(arr[i] % 42)) cnt--;
            else remainder.add(arr[i] % 42);
        }
        System.out.println(cnt);
    }
}