package syntaxTest;

public class NegativeToPositive {
    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        int b = a & 0x7fffffff;
        System.out.println(a);
        System.out.println(b);
        System.out.println(Math.abs(a));
    }
}
