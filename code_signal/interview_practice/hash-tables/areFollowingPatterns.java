boolean areFollowingPatterns(String[] strings, String[] patterns) {
    int currentIndex = 0;
    HashMap<String, Integer> stringsToIntegerMap = new HashMap();
    int[] stringsIntegerArray = new int[strings.length];
    for (int i = 0; i < strings.length; i++) {
        String string = strings[i];
        
        if (stringsToIntegerMap.containsKey(string)) {
            int stringIndex = stringsToIntegerMap.get(string);
            stringsIntegerArray[i] = stringIndex;
        } else {
            stringsToIntegerMap.put(string, currentIndex);
            stringsIntegerArray[i] = currentIndex;
            currentIndex++;
        }
    }
    
    currentIndex = 0;
    HashMap<String, Integer> patternsToIntegerMap = new HashMap();

    for(int i = 0; i < patterns.length; i++) {
        String pattern = patterns[i];
        int stringIndex = stringsIntegerArray[i];

        if (patternsToIntegerMap.containsKey(pattern)) {
            int patternIndex = patternsToIntegerMap.get(pattern);
            if (patternIndex != stringIndex) {
                return false;
            }
        } else {
            if (currentIndex != stringIndex) {
                return false;
            }
            patternsToIntegerMap.put(pattern, currentIndex);
            currentIndex++;
        }
    }
    
    return true;

}
