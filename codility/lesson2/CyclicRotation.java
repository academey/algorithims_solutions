// 처음에는 InOrder shift 로 풀어보려고 했으나 불가능하다. 예를 들어 배열의 길이가 6이라고 하면 0 -> 4 -> 2 -> 0 -> 4 -> 2 가 반복되어 변경되지 않는 인덱스도 있기 때문이다.
// N == 0 이면 K % N 연산에서 divided by zero error 발생한다.

class Solution {
    public int[] solution(int[] A, int K) {
        int N = A.length;
        if (N == 0) {
            return A;
        }

        K = K % N;
        if (K == 0) {
            return A;
        }

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int shiftedIndex = 0;
            if (i + K >= N) {
                shiftedIndex = i + K - N;
            } else {
                shiftedIndex = i + K;
            }
            result[shiftedIndex] = A[i];
        }
        // int currentIndex = 0;
        // int nextValue = A[currentIndex];

        // for (int i = 0; i < A.length; i++) {
        // int nextIndex = 0;
        // if (currentIndex + K >= A.length) {
        // nextIndex = currentIndex + K - A.length;
        // } else {
        // nextIndex = currentIndex + K;
        // }
        // int tempValue = A[nextIndex];
        // A[nextIndex] = nextValue;
        // nextValue = tempValue;
        // currentIndex = nextIndex;
        // }

        return result;
    }
}