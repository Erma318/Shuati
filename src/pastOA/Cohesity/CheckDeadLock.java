package pastOA.Cohesity;

import java.util.*;

// i --> j
// j has the resource i want
public class CheckDeadLock {
    public boolean hasDeadlock(List<List<Integer>> connections) {
        int[] indegree = new int[connections.size()];
        for (List<Integer> list : connections) {
            for (int in : list) {
                indegree[in]++;
            }
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int out = queue.poll();
            count++;
            List<Integer> list  = connections.get(out);
            for (int in : list) {
                if (--indegree[in] == 0) {
                    queue.offer(in);
                }
            }
        }
        return count != connections.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        List<Integer> three = new ArrayList<>();
        List<Integer> four = new ArrayList<>();
//        zero.add(1);zero.add(2);zero.add(3);
//        one.add(2);one.add(3);
//        two.add(3);
       zero.add(1); one.add(2); two.add(3);two.add(4);three.add(4);four.add(0);
        connections.add(zero);connections.add(one);connections.add(two);connections.add(three);
        connections.add(four);
        CheckDeadLock here = new CheckDeadLock();
        System.out.println(here.hasDeadlock(connections));
    }
}
