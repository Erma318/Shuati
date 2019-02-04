package google;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public class SnapShotArray {
    int capacity;
    int[] array;
    TreeMap<Integer, int[]> verOper;
    //               记录某个操作的index
    TreeMap<Integer, int[]> verSnapShot;
    //              记录整个数组
    final int interval;
    int verCounter;

    public SnapShotArray(int capacity, int interval){
        this.capacity = capacity;
        array = new int[capacity];
        verOper = new TreeMap<>(Collections.reverseOrder());
        verSnapShot = new TreeMap<>(Collections.reverseOrder());
        this.interval = interval;
        verCounter = 0;
    }

    public void set(int idx, int val){
        // save operation in the map
        verOper.put(verCounter++, new int[]{idx, val});
        array[idx] = val;
        if (verCounter % interval == 0){
            verSnapShot.put(verCounter, array);
        }
    }

    public int createSnapShot(){
        verSnapShot.put(verCounter, array);
        return verCounter;
    }

    public int getNumByVersion(int version, int idx){

        // use bs to search nearest previous snapshot and next snapShot
        // use verOper to recover this number
        int fir = verSnapShot.floorKey(version);
        int snapNum = verSnapShot.get(version)[idx];

        NavigableMap<Integer, int[]> operation = verOper.subMap(fir, true, version, true);
        for (int[] operEle : operation.values()){
            if (operEle[0] == idx){
                snapNum = operEle[1];
            }
        }
        return snapNum;
    }
    public static void main(String[] Ags) {

        SnapShotArray sol = new SnapShotArray(10,10);
        sol.getNumByVersion(34,3);
        sol.getNumByVersion(4,5);
        //  System.out.print(res);
    }
}
