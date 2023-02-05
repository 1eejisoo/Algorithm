import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student {
    int idx;
    int number;
    int count;

    Student(int idx, int number, int count) {
        this.idx = idx;
        this.number = number;
        this.count = count;
    }
}

public class Main {
    static int N, M;
    static int[] students;
    static List<Student> availableList = new ArrayList<>();
    static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        students = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            boolean isContain = false;
            students[i] = Integer.parseInt(st.nextToken());

            for (Student s : availableList) {
                if (students[i] == s.number) {
                    s.count += 1;
                    isContain = true;
                    break;
                }
            }

            if (isContain) continue;
            if (availableList.size() >= N) {
                availableList.sort((o1, o2) -> {
                    if (o1.count < o2.count)
                        return -1;
                    else if (o1.count == o2.count) {
                        if (o1.idx < o2.idx)
                            return -1;
                        else return 1;
                    } else return 1;
                });
                availableList.remove(0);
            }
            availableList.add(new Student(i, students[i], 1));
        }
        for (int i = 0; i < availableList.size(); i++) {
            if (i == N) break;
            resultList.add(availableList.get(i).number);
        }
        Collections.sort(resultList);
        for (int r : resultList)
            System.out.print(r + " ");
    }
}