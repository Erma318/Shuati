package pastOA.visaOA;

public class mA {
    public static int cal(int a, int b) {
        int x= a;
        int y = b;
        while (x != y) {
            if (x > y) {
                x = x - y;
            } else {
                y = y - x;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(cal(2437, 875));
    }
}
