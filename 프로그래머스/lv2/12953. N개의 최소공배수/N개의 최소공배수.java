class Solution {

    static int gdc(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a * b / gdc(a, b);
    }

    public int solution(int[] arr) {
        int answer = lcm(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }
}