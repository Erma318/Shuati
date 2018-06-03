package lilunke.class07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonNumbersOfTwoSortedArrays {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < A.size() && j < B.size()) {
            if (A.get(i).equals(B.get(j))) {
                res.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CommonNumbersOfTwoSortedArrays here = new CommonNumbersOfTwoSortedArrays();
        Integer[] array = {1,1,2,3};
        List<Integer> A = Arrays.asList(array);
        Integer[] array2 = {1,2,3};
        List<Integer> B = Arrays.asList(array2);
        System.out.println(here.common(A, B));
    }
}
