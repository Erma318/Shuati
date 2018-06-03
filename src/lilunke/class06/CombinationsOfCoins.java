package lilunke.class06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here.
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new ArrayList<>();
        combinations(target, cur, res, 0, coins);
        return res;
    }

    private void combinations(int target, List cur, List res, int index, int[] coins) {
        if (cur.size() == coins.length) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(cur));
            }
            return;
        }

        for (int i = 0; i <= target / coins[index]; i++) {
            cur.add(i);
            combinations(target - coins[index] * i, cur, res, index + 1, coins);
            cur.remove(cur.size() - 1);
        }
//        if (index == coins[coins.length - 1]) {
//            if (target % coins[coins.length - 1] == 0) {
//                cur.add(target/ coins[coins.length - 1]);
//                res.add(new ArrayList<Integer>(cur));
//                cur.remove(cur.size() - 1);
//            }
//            return;
//        }
//        for (int i = 0; i <= target / coins[index]; i++) {
//            cur.add(i);
//            combinations(target - coins[index] * i, cur, res, index + 1, coins);
//            cur.remove(cur.size() - 1);
//        }
    }

    public static void main(String[] args) {
        CombinationsOfCoins here = new CombinationsOfCoins();
        int[] coins = {2, 1};
        List<List<Integer>> res = here.combinations(4, coins);
        System.out.println(res);
    }
}
