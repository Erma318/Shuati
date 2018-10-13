package syntaxTest;

class SuperClass{



    public static void staticMethod(){

        System.out.println("SuperClass: inside staticMethod");

    }



}


public class SubClass extends SuperClass{



//overriding the static method

    public static void staticMethod(){

        System.out.println("SubClass: inside staticMethod");

    }



    public static void main(String []args){


        SuperClass superClassWithSuperCons = new SuperClass();

        SuperClass superClassWithSubCons = new SubClass();

        SubClass subClassWithSubCons = new SubClass();


        superClassWithSuperCons.staticMethod();

        superClassWithSubCons.staticMethod();

        subClassWithSubCons.staticMethod();



    }


}
