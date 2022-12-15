class Solution {
    public String solution(int a, int b) {
        
        String[] weeks = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int week = 0;

        for (int i = 0; i < a - 1; i++) {
            week += days[i];
        }
         
        return weeks[(week + b) % 7];
    }
}