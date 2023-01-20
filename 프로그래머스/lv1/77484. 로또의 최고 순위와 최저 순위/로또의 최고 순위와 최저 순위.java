import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> winNums = new HashSet<>();
        int[] score = {6, 6, 5, 4, 3, 2, 1};
        int[] answer = new int[2];
        int unknown_cnt = 0, cnt = 0;

        for (int win_num : win_nums) winNums.add(win_num);

        for (int lotto : lottos) {
            if (winNums.contains(lotto)) cnt++;
            if (lotto == 0) unknown_cnt++;
        }
        answer[0] = score[unknown_cnt + cnt];
        answer[1] = score[cnt];

        return answer;
    }
}