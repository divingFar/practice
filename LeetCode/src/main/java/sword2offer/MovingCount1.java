package sword2offer;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hzk
 */
public class MovingCount1 {
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private int getSum(int x, int y) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y > 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum;
    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        int x = 0, y = 0;
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        Node node = new Node(0, 0);
        Queue queue = new LinkedList<Node>();
        if (getSum(node.getX(), node.getY()) >= threshold || rows < 1 || cols < 1) {
            return 0;
        }
        queue.add(node);
        visited[0][0] = true;
        count++;
        while (!queue.isEmpty()) {
            Node poll = (Node) queue.poll();
            for (int i = 0; i < dx.length; i++) {
                x = poll.getX() + dx[i];
                y = poll.getY() + dy[i];
                int sum = getSum(x, y);
                if (x < rows && x >= 0 && y >= 0 && y < cols && sum <= threshold && !visited[x][y]) {
                    queue.add(new Node(x, y));
                    visited[x][y] = true;
                    count++;
                }
            }

        }
        return count;
    }

    public int movingCount1(int threshold, int rows, int cols) {
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];
         return 0;
    }

    public int dfs(int threshold, int x, int y, int rows, int cols, int count, boolean[][] visited) {
        Node node = new Node(x, y);
        visited[x][y] = true;
        if (getSum(node.getX(), node.getY()) >= threshold || rows < 1 || cols < 1) {
            return 0;
        }
        count++;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, 1, -1};
        for (int i = 0; i < dx.length; i++) {
            x = node.getX() + dx[i];
            y = node.getY() + dy[i];
            int sum = getSum(x, y);
            if (x < rows && x >= 0 && y >= 0 && y < cols && sum <= threshold && !visited[x][y] || !visited[x][y]) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MovingCount1 movingCount1 = new MovingCount1();
        System.out.println(movingCount1.movingCount(5, 10, 10));
    }

}
