import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Integer> qu = new ArrayDeque<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int N = priorities.length;
        for (int i = 0; i < N; i++) {
            qu.add(priorities[i]);
            pq.add(priorities[i]);
        }
        int currentLocation = location;
        while (qu.size() != 0) {
            if (qu.peek() == pq.peek()) {
                answer += 1;
                
                qu.poll();
                pq.poll();
                if (currentLocation == 0) {
                    return answer;
                } else {
                    currentLocation -= 1;
                }
            } else {
                int top = qu.poll();
                qu.add(top);
                if (currentLocation == 0) {
                    currentLocation = qu.size() - 1;
                } else {
                    currentLocation -= 1;
                }
            }
            
        }
        

        return answer;
    }
}