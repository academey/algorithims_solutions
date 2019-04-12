import java.util.*;

class Solution {
    public int solution(String S) {
        int N = S.length();
        if (N == 0) {
            return 1;
        }
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if (")}]".indexOf(c) != -1) {

            }
            if (c == ')') {
                if (st.empty() || st.peek() != '(') {
                    return 0;
                } else {
                    st.pop();
                }
            } else if (c == ']') {
                if (st.empty() || st.peek() != '[') {
                    return 0;
                } else {
                    st.pop();
                }
            } else if (c == '}') {
                if (st.empty() || st.peek() != '{') {
                    return 0;
                } else {
                    st.pop();
                }

            } else if ("({[".indexOf(c) != -1) {
                st.push(c);
            }
        }

        if (!st.empty()) {
            return 0;
        }

        // write your code in Java SE 8
        return 1;
    }
}