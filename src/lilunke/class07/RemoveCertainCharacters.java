package lilunke.class07;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        // Write your solution here.
        char[] myChar = input.toCharArray();
        Set<Character> remove = toSet(t);
        int slow = 0;
        for (int fast = 0; fast < myChar.length; fast++ ) {
            if (!remove.contains(myChar[fast])) {
                myChar[slow++] = myChar[fast];
            }
        }
        return new String(myChar, 0, slow);
    }
    private static Set<Character> toSet(String t) {
        Set<Character> res = new HashSet<>();
        char[] myChar = t.toCharArray();
        for (int i = 0; i < t.length(); i++){
            res.add(myChar[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "abccddefffghhh";
        String t = "fc";
        RemoveCertainCharacters here = new RemoveCertainCharacters();
        System.out.println(here.remove(input, t));
    }
}
