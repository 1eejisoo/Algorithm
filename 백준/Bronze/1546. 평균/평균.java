import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        double max = 0, sum = 0;

        for (int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] > max) max = arr[i];
        }
        for (int i = 0; i < n ; i++) {
            sum += (arr[i]/max) * 100;
        }
        System.out.println(sum/(double)n);

    }
}