import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MrX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of players
        int m = sc.nextInt(); // number of shots

        int[] playerL = new int[n];
        int[] playerR = new int[n];
        for (int i = 0; i < n; i++) {
            playerL[i] = sc.nextInt();
            playerR[i] = sc.nextInt();
        }

        int[] shotL = new int[m];
        int[] shotR = new int[m];
        for (int i = 0; i < m; i++) {
            shotL[i] = sc.nextInt();
            shotR[i] = sc.nextInt();
        }

        Arrays.sort(playerL);
        Arrays.sort(playerR);

        long result = 0;
        for (int i = 0; i < m; i++) {
            int l = shotL[i];
            int r = shotR[i];
            // Number of players whose left endpoint <= r
            int left = upperBound(playerL, r);
            // Number of players whose right endpoint < l
            int right = lowerBound(playerR, l);
            result += (left - right);
        }
        System.out.println(result);
        sc.close();
    }

    // Returns index of first element > val
    static int upperBound(int[] arr, int val) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= val) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    // Returns index of first element >= val
    static int lowerBound(int[] arr, int val) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < val) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}