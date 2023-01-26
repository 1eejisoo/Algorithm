import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<String, Integer> map = new HashMap<>();

    public void init(String[] want) {
        for (String w : want) {
            map.put(w, 0);
        }
    }

    public boolean check(String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            if (map.get(want[i]) < number[i])
                return false;
        }
        return true;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int size = discount.length;

        for (int i = 0; i <= size - 10; i++) {
            init(want);
            for (int j = i; j < i + 10; j++) {
                if (map.get(discount[j]) != null)
                    map.put(discount[j], map.get(discount[j]) + 1);
            }
            if (check(want, number)) answer++;
        }
        return answer;
    }
}