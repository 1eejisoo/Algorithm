class Solution {

    public boolean isContain(String skill, char c) {
        for (int i = 0; i < skill.length(); i++) {
            if (skill.charAt(i) == c) return true;
        }
        return false;
    }

    public boolean isCorrect(String skill, String target) {
        int idx = 0;

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != skill.charAt(idx++)) {
                return false;
            }
            if(idx == skill.length()) break;
        }
        return true;
    }
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        StringBuilder sb;

        for (String s : skill_trees) {
            sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (isContain(skill, s.charAt(i))) {
                    sb.append(s.charAt(i));
                }
            }
            if (sb.length() == 0) {
                answer++;
                continue;
            }
            if (skill.charAt(0) != sb.charAt(0)) continue;
            if (isCorrect(skill, sb.toString())) answer++;
        }

        return answer;
    }
}