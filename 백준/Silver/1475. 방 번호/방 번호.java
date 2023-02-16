import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static String N;
    static int answer = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();

        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';
            if (num == 6) map.put(9, map.getOrDefault(9, 0) + 1);
            else map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (map.containsKey(9)) {
            int value = map.get(9);
            if (value % 2 == 0) map.put(9, value / 2);
            else map.put(9, value / 2 + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
        answer = map.get(keySet.get(0));

        System.out.println(answer);
    }
}