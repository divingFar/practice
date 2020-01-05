## 深度优先搜索

优缺点
容易爆栈 如果树有1e4层，就爆了
空间和深度成正比，相对较小
不能搜最短、最小

```java
private void dfs(Graph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
        if (!marked[w]) {
            dfs(G, w);
        }
    }
}
```
```java
dfs()//参数用来表示状态  
{  
    if(到达终点状态)  
    {  
        ...//根据题意添加  
        return;  
    }  
    if(越界或者是不合法状态)  
        return;  
    if(特殊状态)//剪枝
        return ;
    标记；  //可能在这儿标记
    for(扩展方式)  
    {  
        if(扩展方式所达到状态合法)  
        {  
            修改操作;//根据题意来添加  
         标记//可能在这儿标记
            dfs（）；  
            (还原标记)；  
            //是否还原标记根据题意  
            //如果加上（还原标记）就是回溯法  
        }  
    }  
}
```

例题：矩阵在中的路径：https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

代码

```java
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
```

##  广度优先搜索

优缺点
空间是指数级别的大！！！**
不会有爆栈的风险
可以搜最短，最小
代码模板

```java
/**
 *
 * @param G
 * @param s 图的顶点
 */
public void bfs(Graph G, int s) {
    Queue<Integer> queue = new Queue<Integer>();
    marked[s] = true;
    queue.enqueue(s);
    while (!queue.isEmpty()) {
        int v = queue.dequeue();
        for (int w : G.adj(v)) {
            if (!marked[v]) {
                marked[w] = true;
                queue.enqueue(w);
            }
        }
    }
}
```

## 位运算

- m<<n 表示把m左移n位，m>>n表示将m右移n位
- 左移左边n位丢弃，右边补0
- 右移，若为正数，最左边补n个0，若为负数，右移之后在左边补n个1。

- 把一个二进制整数减去1，将把最右边的1变成0，若有0则会把变成1
- 把一个二进制整数减去1，在和原整数做与运算，会把该整数最右边的1变成0

- 可以用与运算符来判奇偶

##  面试tips

如果面试题是关于n位的整数，并且没有限定n的取值范围，或者输入任意大小的整数，那么这道题很有可能考虑大数的问题，字符串是一种简单有效的表示大数的方法。

