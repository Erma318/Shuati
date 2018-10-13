package pastOA.visaOA;

public class MergeSring {

    static String mergeStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int shortLength = Math.min(a.length(), b.length());
        for (int i = 0; i < shortLength; i++) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }
        if (a.length() == shortLength) {
            sb.append(b.substring(shortLength, b.length()));
        } else {
            sb.append(a.substring(shortLength, a.length()));
        }
        return sb.toString();
    }
}
