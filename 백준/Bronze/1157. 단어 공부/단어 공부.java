import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String s = br.readLine().toUpperCase();
       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       int[] arr = new int[26];
       int max = -1;
       char result = ' ';

       for (int i=0; i < s.length(); i++){
           if (alphabet.contains(String.valueOf(s.charAt(i)))) {
               arr[alphabet.indexOf(String.valueOf(s.charAt(i)))]++;
           }
       }

       for (int i =0; i < 26; i++){
           if (arr[i] > max) {
               max = arr[i];
               result = alphabet.charAt(i);
           } else if (arr[i] == max) result = '?';
       }
       System.out.println(result);
    }
}
