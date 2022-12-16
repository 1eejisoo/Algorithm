import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String id;
        String[] answer, data;
        ArrayList<String> result = new ArrayList<>();
        Map<String, String> user = new HashMap<>();

        for (String s : record) {
            data = s.split(" ");

            if (data[0].equals("Enter")) {
                user.put(data[1], data[2]);
                result.add(data[1] + "님이 들어왔습니다.");
            }
            if (data[0].equals("Leave")) {
                result.add(data[1] + "님이 나갔습니다.");
            }
            if (data[0].equals("Change")) {
                user.put(data[1], data[2]);
            }
        }

        answer = result.toArray(new String[0]);

        for (int i = 0; i < answer.length; i++) {
            id = answer[i].substring(0, answer[i].indexOf("님"));
            answer[i] = answer[i].replace(id, user.get(id));
        }

        return answer;
    }
}