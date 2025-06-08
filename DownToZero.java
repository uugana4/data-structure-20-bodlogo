import java.util.*;

public class DownToZero {
    public static int downToZero(int n) {
        if (n == 0) return 0;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        dist[n] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == 0) return dist[0];

            // Step 1: Subtract 1
            if (dist[curr - 1] == -1) {
                dist[curr - 1] = dist[curr] + 1;
                queue.add(curr - 1);
            }

            // Step 2: Replace with max factor less than curr
            for (int i = 2; i * i <= curr; i++) {
                if (curr % i == 0) {
                    int next = Math.max(i, curr / i);
                    if (dist[next] == -1) {
                        dist[next] = dist[curr] + 1;
                        queue.add(next);
                    }
                }
            }
        }
        return dist[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            System.out.println(downToZero(n));
        }
        sc.close();
    }
}