import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visitied = new boolean[n];
        for (int i = 0 ; i < n; i++) {
            visitied[i] = false;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        
        for (int i = 0 ; i < n; i++) {
            
            if (!visitied[i]) {
                answer++;
                queue.add(i);    
                bfs(computers, visitied, queue);
            }
        }
        return answer;
    }
    public void bfs(int[][] computers, boolean[] visitied, LinkedList<Integer> queue) {
        
        while(queue.size() != 0) {
            int i = queue.poll();
            visitied[i] = true;
            
            for(int j = 0; j < computers[i].length; j++) {
                if (visitied[j] == false && computers[i][j] == 1) {
                    queue.add(j);
                }
            }    
        }
        
    }
}


class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visitied = new boolean[n];
        for (int i = 0 ; i < n; i++) {
            visitied[i] = false;
        }
        for (int i = 0 ; i < n; i++) {
            if (!visitied[i]) {
                answer++;
                dfs(computers, i, visitied);
            }
        }
        return answer;
    }
    public void dfs(int[][] computers, int i, boolean[] visitied) {
        visitied[i] = true;
        for(int j = 0; j < computers[i].length; j++) {
            if (visitied[j] == false && computers[i][j] == 1) {
                dfs(computers, j, visitied);
            }
        }
    }
}