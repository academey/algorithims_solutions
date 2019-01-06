char firstNotRepeatingCharacter(String s) {
    char resultChar = '_';
    byte[] flags = new byte[256];

    for (int i = 0; i < s.length(); i++) {
        flags[(int)s.charAt(i)]++ ;
    }

    for (int i = 0; i < s.length(); i++) {
        if (flags[(int)s.charAt(i)] == 1) {
            resultChar = s.charAt(i);
            break;
        }
    }

    return resultChar;
}
