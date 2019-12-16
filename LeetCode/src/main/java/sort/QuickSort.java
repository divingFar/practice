package sort;

/**
 * @author hzk
 */
public class QuickSort {
    void quick_sort(int[]s, int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, temp = s[l];
            // 从右向左找第一个小于x的数
            while (i < j) {
                while (i < j && s[j] >= temp)
                {
                    j--;
                }
                if (i < j) {
                    s[i++] = s[j];
                }
                // 从左向右找第一个大于等于x的数
                while (i < j && s[i] < temp)
                {
                    i++;
                }
                if (i < j) {
                    s[j--] = s[i];
                }
            }
            s[i] = temp;
            // 递归调用
            quick_sort(s, l, i - 1);
            quick_sort(s, i + 1, r);
        }
    }

    public static int partition(int l, int r, int[] arr) {
        int temp = arr[l];
        //每轮只能填2个坑，所以需要循环
        while (l < r) {
            while (l < r && arr[r] >= temp) {
                r--;
            }
            if (l < r) {
                //temp记录左边这个数
                //右边这个数来填坑，右边的数得到了保存
                arr[l++] = arr[r];
            }
            //注意这里不是用arr[0]来判定，arr是相对的，只能用每个相对数组的'0'位置
            while (l < r && arr[l] <= temp) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
            if (l == r) {
                arr[l] = temp;
            }
        }
        System.out.println("left    "+  l);
        System.out.println("right    "+  r);
        return l;
    }

    public static void quickSort(int left, int right, int[] arr) {
        /*if(left==right){
            return ;
        }
        int mid = partition(left,right,arr);
        //由于快结束的时候left==right=mid了在让right=mid-1，递归永远没有出口，所以不能用==作为递归出口
        quickSort(left, mid-1, arr);
        quickSort(mid+1, right,arr);*/
        if (left < right) {
            int mid = partition(left, right, arr);
            quickSort(left, mid - 1, arr);
            quickSort(mid + 1, right, arr);
        }
    }

    private static void printArr(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }


    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        quickSort(0, arr.length - 1, arr);
        printArr(arr);
    }


}
