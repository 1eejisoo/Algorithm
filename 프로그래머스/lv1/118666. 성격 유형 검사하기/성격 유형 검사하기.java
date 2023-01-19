import java.util.*;

class CharacterTypes {
    HashMap<Character, Integer> types;

    CharacterTypes(HashMap<Character, Integer> type) {
        this.types = type;
    }

    void put(char type) {
        types.put(type, 0);
    }

    Character findType() {
        List<Character> keySet = new ArrayList<>(types.keySet());
        keySet.sort((v1, v2) -> (types.get(v2).compareTo(types.get(v1))));
        return keySet.get(0);
    }
}

class Solution {
    static int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

    public void addScore(CharacterTypes ct, char[] character, int choice) {
        if (choice == 4) return;
        if (choice < 4) {  // character[0]에 점수 추가
            ct.types.put(character[0], ct.types.get(character[0]) + score[choice]);
            return;
        }
        // character[1]에 점수 추가
        ct.types.put(character[1], ct.types.get(character[1]) + score[choice]);
    }

    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        List<CharacterTypes> characterList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            characterList.add(new CharacterTypes(new HashMap<>()));
            characterList.get(i).put(types[i][0]);
            characterList.get(i).put(types[i][1]);
        }

        for (int i = 0; i < choices.length; i++) {
            char[] character = survey[i].toCharArray();
            int choice = choices[i];
            CharacterTypes ct = null;

            for (CharacterTypes c : characterList) {
                if (c.types.containsKey(character[0]) || c.types.containsKey(character[1])) {
                    addScore(c, character, choice);
                    break;
                }
            }
        }

        for (CharacterTypes c : characterList) {
            answer.append(c.findType());
        }

        return answer.toString();
    }
}