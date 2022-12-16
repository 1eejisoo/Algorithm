class Solution {
    public int[] solution(String s) {
        
        String newStr;
        int[] answer = new int[2];
        int count = 0, zeroCount = 0;

        while (!s.equals("1")) {
            newStr = s.replace("0", "");
            zeroCount += s.length() - newStr.length();
            s = newStr;
            s = Integer.toBinaryString(s.length());
            count++;
        }

        answer[0] = count;
        answer[1] = zeroCount;

        return answer;
    }
}