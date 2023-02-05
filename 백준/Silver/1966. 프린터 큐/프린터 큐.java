import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Document {
    int idx;
    int priority;

    Document(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}

public class Main {

    static int T;
    static int N, M;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            answer = 0;
            Queue<Document> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                q.offer(new Document(j, Integer.parseInt(st.nextToken())));
            }


            while (!q.isEmpty()) {
                boolean isMax = true;
                Document now = q.poll();
                for (Document next : q) {
                    if (next.priority > now.priority) {
                        q.offer(now);
                        isMax = false;
                        break;
                    }
                }
                if (isMax) answer++;
                if (isMax && now.idx == M) {
                    sb.append(answer).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}