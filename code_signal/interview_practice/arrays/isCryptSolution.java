boolean isCryptSolution(String[] crypt, char[][] solution) {
    boolean isSuccess = true;
    Long[] decryptedValues = new  Long[3];
    HashMap<Character, Character> solutionMap = new HashMap<Character, Character>();
    for (int i = 0; i < solution.length; i++) {
        char character = solution[i][0];
        solutionMap.put(solution[i][0], solution[i][1]);
    }


    for (int i = 0; i < crypt.length; i++) {
        int wordLength = crypt[i].length();
        StringBuilder decryptedStringBuilder = new StringBuilder();
        for (int j = 0; j < wordLength; j++) {
            decryptedStringBuilder.append(solutionMap.get(crypt[i].charAt(j)));
        }

        String decryptedString = decryptedStringBuilder.toString();
        if (decryptedString.length() != 1 && decryptedString.charAt(0)=='0') {
            isSuccess = false;
            break;
        } else {
            decryptedValues[i] = Long.parseLong(decryptedString);
        }
    }

    if (isSuccess && (decryptedValues[0] + decryptedValues[1] != decryptedValues[2])) {
        isSuccess = false;
    }

    return isSuccess;


}
