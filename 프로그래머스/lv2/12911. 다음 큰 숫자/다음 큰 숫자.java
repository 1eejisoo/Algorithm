class Solution {
    
    public int getOneCount(int n) {
        
        String original;

        original = Integer.toBinaryString(n);

        return original.length() - original.replace("1", "").length();
    }

    public int solution(int n) {
        
        int count = getOneCount(n);

        while (true) {
            if (getOneCount(n += 1) == count) break;
        }

        return n;
    }
}