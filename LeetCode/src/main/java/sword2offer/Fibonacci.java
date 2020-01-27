package sword2offer;

/**
 * @author hzk
 */
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if(n==1){
            return 1;
        }
        int num1=0,num2=1;
        int result=0;
        for(int i=1;i<n;i++){
           result=num1+num2;
           num1=num2;
           num2=result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.fibonacci1(3));

    }
}
