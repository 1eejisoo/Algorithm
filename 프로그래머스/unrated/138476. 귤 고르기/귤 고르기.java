import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int n = tangerine.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
        
        for (int i = 0; i < k; i++) {
            int number = list.get(0);
            set.add(number);
            map.put(number, map.get(number) - 1);
            if (map.get(number) <= 0) list.remove(0);
        }
        
        return set.size();
    }
}