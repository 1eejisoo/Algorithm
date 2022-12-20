import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());    // 판매 대수와 상관 없는 고정 비용
        int B = Integer.parseInt(st.nextToken());    // 한 대의 노트북을 생산하는 데에 필요한 재료비 + 인건비
        int C = Integer.parseInt(st.nextToken());    // 노트북 가격

        if (B >= C)
            System.out.println(-1);
        else System.out.println(A / (C - B) + 1);
    }
}