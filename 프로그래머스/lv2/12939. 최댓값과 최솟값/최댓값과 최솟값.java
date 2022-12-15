class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.split(" ");
        int[] intArr = new int[strArr.length];
        int max, min;

        for (int i = 0; i < strArr.length; i++)
            intArr[i] = Integer.parseInt(strArr[i]);

        max = intArr[0];
        min = intArr[0];

        for (int i = 0; i < strArr.length; i++) {
            if (intArr[i] > max) max = intArr[i];
            if (intArr[i] < min) min = intArr[i];
        }

        return sb.append(min).append(" ").append(max).toString();
    }
}