class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int start = -1;
        int end = 0;
        int result = 0;

        String s = Integer.toBinaryString(N);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                if (start == -1) {
                    start = i;
                } else {
                    result = result > (i - start - 1) ? result : (i - start - 1);
                    start = i;
                }
            }
        }

        return result;
    }
}