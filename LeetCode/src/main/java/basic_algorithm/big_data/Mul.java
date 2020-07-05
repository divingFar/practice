package basic_algorithm.big_data;

/*
算法分析
        此处 A 是高精度的字符串， B 是整数
        1、模拟乘法规则，从A的个位到高位与B相乘，乘得的结果放入t中，则此位的数为t % 10.把t / 10剩余给下一个高位

        2、若遍历完整个A，t > 0,则表示还有剩余的数，则需要将剩余的数继续补到下一个高位

        时间复杂度 O(n)O(n)
        参考文献
        参考y总的模版归纳：https://www.acwing.com/blog/content/277/


        Java 代码*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mul {
    public static List<Integer> mul(List<Integer> A, int B)
    {
        int t = 0;
        for(int i = 0;i < A.size();i++)
        {
            t += A.get(i) * B;
            A.set(i, t % 10);
            t /= 10;
        }
        while(t != 0)
        {
            A.add(t % 10);
            t /= 10;
        }
        return A;
    }
    public static void main(String[] args) {
        //传进一个字符串，一个数字
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        int B = scan.nextInt();

        List<Integer> A = new ArrayList<Integer>();
        for (int i = a.length() - 1; i >= 0; i -- ) A.add(a.charAt(i) - '0');
        List<Integer> C = mul(A, B);
        //若该数为负数
        for (int i = C.size() - 1; i >= 0; i -- ) System.out.print((C.get(i)));
    }
}


/*
作者：小呆呆
        链接：https://www.acwing.com/solution/acwing/content/5482/
        来源：AcWing
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
