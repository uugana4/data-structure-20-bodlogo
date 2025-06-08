import java.util.*;

public class GamesOfTwoStacks {
    public static int twoStacks(int maxSum, int[] a, int[] b) {
        int sum = 0, countA = 0, countB = 0, result = 0;

        // Take as many from stack A as possible
        while (countA < a.length && sum + a[countA] <= maxSum) {
            sum += a[countA];
            countA++;
        }
        result = countA;

        // Now try to take from stack B, removing from A if needed
        while (countB < b.length) {
            sum += b[countB];
            countB++;
            while (sum > maxSum && countA > 0) {
                countA--;
                sum -= a[countA];
            }
            if (sum > maxSum) break;
            result = Math.max(result, countA + countB);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        for (int t = 0; t < g; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int maxSum = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            System.out.println(twoStacks(maxSum, a, b));
        }
        sc.close();
    }
}