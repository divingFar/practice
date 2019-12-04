package io.file;

import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        /*File file = new File("D:\\sourceCodeOfLab\\document");
        System.out.println("文件的绝对路径"+file.getAbsolutePath());
        System.out.println("文件的名称"+file.getName());
        File f = new File("b.txt");
        System.out.println(f.getAbsolutePath()); 
        System.out.println("file是否存在"+file.exists());
        System.out.println("file的类型"+file.isDirectory());
        System.out.println("f的类型"+f.isDirectory());
        System.out.println("是否创建f"+f.createNewFile());
        File heihei = new File("heihei");
        System.out.println(heihei.getAbsolutePath());
       // heihei.mkdir();
        System.out.println(heihei.exists());
        heihei.delete();*/
        System.out.println(getFactorial(5)); 

    }
    public static int getFactorial(int n){
        if(n!=1){
            return n*getFactorial(n-1);
        }else {
            return 1;
        }

    }
}
