int firstDuplicate(int[] a) {
    HashMap<Integer, Boolean> alreadyAppearedMap = new HashMap();
    Integer result = -1;
    for (int i = 0; i < a.length; i++) {
        Integer value = a[i];
        Boolean alreadyAppeared = alreadyAppearedMap.containsKey(value);
        if (alreadyAppeared) {
            result = value;
            break;
        } else {
            alreadyAppearedMap.put(value, true);
        }
    }

    return result;
}
