import com.sun.org.apache.bcel.internal.classfile.Code;
import sun.reflect.generics.tree.Tree;

import java.util.*;




public class CodeReview {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        HashMap<String,Integer> hashmap = new HashMap<>();
        if(combo.length == 0) {
            return new String[0];
        }
        PriorityQueue<HashMap.Entry<String,Integer>> minHeap = new PriorityQueue<>(k, new Comparator<HashMap.Entry<String,Integer>>(){
                    @Override
                    public int compare(HashMap.Entry<String,Integer> a, HashMap.Entry<String,Integer> b){
                        if(a.getValue() == b.getValue()) {
                            return 0;
                        }
                        return a.getValue() < b.getValue() ? -1 : 1;
                    }
        });
        for(int i = 0; i < combo.length; i++){
            if(!hashmap.containsKey(combo[i])){
                hashmap.put(combo[i],1);
            }else{
                hashmap.put(combo[i],hashmap.get(combo[i] + 1));
            }
        }
        for(HashMap.Entry<String,Integer> entry : hashmap.entrySet()){
            if(minHeap.size() <= k){
                minHeap.offer(entry);
            }else {
                if(minHeap.peek().getValue() < entry.getValue()){
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        String[] result = new String[k];
        for(int i = k - 1; i > 0; i--){
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    public static void main (String[] args) {
        String[] input = {"a", "b","a"};
        CodeReview here = new CodeReview();
        System.out.println(here.topKFrequent(input, 1));
    }
}
