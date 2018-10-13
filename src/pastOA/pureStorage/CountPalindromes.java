package pastOA.pureStorage;

public class CountPalindromes {
    public int count(String in) {
        int count = 0;
        for (int i = 0; i < in.length(); i++) {
            count += helper(in, i, i);
            if (i <= in.length() - 2 && in.charAt(i) == in.charAt(i + 1)) {
                count += helper(in, i, i + 1);
            }
        }
        return count;
    }

    private int helper(String in, int i, int j) {
        int count = 0;
        int l = i;
        int r = j;
        while (l >= 0 && r <= in.length() - 1 && in.charAt(l) == in.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountPalindromes here = new CountPalindromes();
        System.out.println(here.count("wowpurerocks"));
    }
}
