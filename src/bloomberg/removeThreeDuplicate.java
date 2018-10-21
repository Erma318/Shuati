package bloomberg;

public class removeThreeDuplicate {
    public String remove(String input) {
        char[] in = input.toCharArray();
        int end = -1;
        // before end (include end) is the ok output
        for (int i = 0; i < in.length; i++) {
            if (end < 1) {
                in[++end] = in[i];
            } else if (in[end] == in[end - 1] && in[i] == in[end]) {
                end--; end--;
                while(i + 1 < in.length && in[i] == in[i + 1]) {
                    i++;
                }
            } else {
                in[++end] = in[i];
            }
        }
        return new String(in, 0, end + 1);
    }

    public static void main(String[] args) {
        removeThreeDuplicate here = new removeThreeDuplicate();
        System.out.println(here.remove("AABBBBBBBCCCCBADD"));

    }
}
