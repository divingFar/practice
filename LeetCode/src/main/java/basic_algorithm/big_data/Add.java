package basic_algorithm.big_data;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class Add{
    public static InputReader in = new InputReader(System.in);
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    // static  int  N = 1000010;
    public static ArrayList<Integer> add(ArrayList<Integer>A,ArrayList<Integer>B){
        if (A.size()<B.size()) return add(B,A);
        ArrayList<Integer> C=new ArrayList<>();
        int t = 0;
        for (int i = 0; i < A.size(); i ++ )
        {
            t += A.get(i);
            if (i < B.size()) t += B.get(i);
            C.add(t % 10);
            t /= 10;
        }

        if (t!=0) C.add(t);
        return C;
    }
    public static void main(String[] args) throws Exception {
        String a = null, b=null;
        ArrayList<Integer> A=new ArrayList<>();
        ArrayList<Integer> B=new ArrayList<>();
        while(in.hasNext()) {
            a=in.next();
            b=in.next();
            out.flush();//写在最后
        }

        for (int i = a.length() - 1; i >= 0; i -- ) A.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i -- ) B.add(b.charAt(i) - '0');

        ArrayList<Integer> C = add(A, B);

        for (int i = C.size() - 1; i >= 0; i -- ) out.print(C.get(i));
        out.println();
        out.close();
    }
}
class InputReader{
    private final static int BUF_SZ = 65536;
    BufferedReader in;
    StringTokenizer st;
    public InputReader(InputStream in) {
        super();
        this.in = new BufferedReader(new InputStreamReader(in),BUF_SZ);
        st = new StringTokenizer("");
    }
    public boolean hasNext() throws IOException {
        while(!st.hasMoreTokens()){
            String line = nextLine();
            if(line == null){
                return false;
            }
            st = new StringTokenizer(line);
        }
        return true;
    }
    public String next()  throws IOException{
        while (!st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(in.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    public double nextLong() throws IOException {
        return Long.parseLong(next());
    }
    public String nextLine() throws IOException {
        String line = "";
        line = in.readLine();
        return line;
    }
}

/*
作者：小纸条o--o
        链接：https://www.acwing.com/solution/acwing/content/2128/
        来源：AcWing
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
