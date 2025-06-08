import java.util.*;

public class LargestRectangle {
    public static long largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int n = h.length;
        int i = 0;
        while (i < n) {
            if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                long area = h[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            long area = h[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) h[i] = sc.nextInt();
        System.out.println(largestRectangle(h));
        sc.close();
    }
}