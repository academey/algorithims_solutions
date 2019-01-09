import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long aOccurrences = 0;
        char firstCharacter = 'a';
        int stringLength = s.length();
        long firstCharacterFrequencyOfS = 0;

        for (int i = 0; i < stringLength; i++) {
            if (s.charAt(i) == firstCharacter) {
                firstCharacterFrequencyOfS += 1;
            }
        }

        System.out.println("firstCharacterFrequencyOfS is " + firstCharacterFrequencyOfS);

        long quotient = (long) (n / stringLength);

        aOccurrences += quotient * firstCharacterFrequencyOfS;
        long remainder = n % stringLength;
        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == firstCharacter) {
                aOccurrences += 1;
            }
        }

        return aOccurrences;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
