import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            answer++;
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        if (map.size() > 1) {
            int mul = 1;
            for (String key : map.keySet()) {
                mul *= map.get(key) + 1;
            }
            return mul - 1;
        } 
        return answer;
    }
}