import java.util.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int N = progresses.length;
        int[] endDayArr = new int[N];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            double test = (100 - progress) / (double)speed;
            
            endDayArr[i] = (int)Math.ceil(test);     
        }        
        
        int prevValue = -1;
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            int endDay = endDayArr[i];

            if (prevValue == -1) {
                prevValue = endDay;
                count = 1;
            } else if (prevValue >= endDay) {
                count += 1;
            } else {
                arrayList.add(count);
                prevValue = endDay;
                count = 1;
            }
        }
        arrayList.add(count);
        
        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}