package lilunke.class15;

import java.util.HashSet;

public class DictionaryProblem {
    public boolean canBreak(String input, String[] dict) {
        boolean[] M = new boolean[input.length()];
        HashSet<String> dictionary = new HashSet<>();
        for (int i = 0; i < dict.length; i++) {
            dictionary.add(dict[i]);
        }
        if (dictionary.contains(input.substring(0,1)))
            M[0] = true;
        for (int i = 1; i < input.length(); i++) {
            if (dictionary.contains(input.substring(0, i + 1))) {
                M[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (M[j] && dictionary.contains(input.substring(j + 1, i + 1))) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[input.length() - 1];
    }
    public static void main(String[] args) {
        String[] dictionary = {"abc","ab","cd","de","def", "a"};
        DictionaryProblem here = new DictionaryProblem();
        System.out.println(here.canBreak("abcde", dictionary));
    }
}
