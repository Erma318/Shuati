package pastOA.Cohesity;

import java.util.HashSet;
import java.util.Set;

public class SuperSet {
    public int divisorsSuperset(int[] superset, int n) {
        int res = 0;
        Set<Integer> check = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int x : superset) {
            check.add(x);
        }
        for (int i = n; i >= 1; i--) {
            if (visited.contains(i)) {
                res++;
                System.out.println(i);
                continue;
            }
            Set<Integer> temp = new HashSet<>();
            if (checkDivisor(i, check)) {
                res++;
                System.out.println(i);
                visited.addAll(temp);
            }
        }
        return res;
    }

    private boolean checkDivisor(int n, Set<Integer> check) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i==0) {
                // check i and n / i
                if (!check.contains(i)) {
                    return false;
                }
                if (!check.contains(n / i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SuperSet here = new SuperSet();
        int[] superSet = {3, 2};
        System.out.println(here.divisorsSuperset(superSet, 13));
    }

}
