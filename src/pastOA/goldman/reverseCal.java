package pastOA.goldman;

import java.util.HashSet;

/*
1. start with -
2. has two operator connected
*/
public class reverseCal {
    public String reverseCal(String input) {
        HashSet<Character> sign = new HashSet<>();
        sign.add('+');
        sign.add('-');
        sign.add('*');
        sign.add('/');
        char[] array = input.toCharArray();
        int s = 0;
        for (int e = 0; e < array.length; e++) {
            if (e <= array.length - 2 && sign.contains(array[e + 1]) && !sign.contains(array[e])) {
                reverse(array, s, e);
                s = e + 2;
            }
            if (e == array.length - 1){
                reverse(array, s, e);
            }
        }
        reverse(array, 0, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        // String input = "-23-9+2*1";
        reverseCal here = new reverseCal();
        String input = "-1*-2+9--23";
        System.out.println(here.reverseCal(input));
    }
}
