import java.util.HashMap;


class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String , Integer> map = new HashMap<String , Integer>();

        for(String s : completion){
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        for(String c : participant){
            if (!map.containsKey(c) || map.get(c) == 0) {
                return c;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        
        return "";
    }
}
