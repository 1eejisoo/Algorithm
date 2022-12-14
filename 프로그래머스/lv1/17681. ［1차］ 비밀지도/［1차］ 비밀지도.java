class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String binaryString;
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.delete(0, n + 1);
            binaryString = Integer.toBinaryString(arr1[i] | arr2[i]);
            for (int j = 0; j < n; j++) {
                if (binaryString.length() != n) binaryString = "0".repeat(n - binaryString.length()) + binaryString;
                
                if (binaryString.charAt(j) == '1') {
                    sb.append("#");
                } else sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}