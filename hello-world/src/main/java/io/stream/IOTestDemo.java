package io.stream;

import java.io.*;

public class IOTestDemo {
    public static void main (String[] args) throws IOException {

        test();
    }
    public static void test(){
        long start=System.currentTimeMillis();
        //try 后面跟小括号可以自动释放资源
        try(
              BufferedInputStream bIS = new BufferedInputStream(new FileInputStream("D:\\sourceCodeOfLab\\test1\\picture.jpg"));
              BufferedOutputStream bOS = new BufferedOutputStream(new FileOutputStream("D:\\sourceCodeOfLab\\test2\\test_copy.jpg"));){
            int len;
            byte[] bytes = new byte[1024];
            while ((len=bIS.read(bytes))!=-1){
                System.out.println(bytes[0]);
                bOS.write(bytes,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println("运行时间"+(end-start));
    }
}
