
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B, int F) {
        // write your code in Java SE 8
        int N = A.length;
        int result = 0;

        ArrayList<C> cList = new ArrayList<C>();

        for (int i = 0; i < N; i++) {
            C c = new C(i, A[i] - B[i]);
            cList.add(c);
        }

        Collections.sort(cList, new Comparator<C>() {
            @Override
            public int compare(C c1, C c2) {
                return c1.value < c2.value ? 1 : -1;
            }
        });

        for (int i = 0; i < F; i++) {
            int index = cList.get(i).index;
            result += A[index];
        }

        for (int i = F; i < N; i++) {
            int index = cList.get(i).index;
            result += B[index];
        }

        return result;
    }

    class C {
        public int index;
        public int value;

        C(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}