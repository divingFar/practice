public class mulString {
    public static void main(String[] args) {
        char a='5';
        int m=5;
        char n=(char)m;
        char b='4';
        char c= (char)((a-'0')*(b-'0'));
        c+='0';
        System.out.println(c);

        /*System.out.println(multiply("12", "5"));
        System.out.println(multiply("25", "4"));*/
    }

    public static String multiply(String num1, String num2) {
        char[] value = new char[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                value[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        // 处理进位
        int carry = 0;
        for (int i = value.length - 1; i >= 0; i--) {
            value[i] += carry;
            carry = value[i] / 10;
            value[i] %= 10;
        }
        // 处理前端的 0
        int beginIndex = 0;
        while (beginIndex < value.length - 1 && value[beginIndex] == 0) {
            beginIndex++;
        }
        for (int i = beginIndex; i < value.length; i++) {
            value[i] += '0';
        }
        return new String(value, beginIndex, value.length - beginIndex);
    }
}
