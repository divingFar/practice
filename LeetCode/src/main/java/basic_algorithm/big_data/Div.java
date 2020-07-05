package basic_algorithm.big_data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Div {
    static int t = 0;
    //从高位往低位除
    public static List<Integer> div(List<Integer> A,int B)
    {
        for(int i = A.size() - 1;i >= 0 ;i--)
        {
            t = t * 10 + A.get(i);
            A.set(i, t / B);
            t %= B;
        }
        while(A.size() > 1 && A.get(A.size() - 1) == 0) A.remove(A.size() - 1);
        return A;
    }
    public static void main(String[] args) {
        //传进一个字符串，一个数字
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        int B = scan.nextInt();

        List<Integer> A = new ArrayList<Integer>();
        for (int i = a.length() - 1; i >= 0; i -- ) A.add(a.charAt(i) - '0');
        List<Integer> C = div(A, B);
        //若该数为负数

        for (int i = C.size() - 1; i >= 0; i -- ) System.out.print((C.get(i)));
        System.out.println();
        System.out.println(t);
    }
}

/*
作者：小呆呆
        链接：https://www.acwing.com/solution/acwing/content/5483/
        来源：AcWing
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
