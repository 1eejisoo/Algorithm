import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
String[] answer = new String[strings.length];
        LinkedHashMap<String, Character> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();

        Arrays.sort(strings);

        for (String string : strings) {
            map.put(string, string.charAt(n));
        }

        LinkedHashSet<Map.Entry<String, Character>> entryList = new LinkedHashSet<>(map.entrySet());
        entryList.stream().sorted(Map.Entry.comparingByValue())
                .forEach(entry -> list.add(entry.getKey()));

        for (int i = 0; i < strings.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}