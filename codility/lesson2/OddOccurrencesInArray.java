import java.util.HashMap;

import java.util.Map;

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        HashMap<Integer, Boolean> hashMap = new HashMap();

        for (int i = 0; i < N; i++) {
            int key = A[i];
            if (hashMap.containsKey(key)) {
                hashMap.put(key, !hashMap.get(key));
            } else {
                hashMap.put(key, false);
            }

        }

        for (Map.Entry<Integer, Boolean> entry : hashMap.entrySet()) {
            int key = entry.getKey();
            Object value = entry.getValue();

            if ((Boolean) value == false) {
                return key;
            }
        }

        return 0;
    }
}