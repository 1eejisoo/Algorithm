import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[][] sizes) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                a.add(size[0]);
                b.add(size[1]);
            } else {
                b.add(size[0]);
                a.add(size[1]);
            }
        }

        return Collections.max(a) * Collections.max(b);
    }
}