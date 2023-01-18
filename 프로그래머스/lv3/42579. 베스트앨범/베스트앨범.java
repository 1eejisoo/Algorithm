import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Song {
    int id;
    int play_count;

    Song(int id, int play_count) {
        this.id = id;
        this.play_count = play_count;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genre_map = new HashMap<>();  // 장르별 재생 횟수 기록
        HashMap<String, List<Song>> map = new HashMap<>();     // 장르별 노래 목록 기록
        List<Integer> answerList = new ArrayList<>();
        int size = genres.length;

        // 장르별 재생 횟수 기록, 장르별 노래 목록 기록 맵 초기화
        for (int i = 0; i < size; i++) {
            genre_map.put(genres[i], genre_map.getOrDefault(genres[i], 0) + plays[i]);
            map.put(genres[i], new ArrayList<>());
        }

        // 장르별 노래 목록 기록
        for (int i = 0; i < size; i++) {
            map.get(genres[i]).add(new Song(i, plays[i]));
        }

        // 장르 내 정렬 수행
        for (List<Song> songList : map.values()) {
            songList.sort((o1, o2) -> {
                if (o1.play_count > o2.play_count)
                    return -1;
                if (o1.play_count == o2.play_count) {
                    if (o1.id > o2.id) return 1;
                }
                return 0;
            });
        }

        // 장르별 재생횟수를 기준으로 내림차순 정렬
        List<String> key_set = new ArrayList<>(genre_map.keySet());
        key_set.sort((v1, v2) -> (genre_map.get(v2).compareTo(genre_map.get(v1))));

        // 베스트 앨범 기록
        for (String genre : key_set) {
            List<Song> songList = map.get(genre);

            if (songList.size() == 1) {  // 장르에 속한 곡이 하나라면 그것만 선택
                answerList.add(songList.get(0).id);
                continue;
            }
            for (int i = 0; i < 2; i++) {
                answerList.add(songList.get(i).id);
            }
        }

        // List -> Array 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}