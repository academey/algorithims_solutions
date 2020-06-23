class Solution {
    public int solution(int N) {
        String s = Integer.toBinaryString(N);

        int max = 0;
        int startIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '1') {
                continue;
            }
            
            if (startIndex == -1 || max >= i - startIndex) {
                startIndex = i;
            } else {
                max = i - startIndex - 1;
                startIndex = i;
            }
        }
        return max;
    }
}
