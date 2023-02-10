import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        ArrayList<Integer> dq = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i], " ");
            String cmd = st.nextToken();
            int number = Integer.parseInt(st.nextToken());

            if (cmd.equals("I")) {
                dq.add(number);
                continue;
            }
            Collections.sort(dq);
            if (number == 1 && !dq.isEmpty()) {
                dq.remove(dq.size() - 1);
            } else if (number == -1 && !dq.isEmpty()) {
                dq.remove(0);
            }
        }

        Collections.sort(dq);
        if (!dq.isEmpty()) {
            answer[0] = dq.get(dq.size() - 1);
            answer[1] = dq.get(0);
        }

        return answer;
    }
}