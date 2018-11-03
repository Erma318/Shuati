import java.util.*;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CodeReview {
    public static int schedule(int[] sql, int cool) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int rest = 0;
        for(int i = 0; i < sql.length; i++){
            if(q.size() > cool + 1){
                set.remove(q.poll());
            }
            if(!set.contains(sql[i])){
                q.offer(sql[i]);//1 2
                set.add(sql[i]);//1 2
            }
            else{
                while(!q.isEmpty()){
                    int s = q.poll();//1
                    set.remove(s);
                    if(s == sql[i]){
                        rest += cool - q.size();//1
                        q.offer(s);
                        set.add(s);
                        break;
                    }
                }
            }
        }
        return rest + sql.length;
    }
    //Scheduler：1, 2, _, 1, _, _, 1, 3, 4，
    public static void main(String[] args) {
        int[] sql = new int[]{1, 2, 1, 1, 3, 1, 4};
        System.out.print(schedule(sql,2));
    }
}
