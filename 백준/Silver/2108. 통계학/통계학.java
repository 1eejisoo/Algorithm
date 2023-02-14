import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            sum += arr[i];
        }
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((v1,v2) -> (map.get(v2).compareTo(map.get(v1))));


        List<Integer> freq_num_list = new ArrayList<>();
        freq_num_list.add(list.get(0));
        int freq = map.get(list.get(0));
        int freq_num = list.get(0);

        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                if (freq == map.get(list.get(i))) {
                    freq_num_list.add(list.get(i));
                }
            }
        }
        Collections.sort(freq_num_list);
        if (freq_num_list.size() > 1) freq_num = freq_num_list.get(1);

        double avg = (double)sum / N;
        sb.append(Math.round(avg)).append("\n");
        sb.append(arr[N / 2]).append("\n");
        sb.append(freq_num).append("\n");
        sb.append(arr[N - 1] - arr[0]).append("\n");
        System.out.println(sb);
    }
}