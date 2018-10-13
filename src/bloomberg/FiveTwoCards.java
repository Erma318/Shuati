package bloomberg;

import java.util.Arrays;
import java.util.Random;

public class FiveTwoCards {

    private int[] cards = new int[52];
    private int t = 52;
    public FiveTwoCards() {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = i;
        }
    }

    public int drawCards() {
        Random r = new Random();
        int idx = r.nextInt(t);
        int res = cards[idx];
        swap(cards, idx, t - 1);
        t--;
        return res;
    }

    private void swap(int[] cards, int i, int j) {
        int temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

    public static void main(String[] args) {
        FiveTwoCards here = new FiveTwoCards();
        System.out.println(here.drawCards());
        System.out.println(here.drawCards());
        System.out.println(here.drawCards());
        System.out.println(Arrays.toString(here.cards));
    }
}
