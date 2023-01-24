import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static HashMap<String, Boolean> log = new HashMap<>();
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String state = st.nextToken();

            if (state.equals("enter")) {
                log.put(name, true);
            } else {
                log.put(name, false);
            }
        }
        for (String key : log.keySet()) {
            if (log.get(key))  results.add(key);
        }
        
        results.sort(Comparator.reverseOrder());
        
        for (String name : results)
            System.out.println(name);
    }
}