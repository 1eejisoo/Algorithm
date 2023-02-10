class Solution {
    static int answer = 0;
    
    public boolean isPrime(int n) {
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public void comb(int start, int r, int[] nums, boolean[] visited) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) sum += nums[i];
            }  
            if (isPrime(sum)) answer++;
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            visited[i] = true;
            comb(i + 1, r - 1, nums, visited);
            visited[i] = false;
        }
    }
    
    public int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        comb(0, 3, nums, visited);
        return answer;
    }
}