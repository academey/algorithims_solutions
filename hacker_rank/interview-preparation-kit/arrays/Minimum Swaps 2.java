import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int minimumSwapCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int expectedValue = i + 1;
            if (value == expectedValue) {
                continue;
            } else if (arr[value - 1] == expectedValue) {
                int temp = arr[value - 1];
                arr[value - 1] = expectedValue;
                arr[i] = temp;
                minimumSwapCount++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int expectedValue = i + 1;
            if (value == expectedValue) {
                continue;
            }
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == expectedValue) {
                    arr[i] = expectedValue;
                    arr[j] = value;
                    minimumSwapCount++;
                    break;
                }
            }
        }

        return minimumSwapCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
