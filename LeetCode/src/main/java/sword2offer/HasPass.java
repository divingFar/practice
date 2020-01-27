package sword2offer;

/**
 * @author hzk
 */
public class HasPass {

    /*class Solution {
        public:
          bool hasPath(vector<vector<char>>& matrix, string str) {
              for (int i = 0; i < matrix.size(); i ++ )
                  for (int j = 0; j < matrix[i].size(); j ++ )
                      if (dfs(matrix, str, 0, i, j))
                          return true;
              return false;
          }

          bool dfs(vector<vector<char>> &matrix, string &str, int u, int x, int y) {
              if (matrix[x][y] != str[u]) return false;
              if (u == str.size() - 1) return true;
              int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};
              char t = matrix[x][y];
              matrix[x][y] = '*';
              for (int i = 0; i < 4; i ++ ) {
                  int a = x + dx[i], b = y + dy[i];
                  if (a >= 0 && a < matrix.size() && b >= 0 && b < matrix[a].size()) {
                      if (dfs(matrix, str, u + 1, a, b)) return true;
                  }
              }
              matrix[x][y] = t;
              return false;
          }
      };
  */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(matrix, str, 0, i, j, rows, cols)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param matrix
     * @param str    目标字符串
     * @param u      目标字符下标
     * @param x      代表所在行
     * @param y      代表所在列
     * @return
     */
    public boolean dfs(char[] matrix, char[] str, int u, int x, int y, int rows, int cols) {
        if (matrix[x * cols + y] != str[u]) {
            return false;
        }
        System.out.println(u);
        if (u == str.length - 1) {
            return true;
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        char t = matrix[x * cols + y];
        matrix[x * cols + y] = '*';
        for (int i = 0; i < dx.length; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < rows && b >= 0 && b < cols) {
                if (dfs(matrix, str, u + 1, a, b, rows, cols)) {
                    return true;
                }
            }
        }
        //四个方向中的一个走通了，继续走的时候又不通了，需要回退，所以刚才走通这个格子不能走，因为回退了所以需要还原
        matrix[x * cols + y] = t;
        return false;
    }

    public static void main(String[] args) {
        HasPass s = new HasPass();
        char[]matrix={'a','b','t','g','c','f','c','s','j','c','e','h'};
        String str1="bfcj";
        char[] str = str1.toCharArray();
        System.out.println(s.hasPath(matrix,3,4,str));
    }

}
