package past.Houzz;

import java.util.ArrayList;
import java.util.List;

public class FindAllLargestIncreasingSubsequence {
    public int findLargestLength(int[] input) {
        int[] tails = new int[input.length]; // 0 > length is 1
        int len = 0;
        for (int x : input) {
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = x;
            if (left == len) {
                len++;
            }
        }
        return len;
    }

    public List<List<Integer>> findAll(int[] input, int len) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(0, res, temp, len, input);
        return res;
    }

    private void helper(int index, List<List<Integer>> res, List<Integer> temp, int len, int[] input) {
        if (temp.size() == len) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (index == input.length) {
            return;
        }
        for (int i = index; i < input.length; i++) {
            if (temp.size() == 0 || input[i] > temp.get(temp.size() - 1)) {
                temp.add(input[i]);
                if (input.length - i >= len - temp.size()) {
                    helper(i + 1, res, temp, len, input);
                }
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        FindAllLargestIncreasingSubsequence here = new FindAllLargestIncreasingSubsequence();
        int[] input = {1,3,5,4,7};
        int len = here.findLargestLength(input);
        System.out.println(len);
        System.out.println(here.findAll(input, len));

    }

}
