package lilunke.class07;

public class RemoveAdjacentRepeatedCharactersIV {
    // have two pointer, slow i, fast, j
// [0, i) is the stack
// [i, j) can be taken as empty
// [j, length - 1] is where we need to check
    public String deDup(String input) {
        // Write your solution here.
        if (input == null || input.length() <= 1) {
            return input;
        }
        int i = 0;
        int j = 0;
        char[] in = input.toCharArray();
        while (j < in.length) {
            if (i == 0 || in[i - 1] != in[j]) {
                in[i] = in[j];
                i++;
                j++;
            } else {
                i--;
                while (j < in.length && in[i] == in[j]) {
                    j++;
                }
            }
        }
        return new String(in, 0, i);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharactersIV here = new RemoveAdjacentRepeatedCharactersIV();
        String res = here.deDup("aa");
        System.out.println(res);
    }
}
