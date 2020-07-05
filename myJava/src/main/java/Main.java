import java.io.*;
import java.util.*;

public class Main {
    static int N = 300;
    static int[][] f = new int[N][N];
    static int[][] h = new int[N][N];
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static int n;
    static int m;

    public static void main(String[] args) {// 12
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                h[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], -1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        System.out.println(res);
    }

    static int dfs(int x, int y) {
        if (f[x][y] != -1) {
            return f[x][y];
        }
        f[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b > 0 && b < m && h[a][b] < h[x][y]) {
                f[x][y] = Math.max(f[x][y], f[a][b] + 1);
            }
        }
        return f[x][y];
    }
}