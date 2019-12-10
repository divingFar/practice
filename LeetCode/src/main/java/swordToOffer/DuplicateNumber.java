package swordToOffer;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        int left = 1, right = length - 1;
        //统计数字个数应该是大于left小于right的所有的数字
        while (left < right) {
            int flag = 0;
            int mid = left + right >> 1;
            for (int i = 0; i <= length - 1; i++) {
                if (nums[i] >= left && nums[i] <= mid) {
                    //flag代表介于left和mid之间的数字的个数
                    flag++;
                }
            }
            //mid-left+1代表左半区的位置数
            if (flag > mid - left + 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 二分查找练习
     *
     * @param nums
     * @param k
     * @return
     */
    public static int binSearch(int[] nums, int k) {
        int length = nums.length - 1;
        int left = 0;
        int right = length;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] > k) {
                right = mid - 1;
            } else if (nums[mid] < k) {
                left = mid + 1;
            } else {
                return nums[mid];
            }
        }
        return -1;
    }

    /**
     * 二维数组的查找，从右上角开始，每次排除一行或一列
     *
     * @param array
     * @param target
     * @return
     */
    public boolean searchArray(int[][] array, int target) {
        int i = 0, j = array.length - 1;
        while (i <= array.length - 1 && j >= 0) {
            if (array[i][j] == target) {
                return true;
            }
            if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * 练习正则边查找边替换
     */
    private static Pattern pattern = Pattern.compile("\\s+");

    public static String replaceSpace(StringBuffer str) {

        if (str.toString().indexOf(" ") == -1) {
            return str.toString();
        }
        StringBuffer sb = new StringBuffer();
        Matcher matcher = pattern.matcher(str.toString());
        while (matcher.find()) {
            matcher.appendReplacement(sb, "20%");
        }
        matcher.appendTail(sb);

        return sb.toString();

    }

    public static String replaceSpace1(StringBuffer str) {
        int spaceCount=0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        if(spaceCount==0){
            return str.toString();
        }
        int p1 = str.length() - 1;
        /**
         * 英文原来的空格也占用了一个位置,所以只需要乘以2就好
         */
        int p2 = p1 + spaceCount *2 ;
        str.setLength(p2+1);
        while (p1!=p2) {
            if (str.charAt(p1)!=' ') {
                str.setCharAt(p2, str.charAt(p1));
                p1--;
                p2--;
            }else{
                str.setCharAt(p2,'0');
                str.setCharAt(--p2,'2');
                str.setCharAt(--p2,'%');
                p1--;
                p2--;
            }
        }
        return str.toString();
    }



    public static void main(String[] args) {
        //2,4,2,1,4
      /*  int[] numbers = {1, 3, 5, 7, 9, 11};
        int duplicate = duplicateInArray(numbers);
        System.out.println(binSearch(numbers, 4));*/
      /*  int[]  nums={1,2,3,4};
        int  left=1;
        int right =4;
        int mid=left+right+1>>1;
        int mid1=left+right>>1;
        System.out.println(mid);
        System.out.println(mid1);*/
        String string = "hello world happy";
        StringBuffer str = new StringBuffer();
        str.append(string);
        System.out.println(replaceSpace1(str));

    }
}