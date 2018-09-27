import java.util.*;




public class CodeReview {

    public static void main (String[] args) {
        int[] list = {1,2,3,4,5,6,7};
        for (int i : list) {
            if (i < 5) {
                continue;
            }
            System.out.println(i);
        }
    }
}
