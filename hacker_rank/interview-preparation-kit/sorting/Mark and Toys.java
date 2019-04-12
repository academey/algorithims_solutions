import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int[] tempArray;

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        // quickSort(0, prices.length - 1, prices);
        int toyCount = 0;
        tempArray = new int[prices.length];
        mergeSort(0, prices.length - 1, prices);
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            System.out.println(price);
        }
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price <= k) {
                k -= price;
                toyCount++;
            }
        }

        return toyCount;
    }

    static void mergeSort(int left, int right, int[] arr) {
        if (left >= right) {
            return;
        }
        int p = (left + right) / 2;

        mergeSort(left, p, arr);
        mergeSort(p + 1, right, arr);
        merge(left, right, arr);
    }

    static void merge(int left, int right, int[] arr) {
        int p = (left + right) / 2;
        int i = left;
        int j = p + 1;
        int currentIndex = left;
        while (i <= p && j <= right) {

            if (arr[i] < arr[j]) {
                tempArray[currentIndex] = arr[i];
                i++;
                currentIndex++;
            } else {
                tempArray[currentIndex] = arr[j];
                j++;
                currentIndex++;
            }
        }

        if (i <= p) {
            while (i <= p) {
                tempArray[currentIndex] = arr[i];
                i++;
                currentIndex++;
            }
        } else if (j <= right) {
            while (j <= right) {
                tempArray[currentIndex] = arr[j];
                j++;
                currentIndex++;
            }
        }

        for (int k = left; k <= right; k++) {
            arr[k] = tempArray[k];
        }
    }

    static int patrition(int left, int right, int[] arr) {
        int key = left;
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[key] > arr[i]) {
                i++;
            }
            while (i < j && arr[key] < arr[j]) {
                j--;
            }
            if (i < j) {
                swap(i, j, arr);
            }
        }

        return i;
    }

    static void quickSort(int left, int right, int[] arr) {
        if (right - left < 1) {
            return;
        }
        int p = patrition(left, right, arr);
        quickSort(left, p - 1, arr);
        quickSort(p + 1, right, arr);
    }

    static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
