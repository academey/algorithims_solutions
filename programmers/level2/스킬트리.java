
// 요거는 정규표현식으로 훨씬 이쁘게 풀린다. 심지어 stack 을 안 써도 되고, O(n^2) 도 아니다.

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String skill_tree = skill_trees[i];
            LinkedList<Character> queue = new LinkedList<Character>();
            boolean isPossible = true;
            for (int j = 0; j < skill.length(); j++) {
                queue.offer(skill.charAt(j));
            }

            for (int j = 0; j < skill_tree.length(); j++) {
                char s = skill_tree.charAt(j);
                if (skill.indexOf(s) == -1) {
                    continue;
                }

                if (s == queue.peek()) {
                    queue.poll();
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                answer++;
            }
        }
        return answer;
    }
}