package basic_algorithm.segments;

import java.util.*;


public class SegmentMerge{

    public static void main(String[] args) {
        List<PIIs> list = new ArrayList<PIIs>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0;i < n;i++)
        {
            int L = scan.nextInt();
            int R = scan.nextInt();
            list.add(new PIIs(L,R));
        }
        //按左端点进行排序
        Collections.sort(list);
        int count = 0;
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        for(PIIs item : list)
        {

            if(item.getFirst() > end)
            {
                count ++;
                start = item.getFirst();
                end = item.getSecond();
            }
            else
            {
                end = Math.max(end, item.getSecond());
            }
        }
        System.out.println(count);
    }

}



class PIIs implements Comparable<PIIs>{
    private int first;
    private int second;

    public int getFirst()
    {
        return this.first;
    }
    public int getSecond()
    {
        return this.second;
    }
    public PIIs(int first,int second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(PIIs o) {
        // TODO 自动生成的方法存根
        return Integer.compare(first, o.first);
    }
}

/*
作者：小呆呆
        链接：https://www.acwing.com/solution/AcWing/content/5889/
        来源：AcWing
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
