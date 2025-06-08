import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        Stack<String> history = new Stack<>();
        history.push(""); // initial state

        for (int i = 0; i < Q; i++) {
            String[] parts = sc.nextLine().split(" ");
            int type = Integer.parseInt(parts[0]);
            if (type == 1) {
                sb.append(parts[1]);
                history.push(sb.toString());
            } else if (type == 2) {
                int k = Integer.parseInt(parts[1]);
                sb.delete(sb.length() - k, sb.length());
                history.push(sb.toString());
            } else if (type == 3) {
                int k = Integer.parseInt(parts[1]);
                System.out.println(sb.charAt(k - 1));
            } else if (type == 4) {
                history.pop();
                sb = new StringBuilder(history.peek());
            }
        }
        sc.close();
    }
}