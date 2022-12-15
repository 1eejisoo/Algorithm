import java.util.*;

class Solution {
    
    public double calcFailureRate(int level, int[] stages) {
        
        int challengeSize = 0;
        int unsuccessfulSize = 0;

        for (int stage : stages) {
            if (stage >= level) challengeSize++;
            if (stage == level) unsuccessfulSize++;
        }
        
        if (challengeSize > 0)
            return (double) unsuccessfulSize / challengeSize;
        return 0.0;
    }
    
    public int[] solution(int N, int[] stages) {
        
        int index = 0;
        int[] answer = new int[N];
        Map<Integer, Double> failureRate = new HashMap<>();

        for (int i = 0; i < N; i++) {
            failureRate.put(i, 0.0);
        }

        for (int i = 0; i < N; i++){
            failureRate.put(i, calcFailureRate(i+1, stages));
        }

        List<Integer> levels = new ArrayList<>(failureRate.keySet());
        levels.sort(Comparator.comparing(failureRate::get).reversed());

        for (Integer key : levels) {
            answer[index++] = key + 1;
        }
        
        return answer;
    }
}