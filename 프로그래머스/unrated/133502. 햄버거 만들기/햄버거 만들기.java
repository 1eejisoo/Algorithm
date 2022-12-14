class Solution {
    public int solution(int[] ingredient) {
        
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for (int n : ingredient) {
            sb.append(n);
            if (sb.length() >= 4 && sb.subSequence(sb.length() - 4, sb.length()).equals("1231")) {
                answer++;
                sb.delete(sb.length() - 4, sb.length());
            }
        }

        return answer;
    }
}