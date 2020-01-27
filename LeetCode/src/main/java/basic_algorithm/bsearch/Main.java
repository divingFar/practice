package basic_algorithm.bsearch;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//数组大小
        int count = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        //查询count轮
        while (count-- != 0) {
            int target = in.nextInt();//本轮查询的目标值
            int l = 0, r = n - 1;
            //查找目标左边界
            while (l < r) {
                int mid = l + r >> 1;
                if (arr[mid] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } //跳出循环时，l==r,如果数组不存在target
            if (arr[l] != target) {
                System.out.println("-1 -1");
            } else {
                System.out.print(l + " ");
                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + r+1 >> 1;
                    if (arr[mid] <= target) {
                        l = mid;
                    } else {
                        r = mid -1;
                    }
                }
                System.out.println(r);
            }

        }
    }

}