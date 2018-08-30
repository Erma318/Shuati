package drawBridge;

public class SumConsecutiveNumber {
    // Utility method to compute number of ways
    // in which N can be represented as sum of
    // consecutive number
    static int countConsecutive(int N)
    {
        // constraint on values of L gives us the
        // time Complexity as O(N^0.5)
        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * N; L++)
        {
            float a = (float) ((1.0 * N-(L * (L + 1)) / 2) / (L + 1));
            if (a-(int)a == 0.0)
                count++;
        }
        return count;
    }

    // Driver code to test above function
    public static void main(String[] args) {
        int N = 15;
        System.out.println(countConsecutive(N));
        N = 10;
        System.out.println(countConsecutive(N));
    }
}
