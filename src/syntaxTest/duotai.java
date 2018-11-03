package syntaxTest;

import java.util.LinkedList;
import java.util.List;

public class duotai {
    interface A {
        public void haha();
    }

    static class B implements A {
        public void haha() {
            System.out.println("this is B haha");
        }
        public void ha() {
            System.out.println("this is B ha");
        }
    }
    public static void main(String args) {
        A b = new B();
        //b.ha();
        ((B) b).ha();


    }
}
