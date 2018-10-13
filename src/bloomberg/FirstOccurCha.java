package bloomberg;

public class FirstOccurCha {
//    // if the same char are alway continues
//    public Character find(String s) {
//
//        int i = 0;
//        int count = 0;
//        int j = 1;
//        for (; j < s.length(); j++) {
//            count++;
//            if (s.charAt(j) != s.charAt(i)) {
//                if (count == 1) {
//                    return s.charAt(i);
//                }
//                i = j;
//                count = 0;
//            }
//        }
//        if (i == j - 1) return s.charAt(i);
//        return null;
//    }

    public Character find(String s) {
        char[] a = new char[26];
        int[] b = new int[26];
        int i = 0;
        for (char x : s.toCharArray()) {
            if (i == 0) {
                a[i++] = x;
                b[x - 'a']++;
                continue;
            }
            if (b[x - 'a'] == 0) {
                a[i++] = x;
                b[x - 'a']++;
            } else {
                b[x - 'a']++;
            }
        }
        System.out.println(a);
        for (int j = 0; j < a.length; j++) {
            if (a[j] != 0 && b[a[j] - 'a'] == 1) {
                return a[j];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s1 = "aabbc";
        String s2 = "aadbcccbb";
        String s3 = "abbbccc";
        FirstOccurCha here = new FirstOccurCha();
        System.out.println(here.find(s1));
        System.out.println(here.find(s2));
        System.out.println(here.find(s3));


    }
}
