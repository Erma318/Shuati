package past.drawBridgePhone2;

public class findMinRotatedArray {
    public int finMinThree(int[] num) {
        int t = findMin(num, 0);
        System.out.println(t);
        return Math.min(findMin(num, t), num[0]);
    }
    public int findMin(int[] num , int s) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = s, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }

    public static void main(String[] args) {
        findMinRotatedArray here = new findMinRotatedArray();
        int[] input =  {1,2,3,7,8,9,4,5,6};
        System.out.println(here.finMinThree(input));
    }
}
