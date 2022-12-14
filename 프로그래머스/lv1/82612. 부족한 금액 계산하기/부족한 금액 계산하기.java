class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for (int i=1; i<=count; i++) {
            answer +=  price * i;
        }
        answer = money - answer;
        if (answer > 0 ) return 0;
        else return -answer;
    }
}