import java.util.HashMap;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++){
            for (int j = 1; j < phone_book[i].length(); j++) {
                map.put(phone_book[i].substring(0, j), true);
            }
        }
        
        for (String phone_number: phone_book) {
            if (map.containsKey(phone_number)) {
                answer = false;
            }
        }
        
        return answer;
    }
}


class SolutionUsingSort {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for (int i = 0; i < (phone_book.length - 1); i++){
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = true;
            }
        }
        
        return answer;
    }
}