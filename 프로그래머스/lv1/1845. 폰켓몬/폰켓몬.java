import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> phoneketmon = new HashSet<>();

        for (int num : nums)
            phoneketmon.add(num);

        return Math.min(phoneketmon.size(), nums.length / 2);
    }
}