import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[][] supoja = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> listKeySet;
        int r = 0;
        int[] answer;

        for (int i = 0; i < supoja.length; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < supoja.length; j++) {
                if (supoja[j][i % supoja[j].length] == answers[i]) {
                    map.put(j, map.get(j) + 1);
                }
            }
        }

        int max = map.get(0);

        for (int value : map.values()) {
            if (max < value) max = value;
        }

        for (int value : map.values()) {
            if (max == value)
                r++;
        }

        answer = new int[r];

        listKeySet = new ArrayList<>(map.keySet());
        listKeySet.sort((v1, v2) -> (map.get(v2).compareTo(map.get(v1))));

        for (int i = 0; i < r; i++) {
            answer[i] = listKeySet.get(i) + 1;
        }

        return answer;
    }
}