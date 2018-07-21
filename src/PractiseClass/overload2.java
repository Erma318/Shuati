package PractiseClass;

public class overload2 {
//    public void happy(Integer x) {
//        System.out.println("Integer");
//    }
//
//    public void happy(String x) {
//        System.out.println("String");
//    }

    public void happy(Object x) {
        System.out.println("Object");
    }

    public void happy(A x) {
        System.out.println("A");
    }
    public void happy(B x) {
        System.out.println("B");
    }
    public static class A {

    }

    public static class B extends A {

    }
    public static void main(String[] args) {
        overload2 here = new overload2();
        here.happy(null);
    }
}
