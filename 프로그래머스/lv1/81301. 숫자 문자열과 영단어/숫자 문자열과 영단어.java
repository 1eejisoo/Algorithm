import java.util.*;

class Solution {
    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (String number : numbers) {
            if (s.contains(number)) 
                s = s.replaceAll(number, String.valueOf(Arrays.asList(numbers).indexOf(number)));
        }

        return Integer.parseInt(s);
    }
}