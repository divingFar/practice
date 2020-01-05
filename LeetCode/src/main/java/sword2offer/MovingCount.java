package sword2offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hzk
 */
public class MovingCount {
   /* private static class Node {
        int first;
        int second;

        public Node(int x, int y) {
            this.second = second;
            this.first = first;
        }

        private boolean[][] visited = new boolean[55][55];
        //定义了一个四行两列的维数组,代表四个方向
        private static final int[][] DIRECTION = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int movingCount(int threshold, int rows, int cols) {
            if (rows < 1 || cols < 1) {
                return 0;
            }
            //LinkedList是Queue的实现类
            Stack<Object> objects = new Stack<>();
            Queue<Node> que = new LinkedList<>();
            visited[0][0] = true;
            que.add(new Node(0, 0));

            int res = 0;
            while (!que.isEmpty()) {
                Node popNode = que.poll();
                res++;
                for (int i = 0; i < DIRECTION.length; i++) {
                    int fx = popNode.first + DIRECTION[i][0], fy = popNode.second + DIRECTION[i][1];
                    if (fx >= 0 && fy >= 0 && fx < rows && fy < cols && getSum(fx, fy) <= threshold && !visited[fx][fy]) {
                        que.add(new Node(fx, fy));
                        visited[fx][fy] = true;
                    }
                }
            }

            return res;
        }

        private int getSum(int rows, int cols) {
            int s = 0;
            while (rows > 0) {
                s += rows % 10;
                rows /= 10;
            }
            while (cols > 0) {
                s += cols % 10;
                cols /= 10;
            }
            return s;
        }
*/

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean[][] visited = new boolean[55][55];
    private int[][] DIRECTION = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int movingCount(int threshold, int rows, int cols) {
       //这里必需对threshold进行判断，否则(0,0)会默认加入
        if (rows < 1 || cols < 1||threshold<0) {
            return 0;
        }
        Queue<Node> que = new LinkedList<Node>();
        visited[0][0] = true;
        que.add(new Node(0, 0));
        int result = 0;
        while (!que.isEmpty()) {
            Node poll = que.poll();
            if ((poll.x + poll.y) < threshold) {
                result++;
            }
            for (int i = 0; i < DIRECTION.length; i++) {
                int x = poll.x + DIRECTION[i][0], y = poll.y + DIRECTION[i][1];
                if (x >= 0 && y >= 0 && x < rows && y < cols && getSum(x, y) <= threshold && !visited[x][y]) {
                    que.add(new Node(x, y));
                    visited[x][y] = true;
                }
            }
        }
        return result;
    }

    public int getSum(int x, int y) {
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
    /* public static void main(String[] args) {
     *//*  System.out.println("这是行数"+ DIRECTION.length);
            System.out.println("这是列数"+ DIRECTION[0].length);*//*
        }*/


}
