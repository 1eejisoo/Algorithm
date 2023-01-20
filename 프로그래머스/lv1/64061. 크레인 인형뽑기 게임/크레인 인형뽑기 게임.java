import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Queue<Integer>> doll = new ArrayList<>();
        Stack<Integer> select = new Stack<>();
        int n = board.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            doll.add(new LinkedList<>());
        }
        for (int[] ints : board) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 0) continue;
                doll.get(j).offer(ints[j]);
            }
        }
        for (int move_num : moves) {
            if (select.size() >= 2) {
                int a = select.pop();
                int b = select.pop();
                if (a != b) {
                    select.push(b);
                    select.push(a);
                } else answer += 2;
            }
            if (doll.get(move_num - 1).isEmpty()) continue;
            select.push(doll.get(move_num - 1).poll());
        }
        return answer;
    }
}