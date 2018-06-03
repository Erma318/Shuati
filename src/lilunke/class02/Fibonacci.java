package lilunke.class02;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci here = new Fibonacci();
        System.out.println(here.fibonacci(6));
    }
    public long fibonacci(int K) {
        long a = 0;
        long b = 1;
        if (K <= 0) {
            return a;
        }
        while (K > 1) {
            long temp = a + b;
            a = b;
            b = temp;
            K--;
        }
        return b;
    }


//    public long fibonacci(int K) {
//        // Write your solution here
//        if (K < 0) {
//            return 0;
//        }
//        if (K == 0) {
//            return 0;
//        }
//        if (K == 1) {
//            return 1;
//        }
//        long a = 0;
//        long b = 1;
//        long t = 0;
//        for (int i = 2; i <= K; i++) {
//            t = a + b;
//            a = b;
//            b = t;
//        }
//        return t;
//    }
}
