import java.util.*;

public class CastleOnTheGrid {
    static class Point {
        int x, y, moves;
        Point(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.size();
        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if (curr.x == goalX && curr.y == goalY) {
                return curr.moves;
            }
            // Move in all 4 directions as far as possible
            for (int dir = 0; dir < 4; dir++) {
                int nx = curr.x, ny = curr.y;
                while (true) {
                    nx += dx[dir];
                    ny += dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                    if (grid.get(nx).charAt(ny) == 'X') break;
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, curr.moves + 1));
                    }
                }
            }
        }
        return -1; // unreachable
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> grid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grid.add(sc.nextLine());
        }
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int goalX = sc.nextInt();
        int goalY = sc.nextInt();
        System.out.println(minimumMoves(grid, startX, startY, goalX, goalY));
        sc.close();
    }
}