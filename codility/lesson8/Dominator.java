import java.util.*;

class Solution {
    public int solution(int[] A) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            int key = A[i];
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }

        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            if ((int) pair.getValue() > A.length / 2) {
                for (int i = 0; i < A.length; i++) {
                    if (A[i] == (int) pair.getKey()) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }
}