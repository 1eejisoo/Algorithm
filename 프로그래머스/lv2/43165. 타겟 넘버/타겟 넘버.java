class Solution {
    
    static int answer;
    
    public void dfs(int cur, int sum, int[] numbers, int target) {
        if (cur == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        dfs(cur + 1, sum + numbers[cur], numbers, target);
        dfs(cur + 1, sum + numbers[cur] * -1, numbers, target);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;       
    }
}