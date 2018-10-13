package lilunke.class02;

public class ApowerB {
    public static void main(String[] args) {
        ApowerB here = new ApowerB();
        int a = 2;
        int b = 3;
        System.out.println(here.power(a, b));
    }
    public long power(int a, int b) {
        // Write your removeCho2 here
        if (b == 0) {
            return 1;
        }
        if (a == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            long t = power(a, b / 2);
            return t * t;
        } else {
            long t = power(a, b / 2);
            return a * t * t;
        }
    }
}
