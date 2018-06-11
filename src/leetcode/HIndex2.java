package leetcode;

public class HIndex2 {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[citations.length - 1 - mid] >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
        return left + 1;
    }
    public static void main(String[] args) {
        HIndex2 here = new HIndex2();
        int[] citations = {};
        System.out.println(here.hIndex(citations));
    }

}
