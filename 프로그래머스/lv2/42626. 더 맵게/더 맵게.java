import java.util.PriorityQueue;

class Solution {
    public static boolean isOverK(PriorityQueue<Integer> pq, int K) {

        for (Integer i : pq) {
            if (i < K) {
                return false;
            }
        }
        return true;
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int data, answer = 0;

        for (int i : scoville) {
            pq.add(i);
        }

        if (isOverK(pq, K)) return 0;

        while (!isOverK(pq, K)){
            if(pq.size() < 2) return -1;
            
            data = pq.remove() + pq.remove() * 2;
            pq.add(data);
            answer += 1;
        }
        
        return answer;
    }
}