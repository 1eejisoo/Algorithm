import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        LinkedHashMap<String, Integer> report_count = new LinkedHashMap<>();  // 신고 당한 횟수 저장
        LinkedHashMap<String, List<String>> report_records = new LinkedHashMap<>();  // 신고한 내역 저장
        LinkedHashMap<String, Integer> mail_count = new LinkedHashMap<>();  // 메일 받을 횟수 저장
        HashSet<String> report_set = new HashSet<>();  // 중복신고 무효처리용

        int size = id_list.length;

        for (String id : id_list) {
            report_count.put(id, 0);
            report_records.put(id, new ArrayList<>());
            mail_count.put(id, 0);
        }

        for (String r : report) {
            if (report_set.add(r)) {
                String[] report_record = r.split(" ");
                String from = report_record[0];
                String to = report_record[1];
                report_records.get(from).add(to);  // 신고 내역 저장
                report_count.put(to, report_count.get(to) + 1);  // 신고 횟수 저장

            }
        }

        for (String reported : report_count.keySet()) {
            if (report_count.get(reported) >= k) {
                for (String reporter : report_records.keySet()) {
                    if (report_records.get(reporter).contains(reported))
                        mail_count.put(reporter, mail_count.get(reporter) + 1);
                }
            }
        }

        int idx = 0;
        int[] answer = new int[size];

        for (Integer cnt : mail_count.values()) {
            answer[idx] = cnt;
            idx++;
        }

        return answer;
    }
}