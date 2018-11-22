package syntaxTest;
import syntaxTest.A; //这个可以不要，因为在同一个package底下

import java.util.Random;

public class B {
    public static void main(String[] args) {
        for (int x : A.array) {
            System.out.println(x);
        }
        Random rd = new Random();
        System.out.println(rd.nextInt(0));
    }
}
