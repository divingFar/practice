package sort;

/**
 * @author hzk
 */
public class QuickSort {
    public static int partition(int l,int r,int[] arr){
        int temp=arr[l];
        //每轮只能填2个坑，所以需要循环
        while(l<r){
            while(l<r&&arr[r]>=arr[0]){
                r--;
            }
           if(l<r){
               //temp记录左边这个数
               //右边这个数来填坑，右边的数得到了保存
               arr[l]=arr[r];
               l++;
           }
           while(l<r&&arr[l]<=arr[0]){
               l++;
           }
           if(l<r){
               arr[r]=arr[l];
               r--;
           }
           if(l==r){
               arr[l]=temp;
           }
        }
        return l;
    }
    public static void quickSort(int left,int right,int[]arr){
        if(left==right||arr.length<1){
            return ;
        }
       /* if (arr == null || left >= right || arr.length <= 1)
            return;*/
        int mid = partition(left,right,arr);
        quickSort(left, mid-1, arr);
        quickSort(mid+1, right,arr);

    }
    private static void printArr(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }


    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        quickSort(0, arr.length-1, arr);
        printArr(arr);
    }


}
