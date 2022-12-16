import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int index = B.length - 1;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int data : A) {
            answer += data * B[index--];
        }

        return answer;
    }
}