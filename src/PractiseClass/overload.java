package PractiseClass;

public class overload {
    public static class A {
        public String show(B obj) {
            return ("A and D");
        }
        public String show (A obj) {
            return ("A and A");
        }
    }

    public static class B extends A {
        public String show(D obj) {
            return ("B and B");
        }

        @Override
        public  String show(A obj) {
            return ("B and A");
        }
    }

    public static class C extends B {

    }

    public static class D extends B {

    }

    public static void main (String[] args) {
        A a2 = new B();
        B d = new B();
        System.out.println("1--" + a2.show(d));
    }


}
