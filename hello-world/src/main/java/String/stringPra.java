package String;

public class stringPra {
    public static void main(String[] args) {
        String str="a";
        String dasb = str.concat("das");
        char[] chars = dasb.toCharArray();
        int i = 2;
        System.out.println(chars.length);
        for (;i<chars.length;i++) {
           System.out.println(chars[i]);
            
        }

    }
}
