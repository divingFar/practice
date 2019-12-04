package swordToOffer;

import java.util.HashMap;

public class DuplicateNumber {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * 为每一位设置标志位的办法，笨办法
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length <= 0) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > length - 1) {
                return false;
            }
        }
        int[] arr = new int[length];
        for (int i = 0; i < numbers.length; i++) {
            if (arr[numbers[i]] == 0) {
                arr[numbers[i]] = 1;
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static boolean duplicate1(int numbers[], int length, int[] duplication) {
        if (length <= 0) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > length - 1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i && numbers[numbers[i]] != numbers[i]) {
                int temp = numbers[numbers[i]];
                //while循环结束numbers[i] ==numbers[numbers[i]]，恒成立
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
            }
            /**
             * 结束while说明第i位置上的数字已经等于i故停止交换，或者因为第i位的数值要去的位置已经有这个数了故
             * 不需要交换了
             *
             * while循环结束numbers[i] ==numbers[numbers[i]]
             * 如果第i位的数值要去的位置已经有这个数，并且第i位数该去的地方不是现在这个位置，
             * 它就没地方去了，他就是重复数字
             */
            if (numbers[i] != i) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }


    /*在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
    也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。*/

    public static int duplicateInArray(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > length - 1 || nums[i] < 0) {
                return -1;
            }
        }
        int left = 0, right = length - 1;
        //统计数字个数应该是大于left小于right的所有的数字
        while (left < right) {
            int flag = 0;
          int  mid = (left + right+1) >> 1;
            for (int i = 0; i <= length - 1; i++) {
                if (nums[i] >= left && nums[i] <= mid) {
                    flag++;
                }
            }
            if (flag > mid - left + 1) {
                right = mid-1;
            } else {
                left = mid ;
            }
        }
        return left;
    }


/*    int bsearch_1(int l, int r)
    {
        while (l < r)
        {
            int mid = l + r >> 1;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }*/


   /* int bsearch_2(int l, int r)
    {
        while (l < r)
        {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }
*/



    public static void main(String[] args) {
        //2,4,2,1,4
        int[] numbers = {1, 7, 5, 9, 7, 9, 5, 1, 5, 6, 7};
        int duplicate = duplicateInArray(numbers);
        System.out.println(duplicate);

    }
}