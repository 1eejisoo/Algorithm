import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Document {
    int idx;
    int priority;

    Document(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int[] answer = new int[priorities.length];
        Queue<Document> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.add(new Document(i, priorities[i]));
        }

        int order = 1;
        while (!q.isEmpty()) {
            Document cur = q.poll();
            boolean isTrue = true;

            for (Document nxt : q) {
                if (nxt.priority > cur.priority) {
                    q.add(cur);
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) answer[cur.idx] = order++;
        }
        return answer[location];
    }
}