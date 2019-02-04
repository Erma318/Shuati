package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *  Array的作用： capture next version Value of certain index
 *  Map<Integer, versionList<Integer>> invert
 *  Map<index,   versionList<value>> invert
 *               List的index == version number
 *               List存储该index的历史变化过程
 *  Lazy update principle: use next version set operation as trigger to generate update operation.
 *  永远在next version set操作的时候做所有跟新:
 *  1: 如果是第一次nextversion的set操作 需要把之前的所有versions都persist到map的versionlist里面。
 *  2: 如果是nextversion之后的多次set操作 只需要用array as tail listnode去capture所有set变化 to prepare            * for next time version persist.
 *
 **/

public class SnapShotArrayII {

    int[] array;
    Map<Integer, List<Integer>> invert = new HashMap<>();
    //index, List<value> List的index == version number
    int version = -1;

    public SnapShotArrayII(int n) {
        array = new int[n];
    }

    // amortize O(1)
    public void set(int index, int value) {
        //case 0
        if (version == -1) {
            array[index] = value;
            return;
        }
        //从没被改过
        if (!invert.containsKey(index)) {
            invert.put(index, new ArrayList<>());
        }

        Integer lastModifyVersion = -1;
        List<Integer> versionList = invert.get(index);
        if (versionList.size() > 0) {
            lastModifyVersion = versionList.size() - 1;
        }

        //case 1: version之间的不断多次set
        //case 2: 需要从lastversion跟新至当前version 的old value
        lastModifyVersion++;
        while (lastModifyVersion <= version) {
            //use while loop to create a series of buckets for later fast retrieval of certain version
            versionList.add(array[index]);
            lastModifyVersion++;
        }
        array[index] = value;
    }

    // Runtime: 1
    public int get(int index) {
        return array[index];
    }

    // Runtime: 1
    public int takeSnapshot() {
        version++;
        return version;
    }

    // Runtime: 1
    public int getFromSnapshot(int index, int version) {
        if (version > this.version) {
            return -1;
        }
        //case 1 : never modified
        if (invert.get(index) == null) {
            return array[index];
        }
        //case 2 : modefied but ask for a 最后一版本更靠后的版本
        List<Integer> versionList = invert.get(index);
        Integer lastModifyVersion = versionList.size() - 1;
        if (version > lastModifyVersion)
            return array[index];

        //case 3 :  某个version的版本
        return versionList.get(version);
    }

    public static void main(String[] Ags) {

        SnapShotArrayII sol = new SnapShotArrayII(3);
        sol.set(0, 2);
        sol.takeSnapshot();//0
        sol.set(0, 4);
        sol.set(2, 1);
        sol.takeSnapshot();//1
        System.out.println("idx0" + "ver0" + " " + sol.getFromSnapshot(0, 0));
        System.out.println("idx0" + "ver1" + " " + sol.getFromSnapshot(0, 1));
        System.out.println("idx0" + "ver2" + " " + sol.getFromSnapshot(0, 2));
        System.out.println("idx1" + "ver0" + " " + sol.getFromSnapshot(1, 0));
        System.out.println("idx1" + "ver1" + " " + sol.getFromSnapshot(1, 1));
        System.out.println("idx1" + "ver2" + " " + sol.getFromSnapshot(1, 2));
        System.out.println("idx2" + "ver0" + " " + sol.getFromSnapshot(2, 0));
        System.out.println("idx2" + "ver1" + " " + sol.getFromSnapshot(2, 1));
        System.out.println("idx2" + "ver2" + " " + sol.getFromSnapshot(2, 2));
        System.out.println();
        sol.set(1, 7);
        System.out.println("idx" + "1" + " " + sol.get(1));
        sol.set(1, 9);
        System.out.println("idx" + "1" + " " + sol.get(1));
        sol.set(2, 10);
        sol.takeSnapshot();//2
        System.out.println("idx0" + "ver0" + " " + sol.getFromSnapshot(0, 0));
        System.out.println("idx0" + "ver1" + " " + sol.getFromSnapshot(0, 1));
        System.out.println("idx0" + "ver2" + " " + sol.getFromSnapshot(0, 2));
        System.out.println("idx1" + "ver0" + " " + sol.getFromSnapshot(1, 0));
        System.out.println("idx1" + "ver1" + " " + sol.getFromSnapshot(1, 1));
        System.out.println("idx1" + "ver2" + " " + sol.getFromSnapshot(1, 2));
        System.out.println("idx2" + "ver0" + " " + sol.getFromSnapshot(2, 0));
        System.out.println("idx2" + "ver1" + " " + sol.getFromSnapshot(2, 1));
        System.out.println("idx2" + "ver2" + " " + sol.getFromSnapshot(2, 2));
        System.out.println(sol.takeSnapshot());//3
        System.out.println(sol.takeSnapshot());//4
        sol.set(2, 40);
        sol.set(2, 50);
        System.out.println(sol.takeSnapshot());//5
        sol.set(0, 100);
        System.out.println(sol.takeSnapshot());//6
        System.out.println();
        System.out.println();
        System.out.println("idx0" + "ver0" + " " + sol.getFromSnapshot(0, 0));
        System.out.println("idx0" + "ver1" + " " + sol.getFromSnapshot(0, 1));
        System.out.println("idx0" + "ver2" + " " + sol.getFromSnapshot(0, 2));
        System.out.println("idx0" + "ver2" + " " + sol.getFromSnapshot(0, 3));
        System.out.println("idx0" + "ver2" + " " + sol.getFromSnapshot(0, 4));
        System.out.println("idx0" + "ver2" + " " + sol.getFromSnapshot(0, 5));
        System.out.println("idx0" + "ver2" + " " + sol.getFromSnapshot(0, 6));
        System.out.println("idx1" + "ver0" + " " + sol.getFromSnapshot(1, 0));
        System.out.println("idx1" + "ver1" + " " + sol.getFromSnapshot(1, 1));
        System.out.println("idx1" + "ver2" + " " + sol.getFromSnapshot(1, 2));
        System.out.println("idx1" + "ver0" + " " + sol.getFromSnapshot(1, 3));
        System.out.println("idx1" + "ver1" + " " + sol.getFromSnapshot(1, 4));
        System.out.println("idx1" + "ver2" + " " + sol.getFromSnapshot(1, 5));
        System.out.println("idx0" + "ver2" + " " + sol.getFromSnapshot(1, 6));
        System.out.println("idx2" + "ver0" + " " + sol.getFromSnapshot(2, 0));
        System.out.println("idx2" + "ver1" + " " + sol.getFromSnapshot(2, 1));
        System.out.println("idx2" + "ver2" + " " + sol.getFromSnapshot(2, 2));
        System.out.println("idx2" + "ver0" + " " + sol.getFromSnapshot(2, 3));
        System.out.println("idx2" + "ver1" + " " + sol.getFromSnapshot(2, 4));
        System.out.println("idx2" + "ver2" + " " + sol.getFromSnapshot(2, 5));
        System.out.println("idx0" + "ver2" + " " + sol.getFromSnapshot(2, 6));
    }
}
