import java.util.*;

public class GraphComponents {
    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            size[py] += size[px];
            parent[px] = py;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of edges
        int maxNodes = 2 * n + 1; // nodes are 1-indexed, up to 2*n
        parent = new int[maxNodes];
        size = new int[maxNodes];
        for (int i = 1; i < maxNodes; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            union(u, v);
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < maxNodes; i++) {
            if (parent[i] == i && size[i] > 1) {
                min = Math.min(min, size[i]);
                max = Math.max(max, size[i]);
            }
        }
        System.out.println(min + " " + max);
        sc.close();
    }
}