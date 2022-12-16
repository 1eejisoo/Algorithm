import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        int size = brown + yellow;
        ArrayList<Integer> divisor = new ArrayList<>();

        for (int i = 1; i <= (int) Math.sqrt(size); i++) {
            if (size % i == 0) {
                divisor.add(i);
                if (size / i != i) {
                    divisor.add(size / i);
                }
            }
        }

        Collections.reverse(divisor);

        if (divisor.size() % 2 != 0) {
            divisor.add(1, divisor.get(0));
        }

        for (int i = 0; i < divisor.size(); i += 2) {
            if ((divisor.get(i) + divisor.get(i + 1)) * 2 - 4 == brown) {
                answer[0] = divisor.get(i);
                answer[1] = divisor.get(i + 1);
                break;
            }
        }

        return answer;
    }
}