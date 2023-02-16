import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static String S;

    public static boolean isError() {
        if (isCpp() && isJava()) return true;
        if (S.charAt(0) == '_' || Character.isUpperCase(S.charAt(0))) return true;
        if (S.charAt(S.length() - 1) == '_') return true;

        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == '_' && S.charAt(i + 1) == '_') return true;
        }

        return false;
    }
    public static boolean isCpp() {
        return S.contains("_");
    }

    public static boolean isJava() {
        for (int i = 0; i < S.length(); i++) {
            if (Character.isUpperCase(S.charAt(i))) return true;
        }
        return false;
    }

    public static String convertCpp(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append("_").append(Character.toLowerCase(c));
            } else sb.append(c);
        }

        return sb.toString();
    }

    public static String convertJava() {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(S, "_");
        List<String> list = new ArrayList<>();

        while(st.hasMoreTokens()) {
            list.add(st.nextToken());
        }

        sb.append(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            String start = list.get(i).toUpperCase();
            String s = list.get(i).substring(1);
            sb.append(start.charAt(0)).append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        if (isError()) {
            System.out.println("Error!");
            return;
        }
        if (isCpp()) {
            System.out.println(convertJava());
        } else {
            System.out.println(convertCpp());
        }
    }
}