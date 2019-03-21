boolean containsCloseNums(int[] nums, int k) {
    HashMap<Integer, Integer> numsMap = new HashMap();
    for (int i = 0; i < nums.length; i++) {
         int num = nums[i];
         if (numsMap.containsKey(num)) {
              if (i - numsMap.get(num) <= k) {
                   return true;
              }    
         }
         
         numsMap.put(num, i);
    }
    
    return false;
}
