class Solution {
    static int n;
    
    public int calc(int[][] dp, int[][] triangle, int depth, int idx) {
        if (depth == n - 1) {
            return dp[depth][idx];
        }
        
        if (dp[depth][idx] == 0) {
            dp[depth][idx] = Math.max(calc(dp, triangle, depth + 1, idx) , calc(dp, triangle, depth + 1, idx + 1)) + triangle[depth][idx];
        }    
        
        return dp[depth][idx];
    }
    
    public int solution(int[][] triangle) {
        int answer = 0;
        n = triangle.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }
        
        answer = calc(dp, triangle, 0, 0);
        return answer;
    }
}