package lilunke.class08;

public class ReverseString {
    public String reverse(String input) {
        // Write your removeCho2 here
        char[] array = input.toCharArray();
        int i = 0;
        int j = input.length() - 1;
        while (i < j) {
            swap(array, i ,j);
            i++;
            j--;
        }
        return new String(array);
    }
    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    public static void main(String[] args) {
        ReverseString here = new ReverseString();
        System.out.println(here.reverse("yahoo"));
    }
}
