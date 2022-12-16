import java.util.Arrays;
import java.util.Collections;

class Solution
{
    public int solution(int []A, int []B)
    {
        Integer[] arr = new Integer[B.length];
        int answer = 0;
        

        for (int i = 0; i < B.length; i++)
            arr[i] = B[i];

        Arrays.sort(A);
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * arr[i];
        }

        return answer;
    }
}