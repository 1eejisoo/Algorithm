class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] primeArr = new boolean[n+1];

        primeArr[0] = false;
        primeArr[1] = false;

        for (int i = 2; i <= n; i++)
            primeArr[i] = true;

        for (int i = 2; (i*i) <= n; i++){
            if (primeArr[i]) {
                for (int j = i*i; j <= n; j+=i){
                    primeArr[j] = false;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (primeArr[i])
                answer++;
        }

        return answer;
    }
}