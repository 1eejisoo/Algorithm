import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<List<Integer>> tuple = new ArrayList<>();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        s = s.replace("{", "");
        String[] s1 = s.split("}");

        for (String item : s1) {
            List<Integer> list = new ArrayList<>();
            String[] s2 = item.split(",");
            for (String value : s2) {
                if (value.equals("")) continue;
                list.add(Integer.parseInt(value));
            }
            tuple.add(list);
        }


        tuple.sort((o1, o2) -> {
            if (o1.size() < o2.size())
                return -1;
            return 1;
        });

        for(List<Integer> list : tuple) {
            set.addAll(list);
        }

        int[] answer = new int[tuple.size()];
        int idx = 0;
        for (Integer num : set) {
            answer[idx++] = num;
            System.out.print(num + " ");
        }

        return answer;
    }
}