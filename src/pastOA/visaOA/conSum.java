package pastOA.visaOA;

public class conSum {
    static int consecutive(long num) {
        long count = 1;
        for (long L = 2; L * (L + 1) / 2 <= num; L++)
        {
            if((num - L * (L + 1) / 2) % L == 0)
                count++;
        }
        return (int) (count - 1);
    }

    public static void main(String[] args) {
        System.out.println(consecutive(19));
    }

}
