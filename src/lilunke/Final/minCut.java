package lilunke.Final;

public class minCut {
    private int maxSquare(int number) {
        int i = 1;
        while (true) {
            int temp = i * i;
            if (temp > number) {
                break;
            }
            i++;
        }
        return i - 1;
    }

    public int minCut(int number) {
        int[] res = new int[number + 1];
        res[0] = 0;
        for (int i = 1; i <= number; i++) {
            int max = maxSquare(i);
            //System.out.println(max);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= max; j++) {
                int temp = j * j;
                min = Math.min(min, res[number - temp] + 1);
            }
            res[i] = min;
        }
        return res[number];
    }
    public static void main(String[] args) {
        minCut here = new minCut();
        System.out.println(here.minCut(4));
    }

}
