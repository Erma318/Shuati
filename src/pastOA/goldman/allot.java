package pastOA.goldman;

import java.util.*;

public class allot {
    static class Student {
        int id;
        int grade;

        Student(int id, int grade) {
            this.id = id;
            this.grade = grade;
        }
    }
    // Complete the allocateSchools function below.
    static List<Integer> allocateSchools(List<Integer> schoolSeatsArray, List<Integer> studentScoreArray, List<List<Integer>> studentSchoolPreferencesArray) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.grade - o1.grade;
            }
        });
        int gid = 0;
        for (int g : studentScoreArray) {
            Student std = new Student(gid, g);
            gid++;
            pq.offer(std);
        }

        // 分配
        int unsigned = 0;
        while (!pq.isEmpty()) {
            Student curStd = pq.poll();
            List<Integer> preference = studentSchoolPreferencesArray.get(curStd.id);
            for (int i = 0; i < preference.size(); i++) {
                int sid = preference.get(i);
                if (schoolSeatsArray.get(sid) > 0) {
                    int t = schoolSeatsArray.get(sid) - 1;
                    schoolSeatsArray.set(sid, t);
                    break;
                }

                if (i == preference.size() - 1) unsigned++; // 最后一个意向没有满足(break)
            }
        }

        // unfilled seats
        int unfilled = 0;
        for (int i : schoolSeatsArray) {
            while (i-- > 0) {
                unfilled++;
            }
        }
        List<Integer> res = new LinkedList();
        res.add(unfilled);
        res.add(unsigned);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> schoolSeatsArray = Arrays.asList(1,3,1,2);
        List<Integer> studentScoreArray = Arrays.asList(99, 78,83,86,92);
        List<List<Integer>> studentSchoolPreferencesArray = new ArrayList<>();
        studentSchoolPreferencesArray.add(Arrays.asList(3,2,1));
        studentSchoolPreferencesArray.add(Arrays.asList(3,0,0));
        studentSchoolPreferencesArray.add(Arrays.asList(2,0,1));
        studentSchoolPreferencesArray.add(Arrays.asList(0,1,3));
        studentSchoolPreferencesArray.add(Arrays.asList(0,2,3));
        System.out.println(allocateSchools(schoolSeatsArray,studentScoreArray,studentSchoolPreferencesArray));

    }
}
