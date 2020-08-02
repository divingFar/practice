import java.io.*;
import java.security.PublicKey;
import java.util.*;

public class Main {
    static int N = 10000;
    static int[] h = new int[N];
    static int idx = 0;
    static int[] ne = new int[N];
    static int[] e = new int[N];


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] w = new int[n];
        int[] s = new int[n];
        int[] v = new int[n];


    }

    public static void add(int a, int b) {
        e[idx] = h[a];
    }


//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        Segment[] seg = new Segment[n];
//        int max = 0;
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            int start = scan.nextInt();
//            int end = scan.nextInt();
//            seg[i] = new Segment(start,end);
//            set.add(start);
//            set.add(end);
//            max = Math.max(end, max);
//        }
//
//       // List<Integer> list = new ArrayList<>();
//        int ans = 0;
//        for (Integer i : set) {
//            int res = 0;
//            for (int j = 0; j < seg.length; j++) {
//                if(seg[j].start <= (i +0.1) && seg[j].end >= (i + 0.1)) {
//                    res++;
//                }
//            }
//            ans = Math.max(ans, res);
//        }
//
////        for(int i = 1; i <= max; i++) {
////            int res = 0;
////            for (int j = 0; j < seg.length; j++) {
////                if(seg[j].start <= (i +0.1) && seg[j].end >= (i + 0.1)) {
////                    res++;
////                }
////            }
////            ans = Math.max(ans, res);
////        }
//        System.out.println(ans);
//
//
//    }
//
//    static class Segment {
//     int start;
//        int end;
//
//        public Segment(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//    }


}



