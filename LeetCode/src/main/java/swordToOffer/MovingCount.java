package swordToOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hzk
 */
public class MovingCount {
    private static class Node {
        int first;
        int second;

        public Node(int x, int y) {
            this.second = second;
            this.first = first;
        }

        private boolean[][] visited = new boolean[55][55]
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

        public static void main(String[] args) {
            System.out.println("这是行数"+ DIRECTION.length);
            System.out.println("这是列数"+ DIRECTION[0].length);
        }

    }
}
