class Solution {
    public int solution(int n) {
        
        int number = 0;
        int answer = 0;

        for (int i = 1; i <=n; i++) {
            number += i;
            if (number == n) {
                answer++;
                break;
            }
            for (int j = i+1; j <= n/2 + 1; j++) {
                number += j;
                if (number == n) {
                    answer++;
                    break;
                }
                if (number > n) break;
            }
            number = 0;
        }

        return answer;
    }
}