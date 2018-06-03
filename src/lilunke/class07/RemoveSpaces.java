package lilunke.class07;

public class RemoveSpaces {
    public String removeSpaces(String input) {
        if (input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
                continue;
            }
            array[end++] = array[i];
        }
        // post-processing: it is possible we still have one trailing space character at the end
        if (end > 0 && array[end - 1] == ' ') {
            return new String(array, 0 ,end - 1);
        }
        return new String(array, 0, end);
    }
    public static void main(String[] args) {
        RemoveSpaces here = new RemoveSpaces();
        String res = here.removeSpaces("   I     love MTV ");
        System.out.println(res);
    }
}
