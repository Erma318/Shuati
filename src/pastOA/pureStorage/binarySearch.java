package pastOA.pureStorage;

public class binarySearch {
    public int serach(int [] e, int target) {
        if (e == null || e.length <= 0) return -1;
        int left = 0, right = e.length - 1;
        while (left < right) {
            int middle = (left + right + 1) / 2;
            if (e[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (e[right] == target) return right;
        return -1;
    }

    public static void main(String[] args) {
        binarySearch here = new binarySearch();
        int[] e = {0,1,2,3,4};
        System.out.println(here.serach(e, 2));
        System.out.println("5");
        System.out.println("0 1 2 3 4");
        System.out.println("2");
    }
}
