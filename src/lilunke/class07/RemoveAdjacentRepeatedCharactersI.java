package lilunke.class07;

public class RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        // Write your solution here.
        if (input == null) {
            return null;
        }
        int i = 0;
        int j = 0;
        char[] in = input.toCharArray();
        while (j < in.length) {
            if (i == 0 || in[i - 1] != in[j]) {
                in[i] = in[j];
                i++;
            }
            j++;
        }
        return new String(in, 0, i);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharactersI here = new RemoveAdjacentRepeatedCharactersI();
        String res = here.deDup("abc");
        System.out.println(res);
    }

}
