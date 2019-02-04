package syntaxTest;

public class OverLoadParentAndChild {
    static class A {

    }

    static class B extends A{

    }

    static class C extends A {

    }

    static class D extends B {

    }

    public static void print(A a) {
        System.out.println("printA");
    }
    public static void print(B b) {
        System.out.println("printB");
    }
//    public static void print(C c) {
//        System.out.println("printC");
//    }
//    public static void print(D d) {
//        System.out.println("printD");
//    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        print(a);
        print(null);
        print(d);
        print(b);
        print(c);
        print(null);
    }
}
