package pastOA.CernerOA;

public class reverseSentance {
    public String reverseWords(String s) {
        String input = clean(s);
        char[] mychar = input.toCharArray();
        reverse(mychar, 0, mychar.length - 1);
        int start = 0;
        for (int i = 0; i < mychar.length; i++) {
            if (mychar[i] != ' ' && (i == 0 || mychar[i - 1] == ' ')) {
                start = i;
            }
            if (mychar[i] != ' ' && (i == mychar.length - 1 || mychar[i + 1] == ' ')) {
                reverse(mychar, start, i);
            }
//            if (i == 0 || mychar[i - 1] == ' ' && mychar[i] != ' ') {
//                start = i;
//            }
//            if (i != 0 && mychar[i - 1] != ' ' && mychar[i] == ' ') {
//                int end = i - 1;
//                reverse(mychar, start, end);
//            }
//            if (i == mychar.length - 1) {
//                reverse(mychar, start, i);
//            }
        }
        return new String(mychar);
    }

    private String clean(String in) {
        char[] s = in.trim().toCharArray();
        int i = 0;
        int j = 0; // slow
        while (i < s.length) {
            while (i < s.length - 1 && s[i] != ' ') {
                s[j++] = s[i++];
            }
            s[j++] = s[i++];
            while (i < s.length && s[i] == ' ') {
                i++;
            }
        }
        return new String(s, 0, j);
    }

    private void reverse(char[] mychar, int i, int j) {
        while (i < j) {
            char temp = mychar[i];
            mychar[i] = mychar[j];
            mychar[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        reverseSentance here = new reverseSentance();
        System.out.println(here.reverseWords("the sky is blue"));
    }
}