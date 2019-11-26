package string;


/**
 * @author hzk
 */
public class StringPra {
    public static void main(String[] args) {
        StringPra stringPra = new StringPra();
        String num1 = "9133";
        String num2 = "0";

        System.out.println(stringPra.multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        } else if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        } else {
            String[] c = str(num1, num2);
            StringBuffer sb = new StringBuffer();
            int i = 0;
            int j = 0;
            while (i < c.length - 1) {
                sb.append(add(c[i], c[i + 1]));
                c[i + 1] = sb.toString();
                i++;
                sb.delete(0, sb.length());
            }
            return c[i];
        }


    }


    public static String[] str(String num1, String num2) {
        //第二个数的位数，对应会有多少个数相加
        String[] a = new String[num2.length()];
        //给a[i]赋值
        int k = num2.length() - 1;
        for (int j = 0; j < num2.length(); j++) {
            a[j] = mul(num1, num2.charAt(k--));
        }
        String b[] = new String[num2.length()];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {

            sb.insert(0, a[i]);
            int j = i;
            while (j > 0) {
                sb.append("0");
                j--;
            }
            b[i] = sb.toString();
            sb.delete(0, sb.length());
        }
        return b;

    }

    public static String mul(String a, char b) {
        int carry = 0, i = a.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || carry != 0) {
            //两个数字相乘的结果
            int temp = 0;
            if (i >= 0) {
                temp = (a.charAt(i--) - '0') * (b - '0');
            }
            int c = (temp + carry) % 10;
            sb.append(c);
            carry = (temp + carry) / 10;
        }
        return sb.reverse().toString();
    }

    public static String add(String num1, String num2) {
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

}
