class Solution {
    public int gdc(int w, int h) {
        if (w < h) {
            int temp = w;
            w = h;
            h = temp;
        }

        while (h != 0) {
            int r = w % h;
            w = h;
            h = r;
        }

        return w;
    }

    public long solution(int w, int h) {
        return (long) w * h - (w + h - gdc(w, h));
    }
}