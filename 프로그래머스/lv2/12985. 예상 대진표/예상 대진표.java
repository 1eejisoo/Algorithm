class Solution {

    public int getWinIdx(int n) {
        if (n % 2 == 0) return n / 2;
        return (n + 1) / 2;
    }

    public int solution(int n, int a, int b) {
        int answer = 1;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        while (max - min != 1 || (min % 2) != 1 || (max % 2) != 0) {
            min = getWinIdx(min);
            max = getWinIdx(max);
            answer++;
        }
        return answer;
    }
}