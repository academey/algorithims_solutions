import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static final char UP_STEP = 'U';
    static final char DOWN_STEP = 'D';
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int currentHeight = 0;
        int countOfVally = 0;
        for (int i = 0; i < n; i++) {
            char step = s.charAt(i);
            if (step == UP_STEP) {
                currentHeight += 1;
            } else if (step == DOWN_STEP) {
                if (currentHeight == 0) {
                    countOfVally += 1;
                }
                currentHeight -= 1;
            }
        }

        return countOfVally;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
