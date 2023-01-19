import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    static List<HashMap<String, Integer>> termsList = new ArrayList<>();  // 약관정보 리스트

    public boolean isExpired(int today, String privacy_day, String type) {

        String[] day_arr = privacy_day.split("\\.");
        int day =  (Integer.parseInt(day_arr[0]) * 12 * 28) + (Integer.parseInt(day_arr[1]) * 28) + Integer.parseInt(day_arr[2]);
        int term = 0;  // 유효기간 달 수

        for (HashMap<String, Integer> hm : termsList) {
            if (hm.containsKey(type)) {
                term = hm.get(type);
                break;
            }
        }
        day += term * 28;

        return today >= day;
    }

    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> answerList = new ArrayList<>();
        String[] today_arr = today.split("\\.");
        int t = Integer.parseInt(today_arr[0]) * 12 * 28 + Integer.parseInt(today_arr[1]) * 28 + Integer.parseInt(today_arr[2]);

        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termsList.add(new HashMap<>());
            termsList.get(i).put(term[0], Integer.parseInt(term[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            if (isExpired(t, privacy[0], privacy[1]))
                answerList.add(i + 1);
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}