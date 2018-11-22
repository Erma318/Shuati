package pastOA.CernerOA;

import java.util.*;

public class fourSum {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 3; i++) {
            for (int j = i + 1; j < numbers.length - 2; j++) {
                int left = j + 1;
                int right = numbers.length - 1;
                while (left < right) {
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (sum < target) {
                        left++;
                        continue;
                    } else if (sum > target) {
                        right--;
                        continue;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[left]);
                        list.add(numbers[right]);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                        left++;
                        right--;
                    }
                }
            }
        }

        return new ArrayList<List<Integer>>(result);
    }

    public static void main(String[] args) {
        fourSum here = new fourSum();
        int[] input = {1, 0, -1, 0, -2, 2};
        System.out.println(here.fourSum(input, 0));
    }
}
