package syntaxTest;

public class overridePrivateMethod {
    static  class Base {
        private void func(){
            System.out.println("In base func method");
        };
        public static void func3() {
            System.out.println("In base func method");
        }
        public void func2() {
            System.out.println("func2");
            func();
        }
    }

    static class Derived extends Base {
        public void func(){   //  Is this an overriding method?
            System.out.println("In Derived Class func method");
        }
        public static void func3() {
            System.out.println("In Derived Class func method");
        }
    }


        public static void main(String [] args) {
            Derived D = new Derived();
            D.func();
            D.func3();
        }

}
