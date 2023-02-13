import java.util.*;

class Solution {
    static int answer = 0;
    static HashSet<Integer> set = new HashSet<>();
    
    public int makeNumber(char[] out) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < out.length; i++) {
            sb.append(out[i]);
        }
        return Integer.parseInt(sb.toString());
    }
    
    public boolean isPrime(int number) {
        if (number == 0 || number == 1) return false;
        for (int i = 2; i <= (int)Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
    public void permutation(char[] arr, boolean[] visited, char[] out, int depth, int r) {
        if (depth == r) {
            int number = makeNumber(out);
            if (isPrime(number) && set.add(number)) answer++;
            return;
        }    
        
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            out[depth] = arr[i];
            permutation(arr, visited, out, depth + 1, r);
            visited[i] = false;
        }
    }
    
    public int solution(String numbers) {
        int n = numbers.length();
        char[] arr = new char[n];
        char[] out;
        boolean[] visited;
        
        for (int i = 0; i < n; i++) {
            arr[i] = numbers.charAt(i);
        }
        
        for (int i = 1; i <= n; i++) {
            out = new char[i];
            visited = new boolean[n];
            permutation(arr, visited, out, 0, i);
        }
    
        return answer;
    }
}