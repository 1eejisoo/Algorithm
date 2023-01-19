import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    static List<HashMap<String, Integer>> termsList = new ArrayList<>();  // 약관정보 리스트

    public boolean isExpired(String today, String privacy_day, String type) {
        String[] today_arr = today.split("\\.");
        String[] day_arr = privacy_day.split("\\.");
        int year = Integer.parseInt(day_arr[0]);
        int month = Integer.parseInt(day_arr[1]);
        int day = Integer.parseInt(day_arr[2]);
        int term = 0;  // 유효기간 달 수

        for (HashMap<String, Integer> hm : termsList) {
            if (hm.containsKey(type)) {
                term = hm.get(type);
                break;
            }
        }

        year += term / 12;
        month += term % 12;
        day -= 1;

        if (month > 12) {
            year += 1;
            month -= 12;
        }
        if (day == 0) {
            day = 28;
            month -= 1;
        }

        if (year < Integer.parseInt(today_arr[0])) return true;
        if (year > Integer.parseInt(today_arr[0])) return false;
        if (month < Integer.parseInt(today_arr[1])) return true;
        if (month > Integer.parseInt(today_arr[1])) return false;
        
        return day < Integer.parseInt(today_arr[2]);
    }

    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termsList.add(new HashMap<>());
            termsList.get(i).put(term[0], Integer.parseInt(term[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            if (isExpired(today, privacy[0], privacy[1]))
                answerList.add(i + 1);
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}